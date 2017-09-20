/*
https://codefights.com/arcade/intro/level-9/AACpNbZANCkhHWNs3

Given a string, output its longest prefix which contains only digits.

Example

For inputString="123aa1", the output should be
longestDigitsPrefix(inputString) = "123".

Input/Output

[time limit] 6000ms (groovy)
[input] string inputString

Guaranteed constraints:
3 ≤ inputString.length ≤ 35.

[output] string
 */

String longestDigitsPrefix(String inputString) {

    def result = (inputString =~ /^\d+/)
    result.count == 0 ? "" : result[0]
}
