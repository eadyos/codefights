/*
https://codefights.com/arcade/intro/level-11/vpfeqDwGZSzYNm2uX

Given some integer, find the maximal number you can obtain by deleting exactly one digit of the given number.

Example

For n = 152, the output should be
deleteDigit(n) = 52;
For n = 1001, the output should be
deleteDigit(n) = 101.
Input/Output

[time limit] 6000ms (groovy)
[input] integer n

Guaranteed constraints:
10 ≤ n ≤ 106.

[output] integer
 */

int deleteDigit(int n) {

    def s = n.toString()
    (0..<s.size()).collect{
        def digits = s.collect{it}
        digits.removeAt(it)
        digits.join().toInteger()
    }.max()
}
