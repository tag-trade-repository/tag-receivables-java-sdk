package br.com.tag.sdk.model.receivable.settlement;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Classe de requisição para registro de liquidações
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/informe-de-liquidacao">Registro de Liquidações</a>
 */
public class SettlementRequest {

    @JsonProperty("settlements")
    private List<Settlement> settlements;

    public SettlementRequest(List<Settlement> settlements) {
        this.settlements = settlements;
    }

    public SettlementRequest() {
    }

    public List<Settlement> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<Settlement> settlements) {
        this.settlements = settlements;
    }

}
