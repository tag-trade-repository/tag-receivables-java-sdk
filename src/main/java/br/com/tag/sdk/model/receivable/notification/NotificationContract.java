package br.com.tag.sdk.model.receivable.notification;

import br.com.tag.sdk.model.enums.DocumentType;
import br.com.tag.sdk.model.enums.EventSource;
import br.com.tag.sdk.model.enums.NotificationEventType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/***
 * Classe que encapsula o retorno das consultas de notificação de contrato (Ônus e Gravames ou Alteração de Titularidade)
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-contrato">Consulta de Notificação de Ônus e Gravames ou Alteração de Titularidade</a>
 */
public class NotificationContract extends BaseNotification {

    @JsonProperty("notificationReferenceDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date notificationReferenceDate;

    @JsonProperty("notificationRecipientDocumentType")
    private DocumentType notificationRecipientDocumentType;

    @JsonProperty("notificationRecipient")
    private String notificationRecipient;

    @JsonProperty("contractInfo")
    private NotificationContractInfo notificationContractInfo;

    @JsonProperty("eventType")
    private NotificationEventType eventType;

    @JsonProperty("eventSource")
    private EventSource eventSource;

    public NotificationContract(String processKey,
                                Date createdAt,
                                Date lastUpdated,
                                List<String> errors,
                                Boolean hasError,
                                Date notificationReferenceDate,
                                DocumentType notificationRecipientDocumentType,
                                String notificationRecipient,
                                NotificationContractInfo notificationContractInfo,
                                NotificationEventType eventType,
                                EventSource eventSource) {
        super(processKey, createdAt, lastUpdated, errors, hasError);
        this.notificationReferenceDate = notificationReferenceDate;
        this.notificationRecipientDocumentType = notificationRecipientDocumentType;
        this.notificationRecipient = notificationRecipient;
        this.notificationContractInfo = notificationContractInfo;
        this.eventType = eventType;
        this.eventSource = eventSource;
    }

    public NotificationContract() {
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

    public NotificationContractInfo getContractInfo() {
        return notificationContractInfo;
    }

    public void setContractInfo(NotificationContractInfo notificationContractInfo) {
        this.notificationContractInfo = notificationContractInfo;
    }

    public NotificationEventType getEventType() {
        return eventType;
    }

    public void setEventType(NotificationEventType eventType) {
        this.eventType = eventType;
    }

    public EventSource getEventSource() {
        return eventSource;
    }

    public void setEventSource(EventSource eventSource) {
        this.eventSource = eventSource;
    }

}


