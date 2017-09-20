/*
https://codefights.com/arcade/code-arcade/well-of-integration/Ghe6HWhFft8h6fR49

Consider two following representations of a non-negative integer:

A simple decimal integer, constructed of a non-empty sequence of digits from 0 to 9;
An integer with at least one digit in a base from 2 to 16 (inclusive), enclosed between # characters, and preceded by the base, which can only be a number between 2 and 16 in the first representation. For digits from 10 to 15 characters a, b, ..., f and A, B, ..., F are used.
Additionally, both representations may contain underscore (_) characters; they are used only as separators for improving legibility of numbers and can be ignored while processing a number.

Your task is to determine whether the given string is a valid integer representation.

Note: this is how integer numbers are represented in the programming language Ada.

Example

For line = "123_456_789", the output should be
adaNumber(line) = true;
For line = "16#123abc#", the output should be
adaNumber(line) = true;
For line = "10#123abc#", the output should be
adaNumber(line) = false;
For line = "10#10#123ABC#", the output should be
adaNumber(line) = false;
For line = "10#0#", the output should be
adaNumber(line) = true;
For line = "10##", the output should be
adaNumber(line) = false.
Input/Output

[time limit] 6000ms (groovy)
[input] string line

A non-empty string.

Guaranteed constraints:
2 ≤ line.length ≤ 30.

[output] boolean

true if line is a valid integer representation, false otherwise.
 */

boolean adaNumber(String line) {

    def numbers = "0123456789abcdef"

    if(line.replace("_","") ==~ /^[\d]+$/)
        return true

    //Check format
    if(line ==~ /^[\d_]+#[0-9a-fA-F_]+#$/){
        def parts = line.split("#")
        def base = parts[0].replace("_","").toInteger()
        def value = parts[1].toLowerCase().replace("_","")
        if(base in (2..16)){
            return value ==~ /[${numbers[0..base-1]}]+/
        }
    }

    false
}
