package br.com.tag.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ConsentType {
    GRANT("Grant"),
    UPDATE("Update"),
    REVOKE("Revoke");

    private final String value;

    ConsentType(String value) {
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

    public static ConsentType fromValue(String text) {
        for (ConsentType b : ConsentType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
