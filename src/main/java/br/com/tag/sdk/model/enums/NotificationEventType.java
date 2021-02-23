package br.com.tag.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NotificationEventType {
    REGISTER("Register"),
    UPDATE("Update"),
    TERMINATE("Terminate"),
    EXECUTE("Execute");

    private final String value;

    NotificationEventType(String value) {
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

    public static NotificationEventType fromValue(String text) {
        for (NotificationEventType b : NotificationEventType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
