/*
https://app.codesignal.com/challenge/rjhZpDspevYZTPmx9

World Cup is going on! One of the most fascinating parts of it is the group stage that has recently ended. A lot of great teams face each other to reach the playoff stage. In the group stage, each pair of teams plays exactly one game and each team receives 3 points for a win, 1 point for a draw and 0 points for a loss.
You fell asleep. What a shame. While you were sleeping, your team has played a lot of games! Now you know how many matches your team has played, how many goals it has scored and how many has missed. Now you need to find out the maximum amount of points your team can have.

Example

For matches = 2, goalsFor = 1 and goalsAgainst = 2, the output should be
maxPoints(matches, goalsFor, goalsAgainst) = 3;
For matches = 2, goalsFor = 3 and goalsAgainst = 2, the output should be
maxPoints(matches, goalsFor, goalsAgainst) = 4.
Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer matches

The number of matches your team has played while you were sleeping.

Guaranteed constraints:
1 ≤ matches ≤ 30.

[input] integer goalsFor

The number of goals your team has scored during this time.

Guaranteed constraints:
1 ≤ goalsFor ≤ 100.

[input] integer goalsAgainst

The number of missed goals for your team.

Guaranteed constraints:
1 ≤ goalsAgainst ≤ 100.

[output] integer

The maximal possible number of points your team can have now.

*/

T maxPoints(m, f, a) {
    
    
    T w = --m < f ? m : f 
    f-= w
    T d = m-w
    f==a && d++
    f > a && w++
    w*3 + d 
    
}
