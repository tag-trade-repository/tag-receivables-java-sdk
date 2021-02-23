package br.com.tag.sdk.model.receivable.notification;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/***
 * Classe que encapsula o retorno das consultas de notificação da rejeição de liquidação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-rejei%C3%A7%C3%A3o-de-liquida%C3%A7%C3%A3o">Consulta de Notificão de Rejeição de Liquidação</a>
 * */
public class NotificationSettlementReject extends BaseNotification {

    @JsonProperty("key")
    private String key;

    @JsonProperty("debtor")
    private String debtor;

    @JsonProperty("reasonDetails")
    private String reasonDetails;

    public NotificationSettlementReject(String processKey,
                                        Date createdAt,
                                        Date lastUpdated,
                                        List<String> errors,
                                        Boolean hasError,
                                        String key,
                                        String debtor,
                                        String reasonDetails) {
        super(processKey, createdAt, lastUpdated, errors, hasError);
        this.key = key;
        this.debtor = debtor;
        this.reasonDetails = reasonDetails;
    }

    public NotificationSettlementReject() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public String getReasonDetails() {
        return reasonDetails;
    }

    public void setReasonDetails(String reasonDetails) {
        this.reasonDetails = reasonDetails;
    }

}
