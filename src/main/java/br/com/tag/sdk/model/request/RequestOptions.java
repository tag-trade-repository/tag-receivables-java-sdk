package br.com.tag.sdk.model.request;

import java.util.HashMap;
import java.util.Map;

/***
 * Classe genérica com os componentes da requisição HTTP
 * @author 7Comm
 * @version 1.0.0
 */
public class RequestOptions<TBody> {

    private String uri;
    private RequestMethod method;
    private TBody body;
    private String bodyType;
    private final Map<String, String> headers;

    public RequestOptions() {
        this.headers = new HashMap<>();
    }

    public RequestOptions<TBody> uri(String uri) {
        this.uri = uri;
        return this;
    }

    public RequestOptions<TBody> method(RequestMethod method) {
        this.method = method;
        return this;
    }

    public RequestOptions<TBody> header(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public RequestOptions<TBody> body(TBody body, String bodyType) {
        this.body = body;
        this.bodyType = bodyType;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public TBody getBody() {
        return body;
    }

    public String getBodyType() {
        return bodyType;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

}
