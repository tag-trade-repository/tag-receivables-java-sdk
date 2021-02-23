package br.com.tag.sdk;

import br.com.tag.sdk.authorization.IAuthorizer;
import br.com.tag.sdk.factories.AuthorizerFactory;
import br.com.tag.sdk.factories.HttpClientFactory;
import br.com.tag.sdk.http.HttpClient;
import br.com.tag.sdk.model.authentication.Token;
import br.com.tag.sdk.model.authentication.TokenRequest;
import br.com.tag.sdk.model.enums.Profile;

import java.util.EnumMap;
import java.util.Map;

public class SDKOptions {

    private HttpClient webClient;
    private IAuthorizer authorizer;
    private final Map<Profile, Token> tokenMap;
    private final Map<Profile, TokenRequest> credentialMap;
    private String baseUrl;

    public SDKOptions(String baseUrl) {
        this.setBaseUrl(baseUrl);
        this.tokenMap = new EnumMap<>(Profile.class);
        this.credentialMap = new EnumMap<>(Profile.class);
        initializeWebClient();
        initializeAuthorizer();
    }

    private void initializeAuthorizer() {
        if (authorizer == null) {
            this.authorizer = new AuthorizerFactory()
                    .getAuthorizer(this);
        }
    }

    private void initializeWebClient() {
        if (webClient == null) {
            this.webClient = new HttpClientFactory(baseUrl).defaultClient();
        }
    }

    public void setCredential(TokenRequest credentials, Profile profile) {
        this.credentialMap.put(profile, credentials);
    }

    public TokenRequest getCredential(Profile profile) {
        return this.credentialMap.get(profile);
    }

    public Token getToken(Profile profile) {
        return tokenMap.get(profile);
    }

    public void setToken(Profile profile,Token token) {
        this.tokenMap.put(profile, token);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public IAuthorizer getAuthorizer() {
        return authorizer;
    }

    public void setAuthorizer(IAuthorizer authorizer) {
        this.authorizer = authorizer;
    }

    public HttpClient getWebClient() {
        return webClient;
    }

    public void setWebClient(HttpClient webClient) {
        this.webClient = webClient;
    }

}
