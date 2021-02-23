package br.com.tag.sdk.model.receivable.consent;

import br.com.tag.sdk.model.enums.ConsentStatus;
import br.com.tag.sdk.model.enums.ConsentType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/***
 * Classe de output para anuências cadastradas
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/opt-in">Anuência (Opt In)</a>
 */
public class ConsentOutput extends Consent {

    @JsonProperty("id")
    private String id;

    @JsonProperty("key")
    private String key;

    @JsonProperty("requester")
    private String requester;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("reject")
    private Boolean reject;

    @JsonProperty("status")
    private ConsentStatus status;

    @JsonProperty("consentType")
    private ConsentType consentType;

    public ConsentOutput(String id,
                         String key,
                         String assetHolder,
                         String requester,
                         String beneficiary,
                         String acquirer,
                         String paymentScheme,
                         Date signatureDate,
                         String origin,
                         Date startDate,
                         Date endDate,
                         Boolean reject,
                         ConsentStatus status,
                         ConsentType consentType) {
        super(beneficiary, assetHolder, acquirer, paymentScheme, signatureDate, startDate, endDate);
        this.id = id;
        this.key = key;
        this.requester = requester;
        this.origin = origin;
        this.reject = reject;
        this.status = status;
        this.consentType = consentType;
    }

    public ConsentOutput() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ConsentType getConsentType() {
        return consentType;
    }

    public void setConsentType(ConsentType consentType) {
        this.consentType = consentType;
    }

}
