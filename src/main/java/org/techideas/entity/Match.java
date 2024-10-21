package org.techideas.entity;

import java.time.Instant;

public record Match(
        String homeTeamName,
        Integer homeTeamScore,
        String awayTeamName,
        Integer awayTeamScore,
        Instant createdDateTime
) implements Comparable<Match> {
    public Match(String homeTeamName, String awayTeamName) {
        this(homeTeamName, 0, awayTeamName, 0, Instant.now());
    }

    @Override
    public int compareTo(Match match) {
        return (match.homeTeamScore + match.awayTeamScore) - (this.homeTeamScore + this.awayTeamScore);
    }
}
