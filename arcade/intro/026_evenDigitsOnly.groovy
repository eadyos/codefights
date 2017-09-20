/*
https://codefights.com/arcade/intro/level-6/6cmcmszJQr6GQzRwW

Check if all digits of the given integer are even.

Example

For n = 248622, the output should be
evenDigitsOnly(n) = true;
For n = 642386, the output should be
evenDigitsOnly(n) = false.
Input/Output

[time limit] 4000ms (rb)
[input] integer n

Guaranteed constraints:
1 ≤ n ≤ 109.

[output] boolean

true if all digits of n are even, false otherwise.
 */

boolean evenDigitsOnly(int n) {

    n.toString().chars.every{Character.getNumericValue(it) % 2 == 0}
}
