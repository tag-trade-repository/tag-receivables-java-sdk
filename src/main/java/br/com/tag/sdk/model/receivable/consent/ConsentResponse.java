package br.com.tag.sdk.model.receivable.consent;


import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe de resposta a requisição de criação de anuência
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/opt-in">Anuência (Opt In)</a>
 */
public class ConsentResponse extends BaseResponse {

    @JsonProperty("optIns")
    private List<ConsentOutput> consentOutputs = new ArrayList<>();

    public ConsentResponse(List<ConsentOutput> consentOutputs) {
        this.consentOutputs = consentOutputs;
    }

    public ConsentResponse() {
    }

    public List<ConsentOutput> getOptIns() {
        return consentOutputs;
    }

    public void setOptIns(List<ConsentOutput> optInInputItems) {
        this.consentOutputs = optInInputItems;
    }

}
