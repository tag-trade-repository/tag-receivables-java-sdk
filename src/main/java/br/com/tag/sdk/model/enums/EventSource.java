package br.com.tag.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EventSource {
    CONTRACT_HOLDER("ContractHolder"),
    TRADE_REPOSITORY("TradeRepository");

    private final String value;

    EventSource(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static EventSource fromValue(String text) {
        for (EventSource b : EventSource.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
