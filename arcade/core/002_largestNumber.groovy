/*
https://codefights.com/arcade/code-arcade/intro-gates/SZB5XypsMokGusDhX


Given an integer n, return the largest number that contains exactly n digits.

Example

For n = 2, the output should be
largestNumber(n) = 99.

Input/Output

[time limit] 6000ms (groovy)
[input] integer n

Guaranteed constraints:
1 ≤ n ≤ 7.

[output] integer

The largest integer of length n.
 */

int largestNumber(int n) {

    (1..n).collect{"9"}.join().toInteger()
}
