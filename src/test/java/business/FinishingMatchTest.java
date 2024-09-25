package business;

import org.junit.jupiter.api.Test;
import org.techideas.entity.Match;
import org.techideas.entity.ScoreBoard;
import org.techideas.entity.Team;
import org.techideas.exception.NotFoundMatchException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class FinishingMatchTest {

    @Test
    void shouldRemoveMatchesFromScoreBoard() {
        // given
        var scoreBoard = new ScoreBoard();
        var isMatchOneStarted = scoreBoard.startMatch(
                Team.ofNameAndZeroScore("Home Team One"),
                Team.ofNameAndZeroScore("Away Team One"));
        var isMatchTwoStarted = scoreBoard.startMatch(
                Team.ofNameAndZeroScore("Home Team Two"),
                Team.ofNameAndZeroScore("Away Team Two"));
        var isMatchThreeStarted = scoreBoard.startMatch(
                Team.ofNameAndZeroScore("Home Team Three"),
                Team.ofNameAndZeroScore("Away Team Three"));
        var expectedMatchOne = new Match(
                Team.ofNameAndZeroScore("Home Team One"),
                Team.ofNameAndZeroScore("Away Team One"));
        var expectedMatchTwo = new Match(
                Team.ofNameAndZeroScore("Home Team Two"),
                Team.ofNameAndZeroScore("Away Team Two"));
        var expectedMatchThree = new Match(
                Team.ofNameAndZeroScore("Home Team Three"),
                Team.ofNameAndZeroScore("Away Team Three"));

        // when
        var isMatchOneFinished = scoreBoard.finishMatch(expectedMatchOne);
        var isMatchTwoFinished = scoreBoard.finishMatch(expectedMatchTwo);
        var isMatchThreeFinished = scoreBoard.finishMatch(expectedMatchThree);

        // then
        assertThat(isMatchOneStarted).isTrue();
        assertThat(isMatchTwoStarted).isTrue();
        assertThat(isMatchThreeStarted).isTrue();
        assertThat(scoreBoard.getOrderedMatches().size()).isEqualTo(0);
        assertThat(isMatchOneFinished).isTrue();
        assertThat(isMatchTwoFinished).isTrue();
        assertThat(isMatchThreeFinished).isTrue();
    }

    @Test
    void shouldThrowExceptionWhenFinishNonExistingMatch() {
        // given
        var match = new Match(Team.ofNameAndZeroScore("Home Team"), Team.ofNameAndZeroScore("Away Team"));
        var scoreBoard = new ScoreBoard();

        // when
        assertThatThrownBy(() -> scoreBoard.finishMatch(match))
                .isInstanceOf(NotFoundMatchException.class)
                .hasMessage("The match does not exist.");
    }
}

