package org.techideas.exception;

import org.techideas.entity.Match;

import static org.techideas.constant.error.ErrorMessages.DUPLICATE_MATCH_EXCEPTION;

public class DuplicateMatchException extends RuntimeException {

    public DuplicateMatchException(String homeTeam, String awayTeam) {
        super(DUPLICATE_MATCH_EXCEPTION.formatted(homeTeam, awayTeam));
    }
}
