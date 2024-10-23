package business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.techideas.constant.value.ValueRange;
import org.techideas.entity.Match;
import org.techideas.entity.ScoreBoard;
import org.techideas.exception.InvalidScoreValueException;
import org.techideas.exception.NotFoundMatchException;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.constant.Constants.MAX_SCORE_VALUE;

public class UpdatingScoreTest {

    private ScoreBoard scoreBoard;

    @BeforeEach
    void init() {
        scoreBoard = new ScoreBoard(MAX_SCORE_VALUE);
    }

    @Test
    void shouldUpdateScoreOfExistingMatch() {
        // given
        var newMatch = new Match("Home Team", "Away Team");
        scoreBoard.startMatch(newMatch);
        var expectedMatch = List.of(new Match("Home Team", 2, "Away Team", 1));

        // when
        scoreBoard.updateScore(newMatch, 1, 0);
        scoreBoard.updateScore(newMatch, 1, 1);
        scoreBoard.updateScore(newMatch, 2, 1);

        // then
        assertThat(scoreBoard.showMatches())
                .returns(1, Collection::size)
                .usingRecursiveComparison()
                .ignoringFields("createdDateTime")
                .isEqualTo(expectedMatch);
    }

    @Test
    void shouldThrowExceptionWhenUpdateNonExistingMatch() {
        // given
        var newMatch = new Match("Home Team", "Away Team");

        // when && then
        assertThatThrownBy(() -> scoreBoard.updateScore(newMatch, 1, 0))
                .isInstanceOf(NotFoundMatchException.class)
                .hasMessage("The match %s - %s does not exist.".formatted(
                        newMatch.getHomeTeamName(), newMatch.getAwayTeamName()));
    }

    @Nested
    class InvalidScoreValueUpdate {
        @ParameterizedTest
        @ValueSource(ints = {-1, 10001})
        void shouldThrowExceptionWhenTryToUpdateWithInvalidScoreValueWithDefaultRange(int value) {
            var scoreBoard = new ScoreBoard();
            var newMatch = new Match("Home Team", "Away Team");

            // when && then
            assertThatThrownBy(() -> scoreBoard.updateScore(newMatch, value, 0))
                    .isInstanceOf(InvalidScoreValueException.class)
                    .hasMessage("Invalid score value: %d. The score value must be between %d and %d values."
                            .formatted(value, ValueRange.MIN_VALUE.getValue(), ValueRange.MAX_VALUE.getValue()));
        }

        @ParameterizedTest
        @ValueSource(ints = {-2, 21})
        void shouldThrowExceptionWhenTryToUpdateWithInvalidScoreValueWithResetRange(int value) {
            var newMatch = new Match("Home Team", "Away Team");

            // when && then
            assertThatThrownBy(() -> scoreBoard.updateScore(newMatch, value, 0))
                    .isInstanceOf(InvalidScoreValueException.class)
                    .hasMessage("Invalid score value: %d. The score value must be between %d and %d values."
                            .formatted(value, ValueRange.MIN_VALUE.getValue(), ValueRange.MAX_VALUE.getValue()));
        }
    }
}
