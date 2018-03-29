/*
https://codefights.com/arcade/code-arcade/regular-hell/Rqtm4Yv8GhHYXJYPY


You are given a string s of characters that contains at least n numbers (here, a number is defined as a consecutive series of 
digits, where any character immediately to the left and right of the series are not digits). The numbers may contain leading 
zeros, but it is guaranteed that each number has at least one non-zero digit in it.

Your task is to find the nth number and return it as a string without leading zeros.

Example

For s = "8one 003number 201numbers li-000233le number444" and n = 4,
the output should be
nthNumber(s, n) = "233".

Input/Output

[execution time limit] 4 seconds (js)

[input] string s

A string containing at least n numbers.

Guaranteed constraints:
20 ≤ s.length ≤ 650.

[input] integer n

1-based index of the number to find.

Guaranteed constraints:
1 ≤ n ≤ 15.

[output] string

The nth number without leading zeros.
*/

function nthNumber(s, n) {
  var re = new RegExp("(?:.*?[0-9]+){"+ (n-1) +"}.*?([1-9][0-9]*)");
  return re.exec(s)[1];
}
