package business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.techideas.entity.Match;
import org.techideas.entity.ScoreBoard;
import org.techideas.exception.DuplicateMatchException;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static util.constant.Constants.MAX_SCORE_VALUE;

public class StartingNewMatchTest {

    private ScoreBoard scoreBoard;

    @BeforeEach
    void init() {
        scoreBoard = new ScoreBoard(MAX_SCORE_VALUE);
    }

    @Test
    void shouldAddStartNewMatch() {
        // given
        var expectedMatch = List.of(new Match("Home Team", "Away Team"));

        // when
        scoreBoard.startMatch(new Match("Home Team", "Away Team"));

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
        scoreBoard.startMatch(new Match("Home Team", "Away Team"));

        // when && then
        assertThatThrownBy(() -> scoreBoard.startMatch(new Match("Home Team", "Away Team")))
                .isInstanceOf(DuplicateMatchException.class)
                .hasMessage("The match %s - %s is already exists.".formatted("Home Team", "Away Team"));
    }

    @Test
    void shouldCreateMultipleUniqueMatches() {
        // given
        var expectedMatches = List.of(
                new Match("Mexico", "Canada"),
                new Match("Spain", "Brazil"),
                new Match("Germany", "France"));

        // when
        scoreBoard.startMatch(new Match("Germany", "France"));
        scoreBoard.startMatch(new Match("Spain", "Brazil"));
        scoreBoard.startMatch(new Match("Mexico", "Canada"));

        // then
        assertThat(scoreBoard.showMatches())
                .returns(3, Collection::size)
                .usingRecursiveComparison()
                .ignoringFields("createdDateTime")
                .isEqualTo(expectedMatches);
    }
}
