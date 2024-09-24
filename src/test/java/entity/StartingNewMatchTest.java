package entity;

import org.junit.jupiter.api.Test;
import org.techideas.entity.Match;
import org.techideas.entity.ScoreBoard;
import org.techideas.entity.Team;
import org.techideas.exception.DuplicateMatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StartingNewMatchTest {

    @Test
    void shouldAddNewMatchIntoScoreBoard() {
        // given
        var homeTeamName = "Home Team";
        var awayTeamName = "Away Team";
        var homeTeam = new Team(homeTeamName);
        var awayTeam = new Team(awayTeamName);
        var scoreBoard = new ScoreBoard();
        var expectedResult = "%s %d - %s %d".formatted(
                homeTeamName, 0, awayTeamName, 0);

        // when
        scoreBoard.createMatch(homeTeam, awayTeam);

        // then
        assertThat(scoreBoard.show()).isEqualTo(expectedResult);
    }

    @Test
    void shouldThrowExceptionWhenAddTheSameMatch() {
        // given
        var homeTeamName = "Home Team";
        var awayTeamName = "Away Team";
        var homeTeam = new Team(homeTeamName);
        var awayTeam = new Team(awayTeamName);
        var scoreBoard = new ScoreBoard();
        scoreBoard.createMatch(homeTeam, awayTeam);

        // when && then
        assertThatThrownBy(() -> scoreBoard.createMatch(homeTeam, awayTeam))
                .isInstanceOf(DuplicateMatchException.class)
                .hasMessage("The match %s is already exists.".formatted(new Match(homeTeam, awayTeam)));
    }

    @Test
    void shouldCreateMultipleUniqueMatches() {
        // given
        var mexicoTeamName = "Mexico";
        var canadaTeamName = "Canada";
        var spainTeamName = "Spain";
        var brazilTeamName = "Brazil";
        var germanyTeamName = "Germany";
        var franceTeamName = "France";
        var scoreBoard = new ScoreBoard();
        var expectedResult = "%s %d - %s %d\\n%s %d - %s %d\\n%s %d - %s %d".formatted(
                mexicoTeamName, 0,
                canadaTeamName, 0,
                spainTeamName, 0,
                brazilTeamName, 0,
                germanyTeamName, 0,
                franceTeamName, 0);

        // when
        scoreBoard.createMatch(new Team("Mexico"), new Team("Canada"));
        scoreBoard.createMatch(new Team("Spain"), new Team("Brazil"));
        scoreBoard.createMatch(new Team("Germany"), new Team("France"));

        // then
        assertThat(scoreBoard.show()).isEqualTo(expectedResult);
    }
}
