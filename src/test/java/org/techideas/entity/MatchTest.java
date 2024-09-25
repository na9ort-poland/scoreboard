package org.techideas.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTest {

    @Test
    void shouldBeEqualWithSameTeams() {
        // given
        var teamOne = Team.ofNameAndZeroScore("Team One");
        var teamTwo = Team.ofNameAndZeroScore("Team Two");
        var matchOne = new Match(teamOne, teamTwo, LocalDateTime.now());
        var matchTwo = new Match(teamOne, teamTwo, LocalDateTime.now());

        // when && then
        assertThat(matchOne).isEqualTo(matchTwo);
    }

    @Test
    void shouldNotBeEqualWithDifferentTeams() {
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
    void shouldHaveSameHashCodeWithSameTeams() {
        // given
        var teamOne = Team.ofNameAndZeroScore("Team One");
        var teamTwo = Team.ofNameAndZeroScore("Team Two");
        var matchOne = new Match(teamOne, teamTwo, LocalDateTime.now());
        var matchTwo = new Match(teamOne, teamTwo, LocalDateTime.now());

        // when && then
        assertThat(matchOne.hashCode()).isEqualTo(matchTwo.hashCode());
    }

    @Test
    void shouldHaveDifferentHashCodeWithDifferentTeams() {
        // given
        var teamOne = Team.ofNameAndZeroScore("Team One");
        var teamTwo = Team.ofNameAndZeroScore("Team Two");
        var teamThree = Team.ofNameAndZeroScore("Team Three");
        var matchOne = new Match(teamOne, teamTwo, LocalDateTime.now());
        var matchTwo = new Match(teamOne, teamThree, LocalDateTime.now());

        // when && then
        assertThat(matchOne.hashCode()).isNotEqualTo(matchTwo.hashCode());
    }

    @Test
    void shouldBeEqualWithSameTeamsAndDifferentDateTime() {
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

