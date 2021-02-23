package br.com.tag.sdk.authorization;

import br.com.tag.sdk.Constants;
import br.com.tag.sdk.SDKOptions;
import br.com.tag.sdk.exceptions.TagSDKException;
import br.com.tag.sdk.http.HttpClient;
import br.com.tag.sdk.model.authentication.Token;
import br.com.tag.sdk.model.authentication.TokenRequest;
import br.com.tag.sdk.model.enums.Profile;
import br.com.tag.sdk.model.request.MediaType;
import br.com.tag.sdk.model.request.RequestMethod;
import br.com.tag.sdk.model.request.RequestOptions;

/***
 * Autorizador padrão para recuperação de tokens de acesso
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/autenticacao">Autenticação</a>
 */
public class DefaultAuthorizer implements IAuthorizer {

    private final SDKOptions options;

    public DefaultAuthorizer(SDKOptions options) {
        this.options = options;
    }

    @Override
    public synchronized String getToken(boolean refresh, Profile profile) throws TagSDKException {
        Token tokenObj = options.getToken(profile);

        if (refresh || tokenObj == null) {
            HttpClient restClient = this.options.getWebClient();
            TokenRequest tokenBody = options.getCredential(profile);
            RequestOptions<TokenRequest> requestOptions = new RequestOptions<TokenRequest>()
                    .method(RequestMethod.POST)
                    .uri(Constants.Authentication.BASE_PATH)
                    .header("Content-Type", MediaType.APPLICATION_JSON.toString())
                    .header("Accept", MediaType.APPLICATION_JSON.toString())
                    .body(tokenBody, MediaType.APPLICATION_JSON.toString());
            Token token = restClient.doRequest(requestOptions, Token.class);
            this.options.setToken(profile, token);
        }

        return options.getToken(profile).getAccessToken();
    }


}
