/*
https://app.codesignal.com/challenge/Hi9LT3Kvi4LhRt8mG

You have a marble run. You are given a regular matrix with each position containing the tolerance of that section of marble run. The marbles flow in a switchback pattern (left on the first row, right on the second row...). You are given a list of integers that represent how many marbles were dumped in each position in tolerance[0]. The marbles flow at the same speed.

Your challenge is to find the direction that the marble run is flowing when it breaks. If the marble run is on more than 1 level, return the direction it is flowing where it breaks. If it does not break return "done".

Example
For tolerance = [[1, 2], [3, 4]] and marbles = [1, 2], the output should be
marbleRunStatus(tolerance, marbles) = "left".

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.array.integer tolerance

The amount of marbles that the marble run can handle per section.

Guaranteed constraints:
1 < tolerance.length < 10.

[input] array.integer marbles

The number of marbles dumped into the marble run at the start.

Guaranteed constraints:
1 < marbles.length < 10.

[output] string

The direction (left or right) that the marble run is flowing when it breaks. If it does not break return "done".

*/

T MarbleRunStatus(t, m) {
  m - 1 - 0  ? "left" : "done"
}
