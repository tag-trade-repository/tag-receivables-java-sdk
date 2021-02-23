package br.com.tag.sdk.model.receivable.settlement;

import br.com.tag.sdk.model.response.BaseQueryResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/***
 * Classe de resposta para consultas de liquidação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-chave">Consulta de Liquidação por Chave</a>
 */
public class SettlementQueryResponse extends BaseQueryResponse {

    @JsonProperty("settlement")
    private SettlementQueryOutput settlement;

    public SettlementQueryResponse(SettlementQueryOutput settlements,
                                   String queryKey,
                                   Date queryDate) {
        super(queryKey, queryDate);
        this.settlement = settlements;
    }

    public SettlementQueryResponse() {
    }

    public SettlementQueryOutput getSettlement() {
        return settlement;
    }

    public void setSettlement(SettlementQueryOutput settlements) {
        this.settlement = settlements;
    }

}
