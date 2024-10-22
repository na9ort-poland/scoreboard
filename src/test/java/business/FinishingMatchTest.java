package business;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class FinishingMatchTest {
    /*
    @Test
    void shouldRemoveMatchesFromScoreBoard() {
        // given
        var scoreBoard = new ScoreBoard();
        scoreBoard.startMatch(
                Team.ofNameAndZeroScore("Home Team One"),
                Team.ofNameAndZeroScore("Away Team One"));
        scoreBoard.startMatch(
                Team.ofNameAndZeroScore("Home Team Two"),
                Team.ofNameAndZeroScore("Away Team Two"));
        scoreBoard.startMatch(
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
        scoreBoard.finishMatch(expectedMatchOne);
        scoreBoard.finishMatch(expectedMatchTwo);
        scoreBoard.finishMatch(expectedMatchThree);

        // then
        assertThat(scoreBoard.getOrderedMatches().size()).isEqualTo(0);
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
    }*/
}

