/*
https://codefights.com/arcade/code-arcade/labyrinth-of-nested-loops/EQSjA5PRfyHueeNkj

Find the number of ways to express n as sum of some (at least two) consecutive positive integers.

Example

For n = 9, the output should be
isSumOfConsecutive2(n) = 2.

There are two ways to represent n = 9: 2 + 3 + 4 = 9 and 4 + 5 = 9.

For n = 8, the output should be
isSumOfConsecutive2(n) = 0.

There are no ways to represent n = 8.

Input/Output

[time limit] 6000ms (groovy)
[input] integer n

A positive integer.

Guaranteed constraints:
1 ≤ n ≤ 25.

[output] integer
 */

int isSumOfConsecutive2(int n) {

    (1..<n).count{
        int total = it
        for(int i = it+1;i < n && total < n;i++){
            total += i
        }
        total == n
    }
}
