/*
https://codefights.com/challenge/ypaJW47zSBpJ3b7EJ

Return the number of ways to write the given n as the sum of two prime numbers.

Example
For n = 20, the output should be
gold(n) = 2.
There are two ways to represent 20 as the sum of two prime numbers:

3 + 17 = 20,
7 + 13 = 20.
Input/Output

[time limit] 6000ms (groovy)
[input] integer n

Guaranteed Constraints:
2 ≤ n ≤ 105.

[output] integer

 */


int gold(int n) {
    (0..(n/2)).count{
        [it,n-it].every{new BigInteger(it).isProbablePrime(9)}
    }
}
