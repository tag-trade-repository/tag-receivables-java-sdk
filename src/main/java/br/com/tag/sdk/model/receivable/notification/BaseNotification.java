package br.com.tag.sdk.model.receivable.notification;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/***
 * Classe base para retorno de alguns tipos de notificação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-antecipa%C3%A7%C3%A3o-p%C3%B3s-contratada">Consulta de Notificação de Antecipação Pós Contratada</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-contrato">Consulta de Notificação de Ônus e Gravames ou Alteração de Titularidade</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-por-processkey">Consulta de Notificação por Chave de Processo</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-por-key">Consulta de Notificação por Chave</a>
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/consulta-de-notifica%C3%A7%C3%A3o-de-liquida%C3%A7%C3%A3o">Consulta de Notificação de Liquidação</a>
 */
public abstract class BaseNotification {

    @JsonProperty("processKey")
    private String processKey;

    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createdAt;

    @JsonProperty("lastUpdated")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date lastUpdated;

    @JsonProperty("errors")
    private List<String> errors = new ArrayList<>();

    @JsonProperty("hasError")
    private Boolean hasError;

    public BaseNotification(String processKey,
                            Date createdAt,
                            Date lastUpdated,
                            List<String> errors,
                            Boolean hasError) {
        this.processKey = processKey;
        this.createdAt = createdAt;
        this.lastUpdated = lastUpdated;
        this.errors = errors;
        this.hasError = hasError;
    }

    public BaseNotification() {
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }
}
