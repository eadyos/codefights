/*
https://codefights.com/challenge/sgcZbafiFjcQq3rnf

Given an integer bound, find the maximal integer n such that 1 + 2 + ... + n ≤ bound.

Example

For bound = 14, the output should be
sumBelowBound(bound) = 4.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer bound

Guaranteed constraints:
1 ≤ bound ≤ 5000.

[output] integer

*/

int sumBelowBound(b) {
 
  ((8*b+1)**0.5 - 1) / 2
    
}
