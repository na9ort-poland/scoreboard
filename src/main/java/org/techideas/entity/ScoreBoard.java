package org.techideas.entity;

import org.techideas.exception.DuplicateMatchException;
import org.techideas.exception.NotFoundMatchException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public record ScoreBoard (List<Match> matches) {

    public ScoreBoard() {
        this(new ArrayList<>());
    }

    public List<Match> showMatches() {
        return matches.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void startMatch(String homeTeam, String awayTeam) {
        matches.stream()
                .filter(match -> match.homeTeamName().equals(homeTeam) && match.awayTeamName().equals(awayTeam))
                .findFirst()
                .ifPresent(match -> {throw new DuplicateMatchException(homeTeam, awayTeam);});

        matches.add(new Match(homeTeam, awayTeam));
    }

//    public void updateScore(Match match, int homeTeam, int awayTeam) {
//        checkIfMatchExists(match);
//
//        var updatedMatch = new Match(
//                new Team(match.homeTeam().name(), homeTeam),
//                new Team(match.awayTeam().name(), awayTeam));
//        matches.replace(updatedMatch, null);
//    }
//
//    public void finishMatch(Match match) {
//        checkIfMatchExists(match);
//
//        matches.remove(match);
//    }

//    private void checkIfMatchExists(Match match) {
//        if (!matches.containsKey(match)) {
//            throw new NotFoundMatchException();
//        }
//    }
}
