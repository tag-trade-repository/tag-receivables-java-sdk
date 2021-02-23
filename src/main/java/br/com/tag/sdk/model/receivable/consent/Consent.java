package br.com.tag.sdk.model.receivable.consent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/***
 * Classe base para anuências
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/opt-in">Anuência (Opt In)</a>
 */
public class Consent {

    @JsonProperty("beneficiary")
    private String beneficiary;

    @JsonProperty("assetHolder")
    private String assetHolder;

    @JsonProperty("acquirer")
    private String acquirer;

    @JsonProperty("paymentScheme")
    private String paymentScheme;

    @JsonProperty("signatureDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date signatureDate;

    @JsonProperty("startDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @JsonProperty("endDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public Consent(String beneficiary,
                   String assetHolder,
                   String acquirer,
                   String paymentScheme,
                   Date signatureDate,
                   Date startDate,
                   Date endDate) {
        this.beneficiary = beneficiary;
        this.assetHolder = assetHolder;
        this.acquirer = acquirer;
        this.paymentScheme = paymentScheme;
        this.signatureDate = signatureDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Consent() {
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getAssetHolder() {
        return assetHolder;
    }

    public void setAssetHolder(String assetHolder) {
        this.assetHolder = assetHolder;
    }

    public String getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(String acquirer) {
        this.acquirer = acquirer;
    }

    public String getPaymentScheme() {
        return paymentScheme;
    }

    public void setPaymentScheme(String paymentScheme) {
        this.paymentScheme = paymentScheme;
    }

    public Date getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(Date signatureDate) {
        this.signatureDate = signatureDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
