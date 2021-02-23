package br.com.tag.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ConsentStatus {
    ACTIVE("Active"),
    REJECTED("Reject"),
    INACTIVE("Inactive");

    private final String value;

    ConsentStatus(String value) {
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

    public static ConsentStatus fromValue(String text) {
        for (ConsentStatus b : ConsentStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
