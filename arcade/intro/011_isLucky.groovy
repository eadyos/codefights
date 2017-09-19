/*
https://codefights.com/arcade/intro/level-3/3AdBC97QNuhF6RwsQ

Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.

Given a ticket number n, determine if it's lucky or not.

Example

For n = 1230, the output should be
isLucky(n) = true;
For n = 239017, the output should be
isLucky(n) = false.
Input/Output

[time limit] 4000ms (rb)
[input] integer n

A ticket number represented as a positive integer with an even number of digits.

Guaranteed constraints:
10 ≤ n < 106.

[output] boolean

true if n is a lucky ticket number, false otherwise.
 */

boolean isLucky(int n) {

    def numString = n as String
    def halfPoint = (numString.size() / 2)
    def num1 = numString[0..halfPoint-1]
    def num2 = numString[halfPoint..numString.size()-1]
    num1.collect{it as Integer}.sum() == num2.collect{it as Integer}.sum()
}
