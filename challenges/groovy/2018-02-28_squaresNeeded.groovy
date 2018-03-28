/*
https://codefights.com/challenge/nKzvoBRt6yX79SEsW

In math class, your teacher has started to give you a number of algebra problems to test your math skills. Among these are a type of problem involving percentages.

A person starts out with a number of squares and circles. He wants to end up with a certain percentage of squares out of the total number of shapes, and needs to find out how many more squares he needs.

Example
For squares = 5, circles = 10 and percentage = 50, the output should be
squaresNeeded(squares, circles, percentage) = 5.
If the person gets 5 more squares, he will have ten squares total. Ten squares is 50% of 20 total shapes (10 squares + 10 circles).
(5 + 5) / (5 + 5 + 10) = 10 / 20 = 0.5 (or 50%).

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer64 squares

The number of squares.

Guaranteed constraints:
0 ≤ squares ≤ 10^10.

[input] integer64 circles

The number of circles.

Guaranteed constraints:
0 ≤ circles ≤ 10^17.

[input] float percentage

The percentage of squares you want out of all shapes.

Guaranteed constraints:
0 ≤ percentage ≤ 99.

[output] integer64

The number of additional squares needed to have the right percentage of squares out of all shapes.
*/

T squaresNeeded(s,c,p) {
 
    
     c/(100-p)*p - s
    
}
