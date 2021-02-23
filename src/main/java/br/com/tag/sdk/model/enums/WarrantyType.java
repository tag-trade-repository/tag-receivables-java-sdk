package br.com.tag.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WarrantyType {
    NONE("None"),
    FIDUCIARY("Fiduciary"),
    PLEDGE("Pledge");

    private final String value;

    WarrantyType(String value) {
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

    public static WarrantyType fromValue(String text) {
        for (WarrantyType b : WarrantyType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
