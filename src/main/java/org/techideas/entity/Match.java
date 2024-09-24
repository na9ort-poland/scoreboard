package org.techideas.entity;

import java.time.LocalDateTime;

public record Match(
        Team homeTeam,
        Team awayTeam,
        LocalDateTime createDateTime
) implements Comparable<Match> {

    public Match(Team homeTeam, Team awayTeam) {
        this(homeTeam, awayTeam, LocalDateTime.now());
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
