/*
https://codefights.com/arcade/code-arcade/lab-of-transformations/8nAgfjhDvKCpxwGWF

Define an alphabet reflection as follows: a turns into z, b turns into y, c turns into x, ..., n turns into m, m turns into n, ..., z turns into a.

Define a string reflection as the result of applying the alphabet reflection to each of its characters.

Reflect the given string.

Example

For inputString = "name", the output should be
reflectString(inputString) = "mznv".

Input/Output

[time limit] 6000ms (groovy)
[input] string inputString

A string of lowercase characters.

Guaranteed constraints:
3 ≤ inputString.length ≤ 10.

[output] string

 */

String reflectString(String inputString) {

    def alphabet = "abcdefghijklmnopqrstuvwxyz"
    def reflection = ""
    inputString.each{
        def index = alphabet.indexOf(it)
        reflection += alphabet[-index-1]
    }
    reflection

}
