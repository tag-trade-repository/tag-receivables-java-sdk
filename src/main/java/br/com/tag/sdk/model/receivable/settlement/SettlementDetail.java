package br.com.tag.sdk.model.receivable.settlement;

import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Classe que encapsula o retorno da criação de uma liquidação
 * @author 7Comm
 * @version 1.0.0
 * @see <a href="https://docs.taginfraestrutura.com.br/reference/informe-de-liquidacao">Registro de Liquidações</a>
 */
public class SettlementDetail {

    @JsonProperty("key")
    private String key;

    @JsonProperty("reference")
    private String reference;

    public SettlementDetail(String key, String reference) {
        this.key = key;
        this.reference = reference;
    }

    public SettlementDetail() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
