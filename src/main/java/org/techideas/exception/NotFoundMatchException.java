package org.techideas.exception;

import static org.techideas.constant.error.ErrorMessages.NOT_FOUND_MATCH_EXCEPTION;

public class NotFoundMatchException extends RuntimeException {

    public NotFoundMatchException(String homeTeam, String awayTeam) {
        super(NOT_FOUND_MATCH_EXCEPTION.formatted(homeTeam, awayTeam));
    }
}
