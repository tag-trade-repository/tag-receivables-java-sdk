package br.com.tag.sdk.model.receivable.notification;

import br.com.tag.sdk.model.enums.EventType;
import br.com.tag.sdk.model.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/***
 * Classe que encapsula as repostas das consultas de notificações em uma estrutura padronizada
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-rejei%C3%A7%C3%A3o-de-liquida%C3%A7%C3%A3o">Consulta de Notificão de Rejeição de Liquidação</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-antecipa%C3%A7%C3%A3o-p%C3%B3s-contratada">Consulta de Notificação de Antecipação Pós Contratada</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-contrato">Consulta de Notificação de Ônus e Gravames ou Alteração de Titularidade</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/notificacao-de-opt-in">Consulta de Notificação de Anuência</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-por-processkey">Consulta de Notificação por Chave de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-por-key">Consulta de Notificação por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-liquida%C3%A7%C3%A3o">Consulta de Notificação de Liquidação</a>
 */
public class NotificationDefaultResponse<T> extends BaseResponse {

    @JsonProperty("eventType")
    private EventType eventType;
    @JsonProperty("data")
    private T data;

    public NotificationDefaultResponse(String processKey, Date createdAt, EventType eventType, T data) {
        super(processKey, createdAt);
        this.eventType = eventType;
        this.data = data;
    }

    public NotificationDefaultResponse() {
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
