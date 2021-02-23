package br.com.tag.sdk.model.receivable.consent;

import br.com.tag.sdk.model.enums.ConsentStatus;
import br.com.tag.sdk.model.enums.ConsentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/***
 * Classe de output para consulta de anuência
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-opt-in-por-key">Consulta Anuências por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-opt-in-por-par%C3%A2metros">Consulta Anuências por Parâmetros</a>
 */
public class ConsentQueryOutput extends Consent {

    @JsonProperty("key")
    private String key;

    @JsonProperty("requester")
    private String requester;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("consentType")
    private ConsentType consentType;

    @JsonProperty("reject")
    private Boolean reject;

    @JsonProperty("status")
    private ConsentStatus status;

    @JsonProperty("updatedDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedDate;

    public ConsentQueryOutput(String key,
                              String assetHolder,
                              String requester,
                              String beneficiary,
                              String acquirer,
                              String paymentScheme,
                              Date signatureDate,
                              String origin,
                              ConsentType consentType,
                              Date startDate,
                              Date endDate,
                              Date updatedDate,
                              Boolean reject,
                              ConsentStatus status) {
        super(beneficiary, assetHolder, acquirer, paymentScheme, signatureDate, startDate, endDate);
        this.key = key;
        this.requester = requester;
        this.origin = origin;
        this.consentType = consentType;
        this.reject = reject;
        this.status = status;
        this.updatedDate = updatedDate;
    }

    public ConsentQueryOutput() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public ConsentType getConsentType() {
        return consentType;
    }

    public void setConsentType(ConsentType consentType) {
        this.consentType = consentType;
    }

    public Boolean getReject() {
        return reject;
    }

    public void setReject(Boolean reject) {
        this.reject = reject;
    }

    public ConsentStatus getStatus() {
        return status;
    }

    public void setStatus(ConsentStatus status) {
        this.status = status;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
