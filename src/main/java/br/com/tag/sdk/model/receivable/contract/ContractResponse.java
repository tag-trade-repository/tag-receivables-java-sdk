package br.com.tag.sdk.model.receivable.contract;

import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Classe de resposta da criação de contrato
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/garantia-ou-troca-de-titularidade">Ônus e Gravames ou Alteração de Titularidade</a>
 */
public class ContractResponse extends BaseResponse {

    @JsonProperty("contracts")
    private List<ContractOutput> contracts = new ArrayList<>();

    public ContractResponse(
            List<ContractOutput> contracts,
            String processKey,
            Date createdAt) {
        super(processKey, createdAt);
        this.contracts = contracts;
    }

    public ContractResponse() {
    }

    public List<ContractOutput> getContracts() {
        return contracts;
    }

    public void setContracts(List<ContractOutput> contracts) {
        this.contracts = contracts;
    }

}
