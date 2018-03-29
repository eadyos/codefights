/*
https://codefights.com/arcade/code-arcade/regular-hell/YhqzFvdnHMffQA22q


Implement a function that replaces each digit in the given string with a '#' character.

Example

For input = "There are 12 points", the output should be
replaceAllDigitsRegExp(input) = "There are ## points".

Input/Output

[execution time limit] 4 seconds (js)

[input] string input

Guaranteed constraints:
5 ≤ input.length ≤ 20.

[output] string
*/

function replaceAllDigitsRegExp(input) {

  return  input.replace(/\d/g, '#') ;
}
