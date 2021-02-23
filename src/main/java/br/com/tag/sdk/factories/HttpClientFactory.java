package br.com.tag.sdk.factories;

import br.com.tag.sdk.http.HttpClient;
import br.com.tag.sdk.http.HttpClientOkHttp;

/***
 * Fábrica concreta para devolução de Clients Http com OkHttp
 * @author 7Comm
 * @version 1.0.0
 */
public class HttpClientFactory {
    private final String url;

    public HttpClientFactory(String url) {
        this.url = url;
    }

    public HttpClient defaultClient() {
        return new HttpClientOkHttp(this.url);
    }
}
