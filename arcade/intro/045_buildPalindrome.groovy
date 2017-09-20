/*
https://codefights.com/arcade/intro/level-10/ppZ9zSufpjyzAsSEx

Given a string, find the shortest possible string which can be achieved by adding characters to the end of initial string to make it a palindrome.

Example

For st = "abcdc", the output should be
buildPalindrome(st) = "abcdcba".

Input/Output

[time limit] 6000ms (groovy)
[input] string st

A string consisting of lowercase latin letters.

Guaranteed constraints:
3 ≤ st.length ≤ 10.

[output] string
 */

String buildPalindrome(String st) {

    def count = 0
    def palindrome = st
    while(palindrome != palindrome.reverse()){
        count++
        palindrome = st + st.take(count).reverse()
    }
    return palindrome
}
