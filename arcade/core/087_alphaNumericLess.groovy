/*
https://codefights.com/arcade/code-arcade/lab-of-transformations/bBgu7NEfk2GoQuNzf

An alphanumeric ordering of strings is defined as follows: each string is considered as a sequence of tokens, where each
token is a letter or a number (as opposed to an isolated digit, as is the case of lexicographic ordering). For example, the
tokens of a string "ab01c004" are [a, b, 01, c, 004]. In order to compare two strings, you break them down into tokens and
compare corresponding pairs of tokens with each other (i.e. first token of the first string, with the first token of the
second string etc).

Here is how tokens are compared:

If a letter is compared with another letter, the usual order applies.
A number is always less than a letter.
When two numbers are compared, their values are compared. Leading zeros, if any, are ignored.
If at some point one string has no more tokens left while the other one still does, the one with fewer tokens is considered
smaller.

If the two strings s1 and s2 appear to be equal, consider the smallest index i such that tokens(s1)[i] and tokens(s2)[i]
(where tokens(s)[i] is the ith token of string s) differ only by the number of leading zeros. If no such i exists, the strings
are indeed equal. Otherwise, the string whose ith token has more leading zeros is considered less.

Here are some examples of comparing strings using alphanumeric ordering.

"a" < "a1" < "ab"
"ab42" < "ab000144" < "ab00144" < "ab144" < "ab000144x"
"x11y012" < "x011y13"
Example

For s1 = "a" and s2 = "a1", the output should be
alphanumericLess(s1, s2) = true;
For s1 = "ab" and s2 = "a1", the output should be
alphanumericLess(s1, s2) = false;
For s1 = "b" and s2 = "a1", the output should be
alphanumericLess(s1, s2) = false.
Input/Output

[time limit] 6000ms (groovy)
[input] string s1

String, consisting of Latin letters and digits.

Guaranteed constraints:
1 ≤ s1.length ≤ 20.

[input] string s2

String, consisting of Latin letters and digits.

Guaranteed constraints:
1 ≤ s2.length ≤ 20.

[output] boolean

true if s1 is alphanumerically strictly less than s2, false otherwise.
 */

boolean alphanumericLess(String s1, String s2) {

    def p = /[A-z]|\d+/
    def r1 = (s1 =~ p) as Set
    def r2 = (s2 =~ p) as Set

    def tokens = [r1,r2]*.size().max()

    def tieBreaker

    for(i in 0..<tokens){
        def a = r1[i]
        def b = r2[i]
        if(!a && b)
            return true
        else if(!b && a)
            return false
        else if(a.isNumber() && !b.isNumber())
            return true
        else if(!a.isNumber() && b.isNumber())
            return false
        else{
            int c = a <=> b
            if(a.isNumber()){
                int d = a.toBigInteger() <=> b.toBigInteger()
                if(d == 0 && !tieBreaker && c != 0 &&
                        a.toBigInteger() + b.toBigInteger() > 0){
                    tieBreaker = c
                }
                c = d
            }
            if(c < 0)
                return true
            else if(c > 0)
                return false
        }
    }
    tieBreaker ? tieBreaker < 0 : false
}
