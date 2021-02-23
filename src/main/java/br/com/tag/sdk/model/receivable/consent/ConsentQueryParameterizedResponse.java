package br.com.tag.sdk.model.receivable.consent;

import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe de resposta para consulta de anuência parametrizada
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-opt-in-por-par%C3%A2metros">Consulta Anuências por Parâmetros</a>
 */
public class ConsentQueryParameterizedResponse extends BaseResponse {

    @JsonProperty("optIns")
    private List<ConsentQueryOutput> optIns = new ArrayList<>();

    public ConsentQueryParameterizedResponse(List<ConsentQueryOutput> optIns) {
        this.optIns = optIns;
    }

    public ConsentQueryParameterizedResponse() {
    }

    public List<ConsentQueryOutput> getOptIns() {
        return optIns;
    }

    public void setOptIns(List<ConsentQueryOutput> optIns) {
        this.optIns = optIns;
    }

}
