package br.com.tag.sdk.model.receivable.consent;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe base para requisição de criação de anuência
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/opt-in">Anuência (Opt In)</a>
 */
public class ConsentRequest {

    @JsonProperty("optIns")
    private List<Consent> consents = new ArrayList<>();

    public ConsentRequest(List<Consent> consents) {
        this.consents = consents;
    }

    public ConsentRequest() {
    }

    public List<Consent> getOptIns() {
        return consents;
    }

    public void setOptIns(List<Consent> consents) {
        this.consents = consents;
    }

}
