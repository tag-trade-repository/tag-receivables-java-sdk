package br.com.tag.sdk.model.receivable.settlement;

import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/***
 * Classe de resposta após o registro de liquidações
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/informe-de-liquidacao">Registro de Liquidações</a>
 */
public class SettlementResponse extends BaseResponse {

    @JsonProperty("settlements")
    private List<SettlementDetail> settlements;

    public SettlementResponse(List<SettlementDetail> settlements,
                              String processKey,
                              Date createdAt) {
        super(processKey, createdAt);
        this.settlements = settlements;
    }

    public SettlementResponse() {
    }

    public List<SettlementDetail> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<SettlementDetail> settlements) {
        this.settlements = settlements;
    }

}
