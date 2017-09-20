/*
https://codefights.com/arcade/intro/level-10/PHSQhLEw3K2CmhhXE

A string is said to be beautiful if b occurs in it no more times than a; c occurs in it no more times than b; etc.

Given a string, check whether it is beautiful.

Example

For inputString = "bbbaacdafe", the output should be
isBeautifulString(inputString) = true;
For inputString = "aabbb", the output should be
isBeautifulString(inputString) = false;
For inputString = "bbc", the output should be
isBeautifulString(inputString) = false.
Input/Output

[time limit] 6000ms (groovy)
[input] string inputString

A string of lowercase letters.

Guaranteed constraints:
3 ≤ inputString.length ≤ 50.

[output] boolean
 */

boolean isBeautifulString(String s) {

    def lastLetter = s.toSet().sort()[-1]
    def letters = ('a'..lastLetter).toArray()
    (0..<letters.size()).every{
        def letter = letters[it]
        def previousLetter = it > 0 ? letters[it-1] : null
        def letterCount = s.count(letter)
        def previousLetterCount = previousLetter ? s.count(previousLetter) : null
        letterCount > 0 && (letter == 'a' || letterCount <= previousLetterCount)
    }
}
