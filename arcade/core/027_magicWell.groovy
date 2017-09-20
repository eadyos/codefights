/*
https://codefights.com/arcade/code-arcade/loop-tunnel/LbuWRHnMoJH9SAo4o

You are standing at a magical well. It has two positive integers written on it: a and b. Each time you cast a magic marble into the well, it gives you a * b dollars and then both a and b increase by 1. You have n magic marbles. How much money will you make?

Example

For a = 1, b = 2 and n = 2, the output should be
magicalWell(a, b, n) = 8.

You will cast your first marble and get $2, after which the numbers will become 2 and 3. When you cast your second marble, the well will give you $6. Overall, you'll make $8. So, the output is 8.

Input/Output

[time limit] 6000ms (groovy)
[input] integer a

Guaranteed constraints:
1 ≤ a ≤ 2000.

[input] integer b

Guaranteed constraints:
1 ≤ b ≤ 2000.

[input] integer n

The number of magic marbles in your possession, a non-negative integer.

Guaranteed constraints:
0 ≤ n ≤ 5.

[output] integer
 */

int magicalWell(int a, int b, int n) {

    n == 0 ? 0 : (1..n).sum{a++ * b++}
}
