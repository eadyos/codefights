/*
https://codefights.com/challenge/j9L3JTkZMz7ETh7Da/solutions/XkLCksTxN98JC2kMm

Find the nth fibonacci number, and return it raised to the power of n.
As the result can be very large, return it as a string.

Example
For n = 3, the output should be
fibAt = "8".
Third Fibonacci number is 2, and 23 = 8.

Input/Output

[time limit] 6000ms (groovy)
[input] integer n

The nth fibonacci number to find, and the exponent to raise it to.

Guaranteed constraints:
0 ≤ n ≤ 300.

[output] string
 */

T fibAt(n) {

    T o=0
    T f=1G

    n.times{
        f=o+(o=f)
    }

    ""+o**n
}