package br.com.tag.sdk.factories;

import br.com.tag.sdk.http.HttpClient;

/***
 * Fábrica abstrata para devolução de Clients Http
 * @author 7Comm
 * @version 1.0.0
 */
public interface IHttpClientFactory {
    HttpClient defaultClient();
}