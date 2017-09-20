/*
https://codefights.com/arcade/code-arcade/list-forest-edge/gmZFbpR9cirL3Jpf2

Given an integer size, return array of length size filled with 1s.

Example

For size = 4, the output should be
createArray(size) = [1, 1, 1, 1].

Input/Output

[time limit] 6000ms (groovy)
[input] integer size

A positive integer.

Guaranteed constraints:
1 ≤ size ≤ 10.

[output] array.integer
 */

List<Integer> createArray(int size) {

    def a = [].withEagerDefault{1}
    a[size-1]
    a

}
