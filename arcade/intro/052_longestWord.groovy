/*
https://codefights.com/arcade/intro/level-12/s9qvXv4yTaWg8g4ma

Define a word as a sequence of consecutive English letters. Find the longest word from the given string.

Example

For text = "Ready, steady, go!", the output should be
longestWord(text) = "steady".

Input/Output

[time limit] 6000ms (groovy)
[input] string text

Guaranteed constraints:
4 ≤ text.length ≤ 50.

[output] string

The longest word from text. It's guaranteed that there is a unique output.
 */

String longestWord(String text) {

    def matches = text =~ /\w+/
    def result = ""
    (0..<matches.size()).each{
        if(matches[(int)it].size() > result.size())
            result = matches[(int)it]
    }
    result
}
