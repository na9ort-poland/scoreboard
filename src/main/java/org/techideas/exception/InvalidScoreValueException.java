package org.techideas.exception;

import org.techideas.constant.value.ValueRange;

public class InvalidScoreValueException extends RuntimeException {

    public InvalidScoreValueException(int value) {
        super("Invalid score value: %d. The score value must be between %d and %d values.".formatted(
                value,
                ValueRange.MIN_VALUE.getValue(),
                ValueRange.MAX_VALUE.getValue()));
    }
}
