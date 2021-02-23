package br.com.tag.sdk.model.receivable.settlement;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Classe de requisição para rejeição de liquidações
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/informe-de-rejeicao-de-liquidacao">Rejeição de Liquidações</a>
 */
public class SettlementRejectRequest {

    @JsonProperty("settlements")
    private List<SettlementReject> settlements;

    public SettlementRejectRequest(List<SettlementReject> settlements) {
        this.settlements = settlements;
    }

    public SettlementRejectRequest() {
    }

    public List<SettlementReject> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<SettlementReject> settlements) {
        this.settlements = settlements;
    }

}
