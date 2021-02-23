package br.com.tag.sdk.model.enums;


import com.fasterxml.jackson.annotation.JsonValue;

public enum ContestationType {
    C01("C01"),
    C02("C02"),
    C03("C03"),
    C04("C04"),
    C05("C05"),
    C06("C06");

    private final String value;

    ContestationType(String value) {
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

    public static ContestationType fromValue(String text) {
        for (ContestationType b : ContestationType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
