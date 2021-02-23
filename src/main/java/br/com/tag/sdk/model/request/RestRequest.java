package br.com.tag.sdk.model.request;

/***
 * Classe que encapsula o objeto de requisição REST com seus componentes
 * @author 7Comm
 * @version 1.0.0
 */
public class RestRequest<TModel> {

    private RequestOptions<TModel> restRequest;

    public RestRequest() {
    }

    public RestRequest(RequestOptions<TModel> restRequest) {
        this.restRequest = restRequest;
    }

    public RequestOptions<TModel> getRestRequest() {
        return restRequest;
    }

    public void setRestRequest(RequestOptions<TModel> restRequest) {
        this.restRequest = restRequest;
    }

}
