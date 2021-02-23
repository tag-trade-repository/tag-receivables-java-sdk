package br.com.tag.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AccountBankAccountType {
    CC("CC"),
    CD("CD"),
    CG("CG"),
    CI("CI"),
    PG("PG"),
    PP("PP");

    private final String value;

    AccountBankAccountType(String value) {
        this.value = value;
    }

    public static AccountBankAccountType fromValue(String text) {
        for (AccountBankAccountType b : AccountBankAccountType.values()) {
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
