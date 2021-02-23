package br.com.tag.sdk.model.receivable.contract;

import br.com.tag.sdk.model.response.BasePaginatedQueryResponse;
import br.com.tag.sdk.model.response.PagesOutput;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/***
 * Classe de resposta para consultas paginadas de contrato
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-troca-de-titularidade-por-key">Consulta de Contratos por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-processkey">Consulta de Contratos por Chave de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-referencia">Consulta de Contratos por Referência</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-garantia-ou-troca-de-titularidade-por-parametros">Consulta de Contratos por Parâmetros</a>
 */
public class ContractPaginatedQueryResponse extends BasePaginatedQueryResponse {

    @JsonProperty("contracts")
    private List<ContractQueryOutput> contracts;

    public ContractPaginatedQueryResponse(
            List<ContractQueryOutput> contracts,
            PagesOutput pages,
            String queryKey,
            Date queryDate
    ) {
        super(queryKey, queryDate, pages);
        this.contracts = contracts;
    }

    public ContractPaginatedQueryResponse() {
    }

    public List<ContractQueryOutput> getContracts() {
        return contracts;
    }

    public void setContracts(List<ContractQueryOutput> contracts) {
        this.contracts = contracts;
    }

}
