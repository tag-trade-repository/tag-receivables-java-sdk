package br.com.tag.sdk.model.receivable.notification;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe que encapsula o retorno das consultas de notificação de anuência
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/notificacao-de-opt-in">Consulta de Notificação de Anuência</a>
 */
public class NotificationConsentWrapper {

    @JsonProperty("consentNotification")
    public List<NotificationConsent> notificationConsent = new ArrayList<>();

    public NotificationConsentWrapper(List<NotificationConsent> notificationConsent) {
        this.notificationConsent = notificationConsent;
    }

    public NotificationConsentWrapper() {
    }

    public List<NotificationConsent> getNotificationConsent() {
        return notificationConsent;
    }

    public void setNotificationConsent(List<NotificationConsent> notificationConsent) {
        this.notificationConsent = notificationConsent;
    }

}
