/*
https://codefights.com/challenge/pgQanNcBvsqhRcqpF


Given integers l1, r1, l2 and r2, count integers x such that l1 < x < r1 and l2 < x < r2.

Example

For l1 = 1, r1 = 5, l2 = 2 and r2 = 10, the output should be
commonPoints(l1, r1, l2, r2) = 2.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer l1

Guaranteed constraints:
-10 ≤ l1 ≤ 10.

[input] integer r1

Guaranteed constraints:
l1 < r1 ≤ 10.

[input] integer l2

Guaranteed constraints:
-10 ≤ l2 ≤ 10.

[input] integer r2

Guaranteed constraints:
l2 < r2 ≤ 10.

[output] integer

*/

T commonPoints(a, x, b, y) {
    (a+1..<x).count{
        it > b & it < y
    }
}
