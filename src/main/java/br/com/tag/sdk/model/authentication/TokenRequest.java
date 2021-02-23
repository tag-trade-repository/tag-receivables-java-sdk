package br.com.tag.sdk.model.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Classe de requisição com os atributos necessarios para gerar um token de acesso
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/autenticacao"></a>
 */
public class TokenRequest {

    @JsonProperty("client_id")
    private String clientId = null;

    @JsonProperty("client_secret")
    private String clientSecret = null;

    @JsonProperty("audience")
    private String audience = null;

    @JsonProperty("grant_type")
    private String grantType = null;

    public TokenRequest(String clientId, String clientSecret, String audience, String grantType) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.audience = audience;
        this.grantType = grantType;
    }

    public TokenRequest() {}

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}

