package br.com.tag.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DivisionMethodType {
    FIXED("Fixed"),
    PERCENTAGE("Percentage"),
    FIXED_AMOUNT("FixedAmount");

    private final String value;

    DivisionMethodType(String value) {
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

    public static DivisionMethodType fromValue(String text) {
        for (DivisionMethodType b : DivisionMethodType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
