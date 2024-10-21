package business;

import org.junit.jupiter.api.Test;
import org.techideas.entity.Match;
import org.techideas.entity.ScoreBoard;
import org.techideas.entity.Team;
import org.techideas.exception.NotFoundMatchException;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UpdatingScoreTest {
/*
    @Test
    void shouldUpdateScoreOfExistingMatch() {
        // given
        var scoreBoard = new ScoreBoard();
        scoreBoard.startMatch(Team.ofNameAndZeroScore("Home Team"), Team.ofNameAndZeroScore("Away Team"));
        var expectedMatch = new Match(
                Team.ofNameAndScore("Home Team", 2),
                Team.ofNameAndScore("Away Team", 1));
        var expectedValues = List.of(expectedMatch);

        // when
        scoreBoard.updateScore(expectedMatch, 1, 0);
        scoreBoard.updateScore(expectedMatch, 1, 1);
        scoreBoard.updateScore(expectedMatch, 2, 1);

        // then
        assertThat(scoreBoard.getOrderedMatches().size()).isEqualTo(1);
        assertThat(scoreBoard.getOrderedMatches().toArray()).containsExactlyElementsOf(expectedValues);
    }

    @Test
    void shouldThrowExceptionWhenUpdateNonExistingMatch() {
        // given
        var match = new Match(Team.ofNameAndZeroScore("Home Team"), Team.ofNameAndZeroScore("Away Team"));
        var scoreBoard = new ScoreBoard();

        // when && then
        assertThatThrownBy(() -> scoreBoard.updateScore(match, 1, 0))
                .isInstanceOf(NotFoundMatchException.class)
                .hasMessage("The match does not exist.");
    }*/
}
