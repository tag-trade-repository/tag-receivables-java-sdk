package br.com.tag.sdk.model.receivable.reconciliation;

import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Classe que encapsula a resposta para consulta de uma Conciliação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-processo-de-conciliacao">Consulta de Conciliação</a>
 */
public class ReconciliationQueryResponse extends BaseResponse {

    @JsonProperty("reconciliationKey")
    private String reconciliationKey;

    @JsonProperty("extractionReferenceDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date extractionReferenceDate;

    @JsonProperty("recipientDocumentType")
    private DocumentType recipientDocumentType;

    @JsonProperty("recipient")
    private String recipient;

    @JsonProperty("reconciliationStatus")
    private String reconciliationStatus;

    @JsonProperty("urls")
    private List<String> urls = new ArrayList<>();

    @JsonProperty("pageSize")
    private Integer pageSize;

    @JsonProperty("currentPage")
    private Integer currentPage;

    @JsonProperty("totalElements")
    private Integer totalElements;

    public ReconciliationQueryResponse(String reconciliationKey,
                                       Date extractionReferenceDate,
                                       DocumentType recipientDocumentType,
                                       String recipient,
                                       String reconciliationStatus,
                                       List<String> urls,
                                       String processKey,
                                       Date createdAt,
                                       Integer pageSize,
                                       Integer currentPage,
                                       Integer totalElements) {
        super(processKey, createdAt);
        this.reconciliationKey = reconciliationKey;
        this.extractionReferenceDate = extractionReferenceDate;
        this.recipientDocumentType = recipientDocumentType;
        this.recipient = recipient;
        this.reconciliationStatus = reconciliationStatus;
        this.urls = urls;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalElements = totalElements;
    }

    public ReconciliationQueryResponse() {
    }

    public String getReconciliationKey() {
        return reconciliationKey;
    }

    public void setReconciliationKey(String reconciliationKey) {
        this.reconciliationKey = reconciliationKey;
    }

    public Date getExtractionReferenceDate() {
        return extractionReferenceDate;
    }

    public void setExtractionReferenceDate(Date extractionReferenceDate) {
        this.extractionReferenceDate = extractionReferenceDate;
    }

    public DocumentType getRecipientDocumentType() {
        return recipientDocumentType;
    }

    public void setRecipientDocumentType(DocumentType recipientDocumentType) {
        this.recipientDocumentType = recipientDocumentType;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getReconciliationStatus() {
        return reconciliationStatus;
    }

    public void setReconciliationStatus(String reconciliationStatus) {
        this.reconciliationStatus = reconciliationStatus;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

}
