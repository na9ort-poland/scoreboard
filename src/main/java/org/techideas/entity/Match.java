package org.techideas.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public record Match(
        Team homeTeam,
        Team awayTeam,
        LocalDateTime createDateTime
) implements Comparable<Match> {

    public Match(Team homeTeam, Team awayTeam) {
        this(homeTeam, awayTeam, LocalDateTime.now());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Match match = (Match) obj;
        return Objects.equals(this.homeTeam.name(), match.homeTeam.name()) &&
                Objects.equals(this.awayTeam.name(), match.awayTeam.name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam.name(), awayTeam.name());
    }

    @Override
    public String toString() {
        return "%s %d - %s %d".formatted(
                homeTeam.name(), homeTeam.score(), awayTeam.name(), awayTeam.score());
    }

    @Override
    public int compareTo(Match match) {
        var scoreMatchOne = this.homeTeam.score() + this.awayTeam.score();
        var scoreMatchTwo = match.homeTeam.score() + match.awayTeam.score();

        if (scoreMatchOne - scoreMatchTwo == 0) {
            return -this.createDateTime().compareTo(match.createDateTime);
        }

        return scoreMatchTwo - scoreMatchOne;
    }
}
