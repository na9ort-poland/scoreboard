package business;

import org.junit.jupiter.api.Test;
import org.techideas.entity.Match;
import org.techideas.entity.ScoreBoard;
import org.techideas.entity.Team;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GettingSummaryOfMatchesInProgressTest {
/*
    @Test
    void shouldReturnEmptyListWithNoMatchesOnScoreBoard() {
        // given
        var scoreBoard = new ScoreBoard();

        // when && then
        assertThat(scoreBoard.getOrderedMatches().size()).isEqualTo(0);
    }

    @Test
    void shouldReturnMatchesListOrderedByTotalScore() {
        // given
        var scoreBoard = new ScoreBoard();
        var expectedList = List.of(
                new Match(Team.ofNameAndScore("Mexico", 5), Team.ofNameAndScore("Canada", 5)),
                new Match(Team.ofNameAndScore("Germany", 2), Team.ofNameAndScore("France", 2)),
                new Match(Team.ofNameAndScore("Spain", 1), Team.ofNameAndScore("Brazil", 2)));

        // when
        scoreBoard.startMatch(
                Team.ofNameAndScore("Mexico", 5),
                Team.ofNameAndScore("Canada", 5));
        scoreBoard.startMatch(
                Team.ofNameAndScore("Spain", 1),
                Team.ofNameAndScore("Brazil", 2));
        scoreBoard.startMatch(
                Team.ofNameAndScore("Germany", 2),
                Team.ofNameAndScore("France", 2));

        // then
        assertThat(scoreBoard.getOrderedMatches().size()).isEqualTo(3);
        assertThat(scoreBoard.getOrderedMatches().toArray()).containsExactlyElementsOf(expectedList);
    }

    @Test
    void shouldReturnMatchesListOrderedByCreateDateTime() {
        // given
        var scoreBoard = new ScoreBoard();
        var expectedList = List.of(
                new Match(Team.ofNameAndScore("Uruguay", 6), Team.ofNameAndScore("Italy", 6)),
                new Match(Team.ofNameAndScore("Spain", 10), Team.ofNameAndScore("Brazil", 2)),
                new Match(Team.ofNameAndScore("Mexico", 0), Team.ofNameAndScore("Canada", 5)),
                new Match(Team.ofNameAndScore("Argentina", 3), Team.ofNameAndScore("Australia", 1)),
                new Match(Team.ofNameAndScore("Germany", 2), Team.ofNameAndScore("France", 2)));

        // when
        scoreBoard.startMatch(
                Team.ofNameAndScore("Mexico", 0),
                Team.ofNameAndScore("Canada", 5));
        scoreBoard.startMatch(
                Team.ofNameAndScore("Spain", 10),
                Team.ofNameAndScore("Brazil", 2));
        scoreBoard.startMatch(
                Team.ofNameAndScore("Germany", 2),
                Team.ofNameAndScore("France", 2));
        scoreBoard.startMatch(
                Team.ofNameAndScore("Uruguay", 6),
                Team.ofNameAndScore("Italy", 6));
        scoreBoard.startMatch(
                Team.ofNameAndScore("Argentina", 3),
                Team.ofNameAndScore("Australia", 1));

        // then
        assertThat(scoreBoard.getOrderedMatches().size()).isEqualTo(5);
        assertThat(scoreBoard.getOrderedMatches().toArray()).containsExactlyElementsOf(expectedList);
    }*/
}