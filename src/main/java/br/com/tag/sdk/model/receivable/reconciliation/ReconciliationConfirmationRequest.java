package br.com.tag.sdk.model.receivable.reconciliation;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Classe que encapsula a requisição para confirmação de uma Conciliação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/confirmacao-da-conciliacao">Confirmação de Conciliação</a>
 */
public class ReconciliationConfirmationRequest {

    @JsonProperty("reconciliationkey")
    private String reconciliationKey;

    public ReconciliationConfirmationRequest(String reconciliationkey) {
        this.reconciliationKey = reconciliationkey;
    }

    public ReconciliationConfirmationRequest() {
    }

    public String getReconciliationkey() {
        return reconciliationKey;
    }

    public void setReconciliationkey(String reconciliationkey) {
        this.reconciliationKey = reconciliationkey;
    }

}
