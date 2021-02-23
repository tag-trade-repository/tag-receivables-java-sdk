package br.com.tag.sdk.model.receivable.reconciliation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/***
 * Classe que encapsula a requisição para criação de uma Conciliação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/conciliacao">Criação de uma Conciliação</a>
 */
public class ReconciliationRequest {

    @JsonProperty("reconciliationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date reconciliationDate;

    public ReconciliationRequest(Date reconciliationDate) {
        this.reconciliationDate = reconciliationDate;
    }

    public ReconciliationRequest() {
    }

    public Date getReconciliationDate() {
        return reconciliationDate;
    }

    public void setReconciliationDate(Date reconciliationDate) {
        this.reconciliationDate = reconciliationDate;
    }
}
