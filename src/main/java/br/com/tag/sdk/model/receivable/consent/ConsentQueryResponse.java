package br.com.tag.sdk.model.receivable.consent;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Classe de resposta para consulta de anuência
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-opt-in-por-key">Consulta Anuências por Chave</a>
 */
public class ConsentQueryResponse {

    @JsonProperty("optIns")
    private ConsentQueryOutput optIns = new ConsentQueryOutput();

    public ConsentQueryResponse(ConsentQueryOutput optIns) {
        this.optIns = optIns;
    }

    public ConsentQueryResponse() {
    }

    public ConsentQueryOutput getOptIns() {
        return optIns;
    }

    public void setOptIns(ConsentQueryOutput optIns) {
        this.optIns = optIns;
    }

}
