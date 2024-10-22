package business;

import org.junit.jupiter.api.Test;
import org.techideas.entity.Match;
import org.techideas.entity.ScoreBoard;
import org.techideas.exception.NotFoundMatchException;

import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class FinishingMatchTest {

    @Test
    void shouldRemoveMatchesFromScoreBoard() {
        // given
        var scoreBoard = new ScoreBoard();
        scoreBoard.startMatch(new Match("Home Team One", "Away Team One"));
        scoreBoard.startMatch(new Match("Home Team Two", "Away Team Two"));
        scoreBoard.startMatch(new Match("Home Team Three", "Away Team Three"));
        var expectedMatchOne = new Match("Home Team One", "Away Team One");
        var expectedMatchTwo = new Match("Home Team Two", "Away Team Two");
        var expectedMatchThree = new Match("Home Team Three", "Away Team Three");

        // when
        scoreBoard.finishMatch(expectedMatchOne);
        scoreBoard.finishMatch(expectedMatchTwo);
        scoreBoard.finishMatch(expectedMatchThree);

        // then
        assertThat(scoreBoard.showMatches()).returns(0, Collection::size);
    }

    @Test
    void shouldThrowExceptionWhenFinishNonExistingMatch() {
        // given
        var match = new Match("Home Team One", "Away Team One");
        var scoreBoard = new ScoreBoard();

        // when
        assertThatThrownBy(() -> scoreBoard.finishMatch(match))
                .isInstanceOf(NotFoundMatchException.class)
                .hasMessage("The match %s - %s does not exist.".formatted(
                        match.getHomeTeamName(), match.getAwayTeamName()));
    }
}

