/*
https://app.codesignal.com/challenge/qw45pMspPFfuPpcEQ/solutions/9gTHRMwDa6CZoaKjG

The Champernowne constant C10 is defined by concatenating representations of successive integers: 12345678910111213....

Given an integer n, find the nth digit (1-based) of C10.

Example

For n = 11, the output should be
champernowneDigit(n) = 0.

The 11th digit of 12345678910111213... is 0.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer n

A positive integer.

Guaranteed constraints:
5 ≤ n ≤ 200.

[output] integer
*/

T champernowneDigit(n) {
  
    (0..n).join()[n] as int

}
