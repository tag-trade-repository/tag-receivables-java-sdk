package br.com.tag.sdk.model.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Classe que encapsula as informações do token de acesso oauth2 em memória
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/autenticacao"></a>
 */
public class Token {

    @JsonProperty("access_token")
    private String accessToken = null;

    @JsonProperty("scope")
    private String scope = null;

    @JsonProperty("expires_in")
    private Integer expiresIn = null;

    @JsonProperty("token_type")
    private String tokenType = null;

    public Token(String accessToken, String scope, Integer expiresIn, String tokenType) {
        this.accessToken = accessToken;
        this.scope = scope;
        this.expiresIn = expiresIn;
        this.tokenType = tokenType;
    }

    public Token() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}

