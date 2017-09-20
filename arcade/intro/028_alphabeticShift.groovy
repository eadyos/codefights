/*
https://codefights.com/arcade/intro/level-6/PWLT8GBrv9xXy4Dui

Given a string, replace each its character by the next one in the English alphabet (z would be replaced by a).

Example

For inputString = "crazy", the output should be
alphabeticShift(inputString) = "dsbaz".

Input/Output

[time limit] 6000ms (groovy)
[input] string inputString

Non-empty string consisting of lowercase English characters.

Guaranteed constraints:
1 ≤ inputString.length ≤ 10.

[output] string

The result string after replacing all of its characters.
 */

String alphabeticShift(String inputString) {

    inputString.collect{(char)++((int)it)}.join().replaceAll(/\{/,"a")
}
