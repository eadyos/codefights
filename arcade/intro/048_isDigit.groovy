/*
https://codefights.com/arcade/intro/level-11/Zr2XXEpkBPtYWqPJu

Determine if the given character is a digit or not.

Example

For symbol = '0', the output should be
isDigit(symbol) = true;
For symbol = '-', the output should be
isDigit(symbol) = false.
Input/Output

[time limit] 6000ms (groovy)
[input] char symbol

A character which is either a digit or not.

[output] boolean

true if symbol is a digit, false otherwise.
 */

boolean isDigit(char symbol) {
    symbol ==~ /[0-9]/
}
