package business;

import org.junit.jupiter.api.Test;
import org.techideas.entity.Match;
import org.techideas.entity.ScoreBoard;
import org.techideas.exception.DuplicateMatchException;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StartingNewMatchTest {

    @Test
    void shouldAddStartNewMatch() {
        // given
        var scoreBoard = new ScoreBoard();
        var expectedMatch = List.of(new Match("Home Team", "Away Team"));

        // when
        scoreBoard.startMatch("Home Team", "Away Team");

        // then
        assertThat(scoreBoard.showMatches().size()).isEqualTo(1);
        assertThat(scoreBoard.showMatches())
                .returns(1, Collection::size)
                .usingRecursiveComparison()
                .ignoringFields("createdDateTime")
                .isEqualTo(expectedMatch);
    }

    @Test
    void shouldThrowExceptionWhenAddTheSameMatch() {
        // given
        var scoreBoard = new ScoreBoard();
        scoreBoard.startMatch("Home Team", "Away Team");

        // when && then
        assertThatThrownBy(() -> scoreBoard.startMatch("Home Team", "Away Team"))
                .isInstanceOf(DuplicateMatchException.class)
                .hasMessage("The match %s - %s is already exists.".formatted("Home Team", "Away Team"));
    }

    @Test
    void shouldCreateMultipleUniqueMatches() {
        // given
        var scoreBoard = new ScoreBoard();
        var expectedMatches = List.of(
                new Match("Mexico", "Canada"),
                new Match("Spain", "Brazil"),
                new Match("Germany", "France"));

        // when
        scoreBoard.startMatch("Mexico", "Canada");
        scoreBoard.startMatch("Spain", "Brazil");
        scoreBoard.startMatch("Germany", "France");

        // then
        assertThat(scoreBoard.showMatches())
                .returns(3, Collection::size)
                .usingRecursiveComparison()
                .ignoringFields("createdDateTime")
                .isEqualTo(expectedMatches);
    }
}
