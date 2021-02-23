package br.com.tag.sdk.model.receivable.reconciliation;

import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/***
 * Classe que encapsula a resposta para criação de uma Conciliação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/conciliacao">Criação de uma Conciliação</a>
 */
public class ReconciliationResponse extends BaseResponse {

    @JsonProperty("reconciliationKey")
    private String reconciliationKey;

    @JsonProperty("reconciliationStatus")
    private String reconciliationStatus;

    @JsonProperty("extractionReferenceDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date extractionReferenceDate;

    public ReconciliationResponse(String reconciliationKey,
                                  String reconciliationStatus,
                                  Date extractionReferenceDate) {
        this.reconciliationKey = reconciliationKey;
        this.reconciliationStatus = reconciliationStatus;
        this.extractionReferenceDate = extractionReferenceDate;
    }

    public ReconciliationResponse() {
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

    public Date getExtractionReferenceDate() {
        return extractionReferenceDate;
    }

    public void setExtractionReferenceDate(Date extractionReferenceDate) {
        this.extractionReferenceDate = extractionReferenceDate;
    }

}
