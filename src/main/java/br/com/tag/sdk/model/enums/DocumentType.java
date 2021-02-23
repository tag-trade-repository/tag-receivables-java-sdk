package br.com.tag.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType {
    CPF("CPF"),
    CNPJ("CNPJ");

    private final String value;

    DocumentType(String value) {
        this.value = value;
    }

    public static DocumentType fromValue(String text) {
        for (DocumentType b : DocumentType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
