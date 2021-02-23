package br.com.tag.sdk.model.receivable.register;

import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Classe de resposta após o Registro e Atualização de Ativos Financeiros
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/registro">Registro e Atualização de Ativos Financeiros</a>
 */
public class ReceivableResponse extends BaseResponse {

    @JsonProperty("receivables")
    private List<ReceivableOutput> receivables;

    public ReceivableResponse(List<ReceivableOutput> receivables) {
        this.receivables = receivables;
    }

    public ReceivableResponse() {
    }

    public List<ReceivableOutput> getReceivables() {
        return receivables;
    }

    public void setReceivables(List<ReceivableOutput> receivableItemInputs) {
        this.receivables = receivableItemInputs;
    }

}
