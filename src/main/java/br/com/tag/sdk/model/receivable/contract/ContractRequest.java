package br.com.tag.sdk.model.receivable.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe de requisição para criação de contrato (Ônus e Gravames ou Alteração de Titularidade)
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/garantia-ou-troca-de-titularidade">Ônus e Gravames ou Alteração de Titularidade</a>
 */
public class ContractRequest {

    @JsonProperty("contracts")
    private List<Contract> contracts = new ArrayList<>();

    public ContractRequest() {
    }

    public ContractRequest(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

}
