package br.com.tag.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EffectType {
    WARRANTY("Warranty"),
    OWNERSHIPASSIGNMENT("OwnershipAssignment"),
    PAWN("Pawn");

    private final String value;

    EffectType(String value) {
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

    public static EffectType fromValue(String text) {
        for (EffectType b : EffectType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
