package org.techideas.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.techideas.exception.InvalidScoreValueException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TeamTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 11, 12, 99, 100})
    void shouldCreateMatchWithProperTeamsState(int scoreValue) {
        // given
        var match = new Match(
                Team.ofNameAndScore("Home Team", scoreValue),
                Team.ofNameAndScore("Away Team", scoreValue));

        // when && then
        assertThat(match.homeTeam().score()).isEqualTo(scoreValue);
        assertThat(match.awayTeam().score()).isEqualTo(scoreValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    void shouldThrowExceptionWhenInvalidScoreValue(int scoreValue) {
        // given && when && then
        assertThatThrownBy(() -> new Match(
                Team.ofNameAndScore("Home Team", scoreValue),
                Team.ofNameAndScore("Away Team", scoreValue))
        )
                .isInstanceOf(InvalidScoreValueException.class)
                .hasMessage("The score value must be between %d and %d values.".formatted(0, 100));
    }
}
