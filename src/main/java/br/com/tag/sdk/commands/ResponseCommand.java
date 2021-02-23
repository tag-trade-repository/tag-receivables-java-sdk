package br.com.tag.sdk.commands;

/***
 * Classe de comando para dar semantica e encapsular as repostas as chamadas de API
 * @author 7Comm
 * @version 1.0.0
 */
public class ResponseCommand<TResp> {

    private TResp response;

    public TResp getResponse() {
        return response;
    }

    public void setResponse(TResp response) {
        this.response = response;
    }
}
