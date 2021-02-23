package br.com.tag.sdk.model.receivable.settlement;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Classe base para rejeição de liquidações
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/informe-de-rejeicao-de-liquidacao">Rejeição de Liquidações</a>
 */
public class SettlementReject {

    @JsonProperty("key")
    private String key;

    @JsonProperty("reasonDetails")
    private String reasonDetails;

    public SettlementReject(String key, String reasonDetails) {
        this.key = key;
        this.reasonDetails = reasonDetails;
    }

    public SettlementReject() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getReasonDetails() {
        return reasonDetails;
    }

    public void setReasonDetails(String reasonDetails) {
        this.reasonDetails = reasonDetails;
    }

}
