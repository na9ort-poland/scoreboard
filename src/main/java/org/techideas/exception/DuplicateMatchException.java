package org.techideas.exception;

import org.techideas.entity.Match;

public class DuplicateMatchException extends RuntimeException {

    public DuplicateMatchException(Match match) {
        super("The match %s is already exists.".formatted(match));
    }
}
