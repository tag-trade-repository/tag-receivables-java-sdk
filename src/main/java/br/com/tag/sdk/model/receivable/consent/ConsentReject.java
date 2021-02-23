package br.com.tag.sdk.model.receivable.consent;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Classe base para rejeição de anuência
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/rejei%C3%A7%C3%A3o-opt-in">Rejeição Anuência</a>
 */
public class ConsentReject {

    @JsonProperty("key")
    private String key;

    @JsonProperty("reason")
    private String reason;

    public ConsentReject(String key, String reason) {
        this.key = key;
        this.reason = reason;
    }

    public ConsentReject() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
