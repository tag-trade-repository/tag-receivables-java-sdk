package br.com.tag.sdk.model.receivable.notification;

import br.com.tag.sdk.model.enums.ConsentStatus;
import br.com.tag.sdk.model.enums.ConsentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/***
 * Classe que encapsula a notificação de anuência
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/notificacao-de-opt-in">Consulta de Notificação de Anuência</a>
 */
public class NotificationConsent {

    @JsonProperty("key")
    private String key;

    @JsonProperty("consentType")
    private ConsentType consentType;

    @JsonProperty("consentStatus")
    private ConsentStatus consentStatus;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("assetHolder")
    private String assetHolder;

    @JsonProperty("requester")
    private String requester;

    @JsonProperty("beneficiary")
    private String beneficiary;

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

    public NotificationConsent(String key,
                               ConsentType consentType,
                               ConsentStatus consentStatus,
                               String origin,
                               String assetHolder,
                               String requester,
                               String beneficiary,
                               String paymentScheme,
                               Date signatureDate,
                               Date startDate,
                               Date endDate) {
        this.key = key;
        this.consentType = consentType;
        this.consentStatus = consentStatus;
        this.origin = origin;
        this.assetHolder = assetHolder;
        this.requester = requester;
        this.beneficiary = beneficiary;
        this.paymentScheme = paymentScheme;
        this.signatureDate = signatureDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public NotificationConsent() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ConsentType getConsentType() {
        return consentType;
    }

    public void setConsentType(ConsentType consentType) {
        this.consentType = consentType;
    }

    public ConsentStatus getConsentStatus() {
        return consentStatus;
    }

    public void setConsentStatus(ConsentStatus consentStatus) {
        this.consentStatus = consentStatus;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAssetHolder() {
        return assetHolder;
    }

    public void setAssetHolder(String assetHolder) {
        this.assetHolder = assetHolder;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
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
