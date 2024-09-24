package org.techideas.entity;

import org.techideas.exception.DuplicateMatchException;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public record ScoreBoard (Set<Match> matches) {

    public ScoreBoard() {
        this(new TreeSet<>());
    }

    public String show() {
        return matches.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining("\\n"));
    }

    public void createMatch(Team homeTeam, Team awayTeam) {
        var match = new Match(homeTeam, awayTeam);

        if (matches.contains(match)) {
            throw new DuplicateMatchException(match);
        }

        matches.add(match);
    }
}
