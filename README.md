## 1 - Introdução
Esta SDK tem como objetivo facilitar a integração com a Plataforma de Registro da TAG para Recebíveis de Arranjo de Pagamento.

### 1.1 - Perfis de usuário
- Credenciador - ***Acquirer***
- Credor - ***Creditor***

## 2 - Documentação de negócio da API
A documentação de negócio da Api de Registro de Arranjo de Pagamento pode ser encontrada no link: [Documentação API TAG](https://docs.taginfraestrutura.com.br/reference).

## 3 - Como fazer o download do projeto
Para fazer o download da SDK acesse o [repositório]() e clone o projeto utilizando o **Git**. Exemplo:

```shell
 git clone <link-de-clonagem>
```

Para mais informações sobre a instalação do ***git***,
acesse: [Instalação Git](https://git-scm.com/book/pt-br/v2/Come%C3%A7ando-Instalando-o-Git). </br>
Para mais informações sobre ***git*** e seus comandos, acesse: [Documentação Git](https://git-scm.com/doc).

## 4 - Como fazer o build do projeto
Para fazer o build é necessário **abrir** a **pasta raíz** do projeto, abrir
um terminal, e rodar o comando:

```shell
   mvn install
```

Assim todas as dependências serão baixadas e o projeto compilado em um arquivo ***jar***
que pode ser encontrado na pasta ***target***.

Para mais informações sobre o ***maven***, acesse: [Documentação Maven]().  </br>

## 5 - Como adicionar a SDK como dependência

### 5.1 - Como adicionar o SDK em um projeto Maven
A instalação da SDK em um projeto **maven** é muito simples, basta apenas adicionar o trecho abaixo nas depêndencias do
projeto consumidor ***(pom.xml)*** e então fazer o seu build novamente:

````xml
<dependencies>
    <!-- -->
    <dependency>
        <groupId>br.com.tag</groupId>
        <artifactId>sdk</artifactId>
        <version>1.0.0</version>
        <scope>compile</scope>
    </dependency>
    <!-- -->
</dependencies>
````

### 5.2 - Como adicionar o SDK em um projeto Gradle
Para instalação em um projeto ***gradle*** o processo também é igualmente simples, basta adicionar 
a linha do ***snippet*** abaixo nas dependências do ***gradle*** e então refazer o build:

```groovy
dependencies {
    //...
    compile "br.com.tag:sdk:0.0.1-SNAPSHOT"
    //...
}
```

### 5.3 - Como adicionar o *arquivo jar* do SDK em um projeto manualmente
Com a necessidade de uma instalação manual como, por exemplo, em uma aplicação ***JavaEE***, basta pegar o
***jar*** gerado pelo `mvn install` ou `mvn package`, contido na pasta ***target*** com o a seguinte
estrutura ***sdk-< versão >-SNAPSHOT-jar-with-dependencies.jar***, e adicionar a pasta ***WebContent/WEB-INF/lib***. Feito
isso, todos os imports estarão disponíveis e prontos para uso da aplicação consumidora.

## 6 - Como utilizar

### 6.1 - Principais classes
A SDK tem 3 classes principais que devem estar claras para aqueles que querem consumir. 
A primeira é a classe `SDKOptions` que tem como principal objetivo centralizar a configuração da SDK. 
Nela estão contidas configurações como:

* Credenciais de Acesso;
* URL base para APIs de Registro de Arranjo de Pagamento;
* Dependências necessárias para realização das chamadas.

Essas configurações serão necessárias dentro de todo o contexto de uso da SDK e são essenciais para o funcionamento como
um todo. Abaixo temos a estrutura básica dessa classe:

```java
public class SDKOptions {

    private HttpClient webClient;
    private IAuthorizer authorizer;
    private final Map<Profile, Token> tokenMap;
    private final Map<Profile, TokenRequest> credentialMap;
    private String baseUrl;

    //contrutores

    //getters, setters e métodos
}
```

Em segundo lugar temos a classe `TagSDK`, que serve de ponto de entrada para o uso da SDK. A partir dela
criaremos as instâncias dos serviços utilizados para integração com as APIs de Registro de Arranjo de
Pagamento.

```java
public class TagSDK {

    private static final TagServiceCollection factory = null;

    public static TagServiceCollection getServices(SDKOptions options) {
        //lógica de para criação do container abstraído de serviços
    }

    private static void registerServices(Map<String, IService> services, SDKOptions options) {
        //lógica de criação das instâncias dos serviços
    }
}
```

Por fim, porém não menos importante, temos a classe `TagServiceCollection` que representa, de fato, o ponto de acesso
aos serviços da SDK. Podemos dizer que ela é o container que contém as instâncias dos serviços e proporciona um acesso
simples e abstraído aqueles que estão consumindo. O acesso aos serviços é feito a partir de métodos unicos e semânticos
como mostrado no ***snippet*** abaixo:

```java
public class TagServiceCollection {

    private final Map<String, IService> services;

    public TagServiceCollection(Map<String, IService> services) {
        this.services = services;
    }

    public ICommercialEstablishmentService getCommercialEstablishmentService() {
        return (ICommercialEstablishmentService) this.services.get(Constants.Services.COMMERCIAL_ESTABLISHMENT_SERVICE);
    }

    public IAdvancementService getAdvancementService() {
        return (IAdvancementService) this.services.get(Constants.Services.ADVANCEMENT_SERVICE);
    }

    //demais serviços
}
```

### 6.2 - Exemplo de utilização
A utilização da SDK é bem simples, vamos dividi-la em 5 passos:

* Criação e preenchimento de um objeto SDKOptions que encapsulará a configuração da SDK;
* Chamada da classe TagSDK, criação dos serviços e retorno do container de serviços;
* Chamada e utilização de um serviço simples;
* Chamada de método de serviço que recebe um Profile como parâmetro;
* Tratamento de erros retornados pelos serviços;

Primeiramente devemos criar uma instância da classe `SDKOptions`, passando a **URL da API** em seu **construtor**.
Para adicionarmos as configurações de ***credenciais de usuário*** utilizamos o método `setCredential(TokenRequest credentials, Profile profile)` 
contido dentro do objeto de configuração. Este método recebe um objeto do tipo `TokenRequest`, que encapsula as credenciais, 
junto com o `Profile` relacionado aquelas credenciais. A SDK, neste momento, contempla apenas 2 tipos de Profiles, 
***Acquirer*** e ***Creditor***, sendo cada um deles único em relação a configuração, ou seja, caso uma nova credencial seja cadastrada 
com um ***Profile*** já utilizado, esta sobrescreverá a antiga permitindo que tenhamos apenas uma instância de uma credencial do tipo
***Acquirer*** e uma do tipo ***Creditor*** em memória. Exemplo de uso:

```java
public class ExampleConsumer {

    public static void main(String[] args) {
        SDKOptions sdkOptions = new SDKOptions("https://example-url.com.br");

        TokenRequest tokenRequestAcquirer = new TokenRequest();
        tokenRequest.setClientId("example-client-id-acquirer");
        tokenRequest.setClientSecret("example-client-secret-acquirer");
        tokenRequest.setAudience("example-audience");
        tokenRequest.setGrantType("client_credentials");

        TokenRequest tokenRequestCreditor = new TokenRequest();
        tokenRequest.setClientId("example-client-id-creditor");
        tokenRequest.setClientSecret("example-client-secret-creditor");
        tokenRequest.setAudience("example-audience");
        tokenRequest.setGrantType("client_credentials");

        sdkOptions.setCredential(tokenRequestAcquirer, Profile.ACQUIRER);
        sdkOptions.setCredential(tokenRequestCreditor, Profile.CREDITOR);

        //lógica de utilização
    }

}
```

Na sequência precisamos chamar o método `getServices(SDKOptions options)` da classe`TagSDK` passando a nossa
configuração como parâmetro. Esse método é estático e devolve a instância de um [singleton](https://refactoring.guru/design-patterns/singleton)
do tipo `TagServiceCollection` que é o nosso ***container de serviços***. Caso o ***container de serviços*** 
esteja vivo em memória ele sempre devolverá o mesmo, caso contrário ele criará um novo ***container*** com instâncias 
de cada serviço disponível na SDK.

```java
public class ExampleConsumer {

    public static void main(String[] args) {
        //criação e configuração do objeto SDKOptions

        TagServiceCollection fac = TagSDK.getServices(sdkOptions);
    }

}
```

Então para realizar chamadas a API de Registro de Arranjo de Pagamento devemos invocar a instância de um dos serviços
desejados através do nosso ***container de serviços*** e então fazer uma chamada ao método desejado, passando os
parâmetros necessários. No ***snippet*** abaixo é possível observar como realizar uma operação de Registro e 
Atualização de Ativos Financeiros:

```java
public class ExampleConsumer {

    public static void main(String[] args) {
        //criação e configuração do objeto SDKOptions

        TagServiceCollection fac = TagSDK.getServices(sdkOptions);

        /* PEGANDO INSTÂNCIA DO CONTAINER DE SERVIÇOS */
        IReceivableService receivableService = fac.getReceivableService();

        BankAccount bAccount = new BankAccount();
        bAccount.setBranch("4322");
        bAccount.setAccount("00211");
        bAccount.setAccountDigit("X4");
        bAccount.setAccountType(AccountBankAccountType.CC);
        bAccount.setIspb("34100000");
        bAccount.setDocumentType(DocumentType.CPF);
        bAccount.setDocumentNumber("00000000000000");

        Receivable receivable = new Receivable();
        receivable.setReference("UR_450");
        receivable.setDueDate(new Date());
        receivable.setPaymentScheme("VCC");
        receivable.setOriginalAssetHolder("00000000000000");
        receivable.setAmount(5000000L);
        receivable.setPrePaidAmount(0L);
        receivable.setBankAccount(bAccount);

        String processReference = "PR_000";

        List<Receivable> receivables = new ArrayList<>();
        receivables.add(receivable);

        ReceivableRequest receivableRequest = new ReceivableRequest(processReference, receivables);

        /* REALIZANDO CHAMADA */
        ReceivableResponse receivableResponse = receivableService.registerReceivable(receivableRequest);

        /* VISUALIZANDO RESPOSTA */
        List<ReceivableOutput> receivablesOut = receivableResponse.getReceivables();
        receivablesOut.forEach(item -> {
            System.out.println(item.getKey());
            System.out.println(item.getDueDate());
            System.out.println(item.getDebtor());
            System.out.println(item.getReference());
            System.out.println(item.getPaymentScheme());
            System.out.println(item.getOriginalAssetHolder());
        });
    }

}
```

Alguns serviços podem ter chamadas com os dois perfis de credenciais diferentes (***Acquirer*** e ***Creditor***). Neste
caso é necessário indicar o perfil na chamada do método invocado. O ***code snippet*** mostra isso na chamada do método
`insertConsents(ConsentRequest consentRequest, Profile profile)`:

```java
public class ExampleConsumer {

    public static void main(String[] args) {
        //criação e configuração do objeto SDKOptions

        TagServiceCollection fac = TagSDK.getServices(sdkOptions);

        IConsentService consentService = fac.getConsentService();

        Consent optIn = new Consent();
        optIn.setBeneficiary("00000000000000");
        optIn.setPaymentScheme("VCC");
        optIn.setAcquirer("11111111111111");
        optIn.setAssetHolder("22222222222222");
        optIn.setSignatureDate(Date.from(Instant.now()));
        optIn.setStartDate(Date.from(Instant.now()));
        optIn.setEndDate(Date.from(Instant.now()));

        List<Consent> optIns = new ArrayList<>();
        optIns.add(optIn);

        ConsentRequest consentRequest = new ConsentRequest();
        consentRequest.setOptIns(optIns);

        consentService.insertConsents(consentRequest, Profile.ACQUIRER);
    }

}
```

Por fim, a SDK disponibiliza uma **_Exception_** especial, chamada `TagSDKException`,
que encapsula os erros gerados nas chamadas dos serviços. Essa **_Exception_** pode 
ser facilmente tratada com um **_Try catch_** e pode retornar 3 tipos de respostas:

* O HTTP Status retornado pela chamada do serviço apenas;
* O HTTP Status e uma mensagem de erro personalizada;
* O HTTP Status, mensagem de erro gerada pela chamada ao serviço e objeto de erro do tipo `ResponseError`
  (que encapsula o erro gerado pela API).

Abaixo podemos visualizar a estrutura das classes `TagSDKException` e `ResponseError`:

```java
public class TagSDKException extends Exception {

    private static final long serialVersionUID = 1L;
    private HttpStatus status;
    private ResponseError error;

    //construtores

    //getters, setters e outros métodos
}
```

```java
public class ResponseError {

    private final List<String> errors = new ArrayList<>();
    private UUID processKey;
    private Date createdAt;

    //construtores

    //getters, setters e outros métodos
}
```

Em seguida podemos visualizar um exemplo de tratamento de erro:

```java
import br.com.tag.sdk.model.errors.ResponseError;

public class ExampleConsumer {

    public static void main(String[] args) {
        //criação e configuração do objeto SDKOptions
        //recuperação do container de serviços através da classe TagSDK
        //recuperação de um serviço através do container de serviços
        //criação do objeto de request - receivableRequest

        try {
            ReceivableResponse receivableResponse = receivableService.registerReceivable(receivableRequest);
            //lógica de utilização
        } catch (TagSDKException ex) {
            handlingTagSDKErrors(ex);
        }

    }

    public static void handlingTagSDKErrors(TagSDKException ex) {
        if (ex.getStatus() == HttpStatus.BAD_REQUEST) {
            if (ex.getError() != null) {
                ResponseError responseError = ex.getError();
                responseError.getErrors().forEach(error -> {
                    System.out.println(error);
                });
                System.out.println("Process Key: " + responseError.getProcessKey());
                System.out.println("Created At: " + responseError.getCreatedAt());
                System.out.println("HTTP Status: " + ex.getStatus());
                System.out.println("Erro: " + ex.getMessage());
            } else {
                System.out.println("Erro: " + ex.getMessage());
            }
        } else {
            System.out.println("HTTP Status: " + ex.getStatus());
        }
    }

}
```

## 7 - Testes Integrados/Exemplo de consumo de API no ambiente de Non-Prod
A realização dos testes integrados demanda credenciais válidas do ambiente de Non-Prod, 
sendo que essas credenciais são configuradas a partir do arquivo ***application.properties*** 
contido em ***src/test/java/resources***. Esse arquivo possuí a seguinte estrutura:

```properties
url=https://example-url.com.br
auth.acquirer.clientID=example-acquirer-client-id
auth.acquirer.clientSecret=example-acquirer-client-secret
auth.acquirer.audience=example-acquirer-audience
auth.acquirer.grantType=example-acquirer-grant-type
auth.creditor.clientID=example-creditor-client-id
auth.creditor.clientSecret=example-creditor-client-secret
auth.creditor.audience=example-creditor-audience
auth.creditor.grantType=example-creditor-grant-type
```

O exemplo abaixo que foi extraído da classe `BaseTest` e mostra como o arquivo é consumido:

```java
private void loadProperties() throws IOException {
    properties = new Properties();
    properties.load(this.getClass().getResourceAsStream("/application.properties"));
}

private TokenRequest loadCredentials(Profile profile) {
    return new TokenRequest(
        properties.getProperty(String.format("auth.%s.clientID", profile.name().toLowerCase())),
        properties.getProperty(String.format("auth.%s.clientSecret", profile.name().toLowerCase())),
        properties.getProperty(String.format("auth.%s.audience", profile.name().toLowerCase())),
        properties.getProperty(String.format("auth.%s.grantType", profile.name().toLowerCase()))
    );
}
```

Por fim, a execução efetiva dos testes pode ser feita através das classes disponibilizadas em
***src/test/java/br.com.tag.sdk.service*** e estas podem ser utilizadas pelo desenvolvedor para validar chamadas,
entender o fluxo e debugar o código conforme a sua necessidade. O ***snippet*** abaixo mostra a estrutura de uma das
classes de teste disponíveis:

```java
class AdvancementTest extends BaseTest {

    private IAdvancementService adService = null;

    @BeforeAll
    @Override
    public void setup() throws IOException, TagSDKException {
        super.setup();
        adService = this.fac.getAdvancementService();
    }

    @Test
    void insertAdvancementVanillaTest() throws TagSDKException, JsonProcessingException {

        AdvancedReceivable adReceivable = new AdvancedReceivable();
        adReceivable.setAdvancedAmount(BigDecimal.valueOf(100).setScale(2));
        adReceivable.setPaymentScheme("VCC");
        adReceivable.setSettlementObligationDate(Date.from(Instant.now()));

        List<AdvancedReceivable> adReceivables = new ArrayList<>();
        adReceivables.add(adReceivable);

        Advancement adItem = new Advancement();
        adItem.setAssetHolderDocumentType(DocumentType.CNPJ);
        adItem.setAssetHolder("74190072000185");
        adItem.setOperationValue(BigDecimal.valueOf(200).setScale(2));
        adItem.setOperationExpectedSettlementDate(Date.from(Instant.now()));
        adItem.setReference("RF_01");
        adItem.setAdvancedReceivables(adReceivables);

        List<Advancement> adItems = new ArrayList<>();
        adItems.add(adItem);

        AdvancementRequest adInput = new AdvancementRequest();
        adInput.setAdvancements(adItems);

        String item = objectMapper.writeValueAsString(adInput);

        BaseResponse resp = this.adService.insertAdvancements(adInput);

        print(resp.getCreatedAt());
        print(resp.getProcessKey());

        assertNotNull(resp);
    }
}
```