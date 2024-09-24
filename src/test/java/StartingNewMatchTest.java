import org.junit.jupiter.api.Test;
import org.techideas.entity.Match;
import org.techideas.entity.ScoreBoard;
import org.techideas.entity.Team;
import org.techideas.exception.DuplicateMatchException;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StartingNewMatchTest {

    @Test
    void shouldAddNewMatchIntoScoreBoard() {
        // given
        var match = new Match(new Team("Home Team"), new Team("Away Team"));
        var scoreBoard = new ScoreBoard();

        // when
        scoreBoard.addMatch(match);

        // then
        assertThat(scoreBoard.getMatches().size()).isEqualTo(1);
        assertThat(scoreBoard.getMatches().contains(match)).isTrue();
    }

    @Test
    void shouldThrowExceptionWhenAddTheSameMatch() {
        // given
        var match = new Match(new Team("Home Team"), new Team("Away Team"));
        var scoreBoard = new ScoreBoard();
        scoreBoard.addMatch(match);

        // when && then
        assertThatThrownBy(() -> scoreBoard.addMatch(match))
                .isInstanceOf(DuplicateMatchException.class)
                .hasMessage("The match %s is already exists.".formatted(match));
    }

    @Test
    void shouldCreateMultipleUniqueMatches() {
        // given
        var matchMexicoCanada = new Match(new Team("Mexico"), new Team("Canada"));
        var matchSpainBrazil = new Match(new Team("Spain"), new Team("Brazil"));
        var matchGermanyFrance = new Match(new Team("Germany"), new Team("France"));
        var scoreBoard = new ScoreBoard();

        // when
        scoreBoard.addMatch(matchMexicoCanada);
        scoreBoard.addMatch(matchSpainBrazil);
        scoreBoard.addMatch(matchGermanyFrance);

        // then
        assertThat(scoreBoard.getMatches().size()).isEqualTo(3);
        assertThat(scoreBoard.getMatches().contains(matchMexicoCanada)).isTrue();
        assertThat(scoreBoard.getMatches().contains(matchSpainBrazil)).isTrue();
        assertThat(scoreBoard.getMatches().contains(matchGermanyFrance)).isTrue();
    }

    @Test
    void shouldBeOrderedMatchesInScoreBoard() {
        // given
        var matchMexicoCanada = new Match(new Team("Mexico", 0), new Team("Canada", 5));
        var matchSpainBrazil = new Match(new Team("Spain", 10), new Team("Brazil", 2));
        var matchGermanyFrance = new Match(new Team("Germany", 2), new Team("France", 2));
        var matchUruguayItaly = new Match(new Team("Uruguay", 6), new Team("Italy", 6));
        var matchArgentinaAustralia = new Match(new Team("Argentina", 3), new Team("Australia", 1));
        var scoreBoard = new ScoreBoard();
        var expectedList = new ArrayList<Match>();
        expectedList.add(matchUruguayItaly);
        expectedList.add(matchSpainBrazil);
        expectedList.add(matchMexicoCanada);
        expectedList.add(matchArgentinaAustralia);
        expectedList.add(matchGermanyFrance);

        // when
        scoreBoard.addMatch(matchMexicoCanada);
        scoreBoard.addMatch(matchSpainBrazil);
        scoreBoard.addMatch(matchGermanyFrance);
        scoreBoard.addMatch(matchUruguayItaly);
        scoreBoard.addMatch(matchArgentinaAustralia);

        // then
        assertThat(scoreBoard.getMatches().size()).isEqualTo(5);
        assertThat(scoreBoard.getMatches()).isEqualTo(expectedList);
    }
}
