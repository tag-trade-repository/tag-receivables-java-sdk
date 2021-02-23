package br.com.tag.sdk.model.receivable.settlement;

import br.com.tag.sdk.model.response.BasePaginatedQueryResponse;
import br.com.tag.sdk.model.response.PagesOutput;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

// * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-processkey">Consulta de Liquidações por Chave de Processo</a>

/***
 * Classe de retorno para consultas de liquidações paginadas
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-processkey">Consulta de Liquidações por Chave de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-referencia">Consulta de Liquidações por Referência</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-liquidacao-por-parametros">Consulta de Liquidações por Parâmetros</a>
 */
public class SettlementPaginatedQueryResponse extends BasePaginatedQueryResponse {

    @JsonProperty("settlements")
    private List<SettlementQueryOutput> settlements;

    public SettlementPaginatedQueryResponse(String queryKey,
                                            Date queryDate,
                                            PagesOutput pages,
                                            List<SettlementQueryOutput> settlements) {
        super(queryKey, queryDate, pages);
        this.settlements = settlements;
    }

    public SettlementPaginatedQueryResponse() {
    }

    public List<SettlementQueryOutput> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<SettlementQueryOutput> settlements) {
        this.settlements = settlements;
    }

}
