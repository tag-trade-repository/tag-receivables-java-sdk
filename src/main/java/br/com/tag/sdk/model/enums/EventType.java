package br.com.tag.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EventType {
    SETTLEMENT("settlement"),
    CONSENT("consent"),
    SETTLEMENTREJECT("settlementreject"),
    ADVANCEMNT("advancement"),
    DEBTOR("debtor"),
    POSITIONS("position"),
    CONTRACT("contract");

    private final String value;

    EventType(String value) {
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

    public static EventType fromValue(String text) {
        for (EventType b : EventType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}


