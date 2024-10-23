package business;

import org.junit.jupiter.api.Test;
import org.techideas.entity.Match;
import org.techideas.entity.ScoreBoard;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GettingSummaryOfMatchesInProgressTest {

    @Test
    void shouldReturnEmptyListWithNoMatchesOnScoreBoard() {
        // given
        var scoreBoard = new ScoreBoard();

        // when && then
        assertThat(scoreBoard.showMatches()).returns(0, Collection::size);
    }

    @Test
    void shouldReturnMatchesListOrderedByTotalScore() {
        // given
        var scoreBoard = new ScoreBoard();
        var expectedList = List.of(
                new Match("Mexico", 5, "Canada", 5),
                new Match("Germany", 2, "France", 2),
                new Match("Spain", 1, "Brazil", 2));

        // when
        scoreBoard.startMatch(new Match("Mexico", 5, "Canada", 5));
        scoreBoard.startMatch(new Match("Germany", 2, "France", 2));
        scoreBoard.startMatch(new Match("Spain", 1, "Brazil", 2));

        // then
        assertThat(scoreBoard.showMatches())
                .returns(3, Collection::size)
                .usingRecursiveComparison()
                .ignoringFields("createdDateTime")
                .isEqualTo(expectedList);
    }

    @Test
    void shouldReturnMatchesListOrderedByCreateDateTime() {
        // given
        var scoreBoard = new ScoreBoard();
        var expectedList = List.of(
                new Match("Uruguay", 6, "Italy", 6),
                new Match("Spain", 10, "Brazil", 2),
                new Match("Mexico", 0, "Canada", 5),
                new Match("Argentina", 3, "Australia", 1),
                new Match("Germany", 2, "France", 2));

        // when
        scoreBoard.startMatch(new Match("Mexico", 0, "Canada", 5));
        scoreBoard.startMatch(new Match("Spain", 10, "Brazil", 2));
        scoreBoard.startMatch(new Match("Germany", 2, "France", 2));
        scoreBoard.startMatch(new Match("Uruguay", 6, "Italy", 6));
        scoreBoard.startMatch(new Match("Argentina", 3, "Australia", 1));

        // then
        assertThat(scoreBoard.showMatches())
                .returns(5, Collection::size)
                .usingRecursiveComparison()
                .ignoringFields("createdDateTime")
                .isEqualTo(expectedList);
    }
}