/*
https://codefights.com/arcade/code-arcade/mirror-lake/EeKpdMQXpBkgWjcvt

Given a string consisting of lowercase English letters, find the largest square number which can be obtained by reordering the string's characters and replacing them with any digits you need (leading zeros are not allowed) where same characters always map to the same digits and different characters always map to different digits.

If there is no solution, return -1.

Example

For s = "ab", the output should be
constructSquare(s) = 81.
The largest 2-digit square number with different digits is 81.
For s = "zzz", the output should be
constructSquare(s) = -1.
There are no 3-digit square numbers with identical digits.
For s = "aba", the output should be
constructSquare(s) = 900.
It can be obtained after reordering the initial string into "baa" and replacing "a" with 0 and "b" with 9.
Input/Output

[time limit] 6000ms (groovy)
[input] string s

Guaranteed constraints:
1 ≤ s.length < 10.

[output] integer
 */

int constructSquare(String s) {

    def letterCounts = getLetterCounts(s).sort()
    def max = "1" + ("0" * s.size())
    max = max.toInteger()
    int square = 0
    int base = 1
    def matches = []
    while(square < max){
        square = base*base++
        def squareCounts = getLetterCounts(square).sort()
        if(squareCounts == letterCounts){
            matches << square
        }
    }
    matches.max() ?: -1
}

def getLetterCounts(s){
    def letterCounts = [:]
    s.toString().each{
        if(letterCounts[it]){
            letterCounts[it] += 1
        }else{
            letterCounts[it] = 1
        }
    }
    letterCounts.values()
}
