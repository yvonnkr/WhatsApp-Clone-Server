package com.yvolabs.whatsappclone.shared.error.domain;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 06/10/2024
 */

public final class MissingMandatoryValueException extends AssertionException {

    private MissingMandatoryValueException(String field, String message) {
        super(field, message);
    }

    public static MissingMandatoryValueException forBlankValue(String field) {
        return new MissingMandatoryValueException(field, defaultMessage(field, "blank"));
    }

    public static MissingMandatoryValueException forNullValue(String field) {
        return new MissingMandatoryValueException(field, defaultMessage(field, "null"));
    }

    public static MissingMandatoryValueException forEmptyValue(String field) {
        return new MissingMandatoryValueException(field, defaultMessage(field, "empty"));
    }

    private static String defaultMessage(String field, String reason) {
        return new StringBuilder()
                .append("The field \"")
                .append(field)
                .append("\" is mandatory and wasn't set")
                .append(" (")
                .append(reason)
                .append(")")
                .toString();
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.MISSING_MANDATORY_VALUE;
    }
}
