package business;

import org.junit.jupiter.api.Test;
import org.techideas.entity.Match;
import org.techideas.entity.ScoreBoard;
import org.techideas.entity.Team;
import org.techideas.exception.DuplicateMatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StartingNewMatchTest {

    @Test
    void shouldAddStartNewMatch() {
        // given
        var scoreBoard = new ScoreBoard();
        var expectedMatch = new Match(
                Team.ofNameAndZeroScore("Home Team"),
                Team.ofNameAndZeroScore("Away Team"));

        // when
        scoreBoard.startMatch(
                Team.ofNameAndZeroScore("Home Team"),
                Team.ofNameAndZeroScore("Away Team"));

        // then
        assertThat(scoreBoard.getOrderedMatches().size()).isEqualTo(1);
        assertThat(scoreBoard.getOrderedMatches().toArray()).containsExactlyInAnyOrder(expectedMatch);
    }

    @Test
    void shouldThrowExceptionWhenAddTheSameMatch() {
        // given
        var scoreBoard = new ScoreBoard();
        scoreBoard.startMatch(Team.ofNameAndZeroScore("Home Team"), Team.ofNameAndZeroScore("Away Team"));
        var expectedMatch = new Match(Team.ofNameAndZeroScore("Home Team"), Team.ofNameAndZeroScore("Away Team"));

        // when && then
        assertThatThrownBy(() -> scoreBoard.startMatch(
                Team.ofNameAndZeroScore("Home Team"), Team.ofNameAndZeroScore("Away Team")
        ))
                .isInstanceOf(DuplicateMatchException.class)
                .hasMessage("The match %s is already exists.".formatted(expectedMatch));
    }

    @Test
    void shouldCreateMultipleUniqueMatches() {
        // given
        var scoreBoard = new ScoreBoard();
        var expectedMatchMexicoCanada = new Match(Team.ofNameAndZeroScore("Mexico"), Team.ofNameAndZeroScore("Canada"));
        var expectedMatchSpainBrazil = new Match(Team.ofNameAndZeroScore("Spain"), Team.ofNameAndZeroScore("Brazil"));
        var expectedMatchGermanyFrance = new Match(Team.ofNameAndZeroScore("Germany"), Team.ofNameAndZeroScore("France"));

        // when
        scoreBoard.startMatch(Team.ofNameAndZeroScore("Mexico"), Team.ofNameAndZeroScore("Canada"));
        scoreBoard.startMatch(Team.ofNameAndZeroScore("Spain"), Team.ofNameAndZeroScore("Brazil"));
        scoreBoard.startMatch(Team.ofNameAndZeroScore("Germany"), Team.ofNameAndZeroScore("France"));

        // then
        assertThat(scoreBoard.getOrderedMatches().size()).isEqualTo(3);
        assertThat(scoreBoard.getOrderedMatches().contains(expectedMatchMexicoCanada)).isTrue();
        assertThat(scoreBoard.getOrderedMatches().contains(expectedMatchSpainBrazil)).isTrue();
        assertThat(scoreBoard.getOrderedMatches().contains(expectedMatchGermanyFrance)).isTrue();
    }
}
