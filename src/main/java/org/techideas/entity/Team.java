package org.techideas.entity;

import org.techideas.constant.value.ValueRange;
import org.techideas.exception.InvalidScoreValueException;

public record Team (
        String name,
        Integer score
) {

    public static Team ofNameAndZeroScore(String name) {
        return new Team(name, 0);
    }

    public static Team ofNameAndScore(String name, int score) {
        if (score < ValueRange.MIN_VALUE.getValue() || score > ValueRange.MAX_VALUE.getValue()) {
            throw new InvalidScoreValueException();
        }

        return new Team(name, score);
    }
}
