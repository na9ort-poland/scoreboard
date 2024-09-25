package org.techideas.entity;

import org.techideas.exception.DuplicateMatchException;
import org.techideas.exception.NotFoundMatchException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record ScoreBoard (Map<Match, Object> matches) {

    public ScoreBoard() {
        this(new HashMap<>());
    }

    public List<Match> getOrderedMatches() {
        return matches.keySet().stream()
                .toList()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void startMatch(Team homeTeam, Team awayTeam) {
        var newMatch = new Match(homeTeam, awayTeam);
        if (matches.containsKey(newMatch)) {
            throw new DuplicateMatchException(newMatch);
        }

        matches.put(newMatch, null);
    }

    public void updateScore(Match match, int homeTeam, int awayTeam) {
        checkIfMatchExists(match);

        var updatedMatch = new Match(
                new Team(match.homeTeam().name(), homeTeam),
                new Team(match.awayTeam().name(), awayTeam));
        matches.replace(updatedMatch, null);
    }

    public void finishMatch(Match match) {
        checkIfMatchExists(match);

        matches.remove(match);
    }

    private void checkIfMatchExists(Match match) {
        if (!matches.containsKey(match)) {
            throw new NotFoundMatchException();
        }
    }
}
