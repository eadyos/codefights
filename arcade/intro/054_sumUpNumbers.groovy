/*
https://codefights.com/arcade/intro/level-12/YqZwMJguZBY7Hz84T

CodeMaster has just returned from shopping. He scanned the check of the items he bought and gave the resulting string to Ratiorg to figure out the total number of purchased items. Since Ratiorg is a bot he is definitely going to automate it, so he needs a program that sums up all the numbers which appear in the given input.

Help Ratiorg by writing a function that returns the sum of numbers that appear in the given inputString.

Example

For inputString = "2 apples, 12 oranges", the output should be
sumUpNumbers(inputString) = 14.

Input/Output

[time limit] 6000ms (groovy)
[input] string inputString

Guaranteed constraints:
6 ≤ inputString.length ≤ 60.

[output] integer
 */

int sumUpNumbers(String inputString) {

    def matches = inputString =~ /\d+/
    matches.collect{it as Integer}.sum() ?: 0
}
