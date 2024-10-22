package org.techideas.entity;

import java.time.Instant;

public class Match implements Comparable<Match> {

    private String homeTeamName;
    private Integer homeTeamScore;
    private String awayTeamName;
    private Integer awayTeamScore;
    private Instant createdDateTime;

    public Match(String homeTeamName, String awayTeamName) {
        this.homeTeamName = homeTeamName;
        this.homeTeamScore = 0;
        this.awayTeamName = awayTeamName;
        this.awayTeamScore = 0;
        this.createdDateTime = Instant.now();
    }

    public Match(String homeTeamName, Integer homeTeamScore, String awayTeamName, Integer awayTeamScore) {
        this.homeTeamName = homeTeamName;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamName = awayTeamName;
        this.awayTeamScore = awayTeamScore;
        this.createdDateTime = Instant.now();
    }

    public void setScore(int homeTeamScore, int awayTeamScore) {
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    @Override
    public int compareTo(Match match) {
        return (match.homeTeamScore + match.awayTeamScore) - (this.homeTeamScore + this.awayTeamScore);
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }
}
