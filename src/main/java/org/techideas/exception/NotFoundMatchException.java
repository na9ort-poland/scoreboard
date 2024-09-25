package org.techideas.exception;

import static org.techideas.constant.error.ErrorMessages.NOT_FOUND_MATCH_EXCEPTION;

public class NotFoundMatchException extends RuntimeException {

    public NotFoundMatchException() {
        super(NOT_FOUND_MATCH_EXCEPTION);
    }
}
