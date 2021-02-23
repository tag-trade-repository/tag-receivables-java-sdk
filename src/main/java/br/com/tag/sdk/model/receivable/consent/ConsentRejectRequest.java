package br.com.tag.sdk.model.receivable.consent;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe para requisição de rejeição de anuência
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/rejei%C3%A7%C3%A3o-opt-in">Rejeição Anuência</a>
 */
public class ConsentRejectRequest {

    @JsonProperty("optIns")
    List<ConsentReject> optIns= new ArrayList<>();

    public ConsentRejectRequest(List<ConsentReject> optIns) {
        this.optIns = optIns;
    }

    public ConsentRejectRequest() {
    }

    public List<ConsentReject> getOptIns() {
        return optIns;
    }

    public void setOptIns(List<ConsentReject> optIns) {
        this.optIns = optIns;
    }

}
