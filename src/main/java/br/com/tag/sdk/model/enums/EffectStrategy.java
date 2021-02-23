package br.com.tag.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EffectStrategy {
    OVERALL("Overall"),
    SPECIFIC("Specific");

    private final String value;

    EffectStrategy(String value) {
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

    public static EffectStrategy fromValue(String text) {
        for (EffectStrategy b : EffectStrategy.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
