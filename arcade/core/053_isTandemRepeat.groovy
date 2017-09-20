/*
https://codefights.com/arcade/code-arcade/book-market/2SDWWyHY9Xw5CpphY

Determine whether the given string can be obtained by one concatenation of some string to itself.

Example

For inputString = "tandemtandem", the output should be
isTandemRepeat(inputString) = true;
For inputString = "qqq", the output should be
isTandemRepeat(inputString) = false;
For inputString = "2w2ww", the output should be
isTandemRepeat(inputString) = false.
Input/Output

[time limit] 6000ms (groovy)
[input] string inputString

Guaranteed constraints:
2 ≤ inputString.length ≤ 20.

[output] boolean

true if inputString represents a string concatenated to itself, false otherwise.
 */

boolean isTandemRepeat(String inputString) {

    int half = inputString.size() / 2
    def firstHalf = inputString[0..<half]
    def secondHalf = inputString[half..<inputString.size()]

    inputString.size() % 2 == 0 && firstHalf == secondHalf

}
