/*
https://codefights.com/challenge/NCrbg6acyZRxGEktr


Given a string s containing only open and close parenthesis. What is the minimum number of parenthesis that needs to be 
flipped for the string to become a set of balanced parenthesis.

Example
For s = "((", the output should be
flipForBalance(s) = 1.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] string s

A string of even non-empty length containing only '(' and ')'.

Guaranteed constraints:
2 ≤ s.length < 50.

[output] integer

The minimum number of parenthesis that needs to be flipped.

*/

T flipForBalance(s) {
 
    int o,f
    s.each{
      o-= it < 41 ? -1 : o ? 1 : f - ++f
    }
            
    f + o/2    

}
