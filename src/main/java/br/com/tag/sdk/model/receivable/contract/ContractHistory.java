package br.com.tag.sdk.model.receivable.contract;

import br.com.tag.sdk.utils.DecimalDeserializer;
import br.com.tag.sdk.utils.DecimalSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.Date;

/***
 * Classe de consulta de histórico
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-historico-de-garantia-ou-troca-de-titularidade"></a>
 */
public class ContractHistory {

    @JsonProperty("contractDueDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date contractDueDate;

    @JsonProperty("balanceDue")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal balanceDue;

    @JsonProperty("contractStatus")
    private String contractStatus;

    @JsonProperty("reason")
    private Long reason;

    @JsonProperty("reasonDetails")
    private String reasonDetails;

    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;

    public ContractHistory(Date contractDueDate, BigDecimal balanceDue, String contractStatus, Long reason, String reasonDetails, Date createdAt) {
        this.contractDueDate = contractDueDate;
        this.balanceDue = balanceDue;
        this.contractStatus = contractStatus;
        this.reason = reason;
        this.reasonDetails = reasonDetails;
        this.createdAt = createdAt;
    }

    public ContractHistory() {
    }

    public Date getContractDueDate() {
        return contractDueDate;
    }

    public void setContractDueDate(Date contractDueDate) {
        this.contractDueDate = contractDueDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getBalanceDue() {
        return balanceDue;
    }

    public void setBalanceDue(BigDecimal balanceDue) {
        this.balanceDue = balanceDue;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Long getReason() {
        return reason;
    }

    public void setReason(Long reason) {
        this.reason = reason;
    }

    public String getReasonDetails() {
        return reasonDetails;
    }

    public void setReasonDetails(String reasonDetails) {
        this.reasonDetails = reasonDetails;
    }

}
