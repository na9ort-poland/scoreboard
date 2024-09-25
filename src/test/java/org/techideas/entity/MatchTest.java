package org.techideas.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTest {

    @Test
    void matchesWithSameTeamsShouldBeEqual() {
        // given
        var teamOne = Team.ofNameAndZeroScore("Team One");
        var teamTwo = Team.ofNameAndZeroScore("Team Two");
        var matchOne = new Match(teamOne, teamTwo, LocalDateTime.now());
        var matchTwo = new Match(teamOne, teamTwo, LocalDateTime.now().plusDays(1));

        // when && then
        assertThat(matchOne).isEqualTo(matchTwo);
    }

    @Test
    void matchesWithDifferentTeamsShouldNotBeEqual() {
        // given
        var teamOne = Team.ofNameAndZeroScore("Team One");
        var teamTwo = Team.ofNameAndZeroScore("Team Two");
        var teamThree = Team.ofNameAndZeroScore("Team Three");
        var matchOne = new Match(teamOne, teamTwo, LocalDateTime.now());
        var matchTwo = new Match(teamOne, teamThree, LocalDateTime.now());

        // when && then
        assertThat(matchOne).isNotEqualTo(matchTwo);
    }

    @Test
    void matchesWithSameTeamsShouldHaveSameHashCode() {
        // given
        var teamOne = Team.ofNameAndZeroScore("Team One");
        var teamTwo = Team.ofNameAndZeroScore("Team Two");
        var matchOne = new Match(teamOne, teamTwo, LocalDateTime.now());
        var matchTwo = new Match(teamOne, teamTwo, LocalDateTime.now());

        // when && then
        assertThat(matchOne.hashCode()).isEqualTo(matchTwo.hashCode());
    }

    @Test
    void matchesWithDifferentTeamsShouldHaveDifferentHashCode() {
        // given
        var teamOne = Team.ofNameAndZeroScore("Team One");
        var teamTwo = Team.ofNameAndZeroScore("Team Two");
        var teamThree = Team.ofNameAndZeroScore("Team Three");
        var matchOne = new Match(teamOne, teamTwo, LocalDateTime.now());
        var matchTwo = new Match(teamOne, teamThree, LocalDateTime.now());

        // when && then
        assertThat(matchOne.hashCode()).isNotEqualTo(matchTwo);
    }

    @Test
    void matchesWithSameTeamsAndDifferentDateTimeShouldBeEqual() {
        // given
        var teamOne = Team.ofNameAndZeroScore("Team One");
        var teamTwo = Team.ofNameAndZeroScore("Team Two");
        var matchOne = new Match(teamOne, teamTwo, LocalDateTime.now());
        var matchTwo = new Match(teamOne, teamTwo, LocalDateTime.now().plusDays(1));

        // when && then
        assertThat(matchOne).isEqualTo(matchTwo);
    }

    @Test
    void toStringShouldHaveSpecificFormat() {
        // given
        var teamOne = Team.ofNameAndZeroScore("Team One");
        var teamTwo = Team.ofNameAndZeroScore("Team Two");
        var match = new Match(teamOne, teamTwo, LocalDateTime.now());

        // when
        String matchString = match.toString();

        // then
        assertThat(matchString).isEqualTo("Team One 0 - Team Two 0");
    }
}
