package org.techideas.entity;

import org.techideas.exception.DuplicateMatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record ScoreBoard (List<Match> matches) {

    public ScoreBoard() {
        this(new ArrayList<>());
    }

    public List<Match> getMatches() {
        return matches.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void addMatch(Match match) {
        if (matches.contains(match)) {
            throw new DuplicateMatchException(match);
        }

        matches.add(match);
    }
}
