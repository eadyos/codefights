/*
https://codefights.com/challenge/j8P4xyGA7YgWgLwpt

Given an n × n street network. What is the probability that two walkers starting at opposite corners and moving towards the other's corner would meet?
A starts at bottom left and B starts at top right.
A can only walk up and right and B can only walk down and left since they must walk towards opposite corners.
So no backtracking only going forwards.
Probability of choosing a direction is uniformly distributed (50/50)
A and B must make one move each turn.

Example
For n = 2, the output should be
rWalk(n) = 37.5.
gif

Plot

These are all possible ways a meeting can occur.
Assuming they start at (0,0) and (2,2)
(0,2) Can be reached in one way.
Up Up
Left Left

(1,1) Can be reached in four ways.
Up Right
Left Down

Up Right
Down Left

Right Up
Left Down

Right Up
Down Left

(0,2) Can be reached in 1 way
Right Right
Down Down

6 Total ways to meet.

There are 16 possible paths in total.
6 / 16 = 0.375
0.375 * 100 = 37.5%.

Very useful if you wish to spoil yourself. This video shows one possible way to solve. Everyone should be able to submit a solution after watching this.
https://m.youtube.com/watch?v=F_kt51Qj1RI

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer n

Guaranteed constraints:
0 < n ≤ 2^31 - 1.

[output] float

Percent chance of meeting round to 1 decimal place.
*/

T rWalk(n) {
  
  (1 / (Math.PI * n)**0.5 * (1 - 1/(n == 1 ? 8.8 : n > 3 ? 8 : 8.5)/n) * 100).round 1
}



