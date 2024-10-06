package com.yvolabs.whatsappclone.shared.error.domain;

/**
 * @author Yvonne N
 * @version 1.0
 * @since 06/10/2024
 */

public class NullElementInCollectionException extends AssertionException {

    public NullElementInCollectionException(String field) {
        super(field, message(field));
    }

    private static String message(String field) {
        return new StringBuilder().append("The field \"").append(field).append("\" contains a null element").toString();
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.NULL_ELEMENT_IN_COLLECTION;
    }
}