package org.techideas.entity;

import org.techideas.constant.value.ValueRange;
import org.techideas.exception.DuplicateMatchException;
import org.techideas.exception.InvalidScoreValueException;
import org.techideas.exception.NotFoundMatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record ScoreBoard (
        List<Match> matches,
        int maxScoreValue
) {

    public ScoreBoard() {
        this(new ArrayList<>(), ValueRange.MAX_VALUE.getValue());
    }

    public ScoreBoard(int maxScoreValue) {
        this(new ArrayList<>(), maxScoreValue);
    }

    public List<Match> showMatches() {
        return matches.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void startMatch(Match newMatch) {
        if (isMatchPresent(newMatch)) {
            throw new DuplicateMatchException(newMatch.getHomeTeamName(), newMatch.getAwayTeamName());
        }

        matches.add(newMatch);
    }

    public void updateScore(Match updatedMatch, int homeTeamScore, int awayTeamScore) {
        IntStream.of(homeTeamScore, awayTeamScore)
                .filter(this::isScoreValueNotValid)
                .findFirst()
                .ifPresent(individualValue -> {throw new InvalidScoreValueException(individualValue);});

        var foundMatch = matches.stream()
                .filter(match -> match.getHomeTeamName().equals(updatedMatch.getHomeTeamName())
                        && match.getAwayTeamName().equals(updatedMatch.getAwayTeamName()))
                .findFirst()
                .orElseThrow(() -> new NotFoundMatchException(
                        updatedMatch.getHomeTeamName(), updatedMatch.getAwayTeamName()));

        foundMatch.setScore(homeTeamScore, awayTeamScore);
    }

    public void finishMatch(Match deletedMatch) {
        if (!matches.removeIf(match -> match.getHomeTeamName().equals(deletedMatch.getHomeTeamName())
                && match.getAwayTeamName().equals(deletedMatch.getAwayTeamName()))) {
            throw new NotFoundMatchException(deletedMatch.getHomeTeamName(), deletedMatch.getAwayTeamName());
        }
    }

    private boolean isMatchPresent(Match checkedMatch) {
        return matches.stream()
                .anyMatch(match -> match.getHomeTeamName().equals(checkedMatch.getHomeTeamName())
                        && match.getAwayTeamName().equals(checkedMatch.getAwayTeamName()));
    }

    private boolean isScoreValueNotValid(int scoreValue) {
        return scoreValue < ValueRange.MIN_VALUE.getValue() || scoreValue > maxScoreValue;
    }
}
