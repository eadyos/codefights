/*
https://codefights.com/arcade/intro/level-8/rRGGbTtwZe2mA8Wov

Find the leftmost digit that occurs in a given string.

Example

For inputString = "var_1__Int", the output should be
firstDigit(inputString) = '1';
For inputString = "q2q-q", the output should be
firstDigit(inputString) = '2';
For inputString = "0ss", the output should be
firstDigit(inputString) = '0'.
Input/Output

[time limit] 6000ms (groovy)
[input] string inputString

A string containing at least one digit.

Guaranteed constraints:
3 ≤ inputString.length ≤ 10.

[output] char
 */


char firstDigit(String inputString) {

    inputString.find(/\d/)
}
