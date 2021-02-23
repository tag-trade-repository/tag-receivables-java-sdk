package br.com.tag.sdk.model.customer;

import br.com.tag.sdk.model.BankAccount;
import br.com.tag.sdk.model.enums.DocumentType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Classe de output de estabelecimentos comerciais
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/estabelecimento-comercial"></a>
 */
public class CommercialEstablishmentOutput extends CommercialEstablishment {

    @JsonProperty("key")
    private String key;

    public CommercialEstablishmentOutput(String key,
                                         DocumentType documentType,
                                         String documentNumber,
                                         List<String> paymentSchemes,
                                         BankAccount bankAccount) {
        super(documentType, documentNumber, paymentSchemes, bankAccount);
        this.key = key;
    }

    public CommercialEstablishmentOutput() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
