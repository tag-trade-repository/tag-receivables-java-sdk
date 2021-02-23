package br.com.tag.sdk.model.receivable.register;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceivableSettlementOutput {

    @JsonProperty("key")
    private String key;

    @JsonProperty("assetHolder")
    private String assetHolder;

    @JsonProperty("reference")
    private String reference;

    public ReceivableSettlementOutput(String key, String assetHolder, String reference) {
        this.key = key;
        this.assetHolder = assetHolder;
        this.reference = reference;
    }

    public ReceivableSettlementOutput() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAssetHolder() {
        return assetHolder;
    }

    public void setAssetHolder(String assetHolder) {
        this.assetHolder = assetHolder;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
