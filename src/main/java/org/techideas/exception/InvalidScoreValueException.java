package org.techideas.exception;

import org.techideas.constant.value.ValueRange;

public class InvalidScoreValueException extends RuntimeException {

    public InvalidScoreValueException() {
        super("The score value must be between %d and %d values.".formatted(
                ValueRange.MIN_VALUE.getValue(),
                ValueRange.MAX_VALUE.getValue()));
    }
}
