package br.com.tag.sdk.model.receivable.register;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Classe de requisição para o Registro e Atualização de Ativos Financeiros
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/registro">Registro e Atualização de Ativos Financeiros</a>
 */
public class ReceivableRequest {

    @JsonProperty("processReference")
    private String processReference;

    @JsonProperty("receivables")
    private List<Receivable> receivables;

    public ReceivableRequest(String processReference,
                             List<Receivable> receivables) {
        this.processReference = processReference;
        this.receivables = receivables;
    }

    public ReceivableRequest() {
    }

    public String getProcessReference() {
        return processReference;
    }

    public void setProcessReference(String processReference) {
        this.processReference = processReference;
    }

    public List<Receivable> getReceivables() {
        return receivables;
    }

    public void setReceivables(List<Receivable> receivableItemInputs) {
        this.receivables = receivableItemInputs;
    }

}
