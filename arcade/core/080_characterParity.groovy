/*
https://codefights.com/arcade/code-arcade/lab-of-transformations/QKnGhkoi4wKr6xY9b

Given a character, check if it represents an odd digit, an even digit or not a digit at all.

Example

For symbol = '5', the output should be
characterParity(symbol) = "odd";
For symbol = '8', the output should be
characterParity(symbol) = "even";
For symbol = 'q', the output should be
characterParity(symbol) = "not a digit".
Input/Output

[time limit] 6000ms (groovy)
[input] char symbol
[output] string
 */

String characterParity(char symbol) {

    symbol.isDigit() ? "$symbol".toInteger() % 2 ? "odd" : "even" : "not a digit"
}
