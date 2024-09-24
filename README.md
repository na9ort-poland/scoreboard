# Coding Task
You are working in a sports data company, and we would like you to develop a new Live Football
World Cup Scoreboard library that shows all the ongoing matches and their scores.
The scoreboard supports the following operations:
1. Start a new match, assuming initial score 0 – 0 and adding it the scoreboard.
   This should capture following parameters:
   a. Home team
   b. Away team
2. Update score. This should receive a pair of absolute scores: home team score and away
   team score.
3. Finish match currently in progress. This removes a match from the scoreboard.
4. Get a summary of matches in progress ordered by their total score. The matches with the
   same total score will be returned ordered by the most recently started match in the
   scoreboard.

# Test Scenarios

## Starting a New Match
### Scenario 1.1: Adding a new match to the scoreboard.
Test: Create a match with "Team A" and "Team B".
Expected Result: The scoreboard should show the match with the initial score "Team A 0 - 0 Team B".

### Scenario 1.2: Adding a duplicate match to the scoreboard.
Test: Try to create a match with the same "Team A" and "Team B" again.
Expected Result: An error or a message indicating that the match already exists.

### Scenario 1.3: Starting multiple unique matches.
Test: Add three different matches.
Expected Result: All three matches should be displayed on the scoreboard with an initial score of 0 - 0.

## Updating the Score
### Scenario 2.1: Updating the score of an existing match.
Test: Update the score of "Team A" and "Team B" to 1 - 2.
Expected Result: The scoreboard should reflect the updated score "Team A 1 - 2 Team B".

### Scenario 2.2: Updating the score of a non-existent match.
Test: Try to update the score of a match that is not on the scoreboard.
Expected Result: An error or a message indicating that the match does not exist.

### Scenario 2.3: Updating the score to an invalid value (e.g., negative scores).
Test: Try to update a match score with negative values, like -1 - 2.
Expected Result: An error or a message indicating that the score values are invalid.

## Finishing a Match
### Scenario 3.1: Finishing an existing match.
Test: Finish a match between "Team A" and "Team B".
Expected Result: The match should be removed from the scoreboard.

### Scenario 3.2: Finishing a non-existent match.
Test: Try to finish a match that does not exist on the scoreboard.
Expected Result: An error or a message indicating that the match does not exist.

### Scenario 3.3: Finishing all matches.
Test: Add and finish multiple matches.
Expected Result: All matches should be removed from the scoreboard.

## Getting a Summary of Matches in Progress
### Scenario 4.1: Retrieve the summary with no matches in progress.
Test: Request a summary when no matches are in progress.
Expected Result: An empty list or a message indicating no matches are in progress.

### Scenario 4.2: Retrieve the summary with matches sorted by total score.
Test: Add matches with different scores:
"Team A" vs "Team B" with score 2-1 (total 3).
"Team C" vs "Team D" with score 3-1 (total 4).
Expected Result: The matches should be ordered with "Team C vs Team D" first, followed by "Team A vs Team B".

### Scenario 4.3: Retrieve the summary with matches having the same total score.
Test: Add matches with identical total scores but different starting times:
"Team A" vs "Team B" (started first) with score 2-2.
"Team C" vs "Team D" (started later) with score 1-3.
Expected Result: The match started later ("Team C vs Team D") should appear first in the list.
