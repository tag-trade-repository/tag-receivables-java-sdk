package br.com.tag.sdk.model.receivable.notification;

import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.utils.DecimalDeserializer;
import br.com.tag.sdk.utils.DecimalSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Classe que encapsula o retorno das consultas de notificação da Antecipação Pós Contratada
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-antecipa%C3%A7%C3%A3o-p%C3%B3s-contratada">Consulta de Notificação de Antecipação Pós Contratada</a>
 */
public class NotificationAdvancement extends BaseNotification {

    @JsonProperty("key")
    private String key;

    @JsonProperty("notificationReferenceDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date notificationReferenceDate;

    @JsonProperty("notificationRecipientDocumentType")
    private DocumentType notificationRecipientDocumentType;

    @JsonProperty("notificationRecipient")
    private String notificationRecipient;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("assetHolderDocumentType")
    private DocumentType assetHolderDocumentType;

    @JsonProperty("assetHolder")
    private String assetHolder;

    @JsonProperty("operationExpectedSettlementDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date operationExpectedSettlementDate;

    @JsonProperty("operationValue")
    @JsonSerialize(using = DecimalSerializer.class)
    @JsonDeserialize(using = DecimalDeserializer.class)
    private BigDecimal operationValue;

    @JsonProperty("settlementObligations")
    private List<NotificationSettlementObligation> notificationSettlementObligations = new ArrayList<>();

    public NotificationAdvancement(String key,
                                   Date notificationReferenceDate,
                                   DocumentType notificationRecipientDocumentType,
                                   String notificationRecipient,
                                   String reference,
                                   DocumentType assetHolderDocumentType,
                                   String assetHolder,
                                   Date operationExpectedSettlementDate,
                                   BigDecimal operationValue,
                                   List<NotificationSettlementObligation> notificationSettlementObligations,
                                   String processKey,
                                   Date createdAt,
                                   Date lastUpdated,
                                   List<String> errors,
                                   Boolean hasError) {
        super(processKey, createdAt, lastUpdated, errors, hasError);
        this.key = key;
        this.notificationReferenceDate = notificationReferenceDate;
        this.notificationRecipientDocumentType = notificationRecipientDocumentType;
        this.notificationRecipient = notificationRecipient;
        this.reference = reference;
        this.assetHolderDocumentType = assetHolderDocumentType;
        this.assetHolder = assetHolder;
        this.operationExpectedSettlementDate = operationExpectedSettlementDate;
        this.operationValue = operationValue;
        this.notificationSettlementObligations = notificationSettlementObligations;
    }

    public NotificationAdvancement() {
        super();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getNotificationReferenceDate() {
        return notificationReferenceDate;
    }

    public void setNotificationReferenceDate(Date notificationReferenceDate) {
        this.notificationReferenceDate = notificationReferenceDate;
    }

    public DocumentType getNotificationRecipientDocumentType() {
        return notificationRecipientDocumentType;
    }

    public void setNotificationRecipientDocumentType(DocumentType notificationRecipientDocumentType) {
        this.notificationRecipientDocumentType = notificationRecipientDocumentType;
    }

    public String getNotificationRecipient() {
        return notificationRecipient;
    }

    public void setNotificationRecipient(String notificationRecipient) {
        this.notificationRecipient = notificationRecipient;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public DocumentType getAssetHolderDocumentType() {
        return assetHolderDocumentType;
    }

    public void setAssetHolderDocumentType(DocumentType assetHolderDocumentType) {
        this.assetHolderDocumentType = assetHolderDocumentType;
    }

    public String getAssetHolder() {
        return assetHolder;
    }

    public void setAssetHolder(String assetHolder) {
        this.assetHolder = assetHolder;
    }

    public Date getOperationExpectedSettlementDate() {
        return operationExpectedSettlementDate;
    }

    public void setOperationExpectedSettlementDate(Date operationExpectedSettlementDate) {
        this.operationExpectedSettlementDate = operationExpectedSettlementDate;
    }

    public BigDecimal getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(BigDecimal operationValue) {
        this.operationValue = operationValue;
    }

    public List<NotificationSettlementObligation> getSettlementObligations() {
        return notificationSettlementObligations;
    }

    public void setSettlementObligations(List<NotificationSettlementObligation> notificationSettlementObligations) {
        this.notificationSettlementObligations = notificationSettlementObligations;
    }

}

