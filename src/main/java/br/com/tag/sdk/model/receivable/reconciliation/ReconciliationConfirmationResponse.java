package br.com.tag.sdk.model.receivable.reconciliation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/***
 * Classe que encapsula a resposta para confirmação de uma Conciliação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/confirmacao-da-conciliacao">Confirmação de Conciliação</a>
 */
public class ReconciliationConfirmationResponse {

    @JsonProperty("reconciliationKey")
    private String reconciliationKey;

    @JsonProperty("reconciliationStatus")
    private String reconciliationStatus;

    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date createdAt;

    public ReconciliationConfirmationResponse(String reconciliationKey,
                                              String reconciliationStatus,
                                              Date createdAt) {
        this.reconciliationKey = reconciliationKey;
        this.reconciliationStatus = reconciliationStatus;
        this.createdAt = createdAt;
    }

    public ReconciliationConfirmationResponse() {
    }

    public ReconciliationConfirmationResponse(String reconciliationKey) {
        this.reconciliationKey = reconciliationKey;
    }

    public String getReconciliationKey() {
        return reconciliationKey;
    }

    public void setReconciliationKey(String reconciliationKey) {
        this.reconciliationKey = reconciliationKey;
    }

    public String getReconciliationStatus() {
        return reconciliationStatus;
    }

    public void setReconciliationStatus(String reconciliationStatus) {
        this.reconciliationStatus = reconciliationStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
