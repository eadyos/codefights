/*
https://codefights.com/arcade/code-arcade/well-of-integration/kvGfZZxGyjNbD7yxv

Given a positive integer number and a certain length, we need to modify the given number to have a specified length. We
are allowed to do that either by cutting out leading digits (if the number needs to be shortened) or by adding 0s in front
of the original number.

Example

For number = 1234 and width = 2, the output should be
integerToStringOfFixedWidth(number, width) = "34";
For number = 1234 and width = 4, the output should be
integerToStringOfFixedWidth(number, width) = "1234";
For number = 1234 and width = 5, the output should be
integerToStringOfFixedWidth(number, width) = "01234".
Input/Output

[time limit] 6000ms (groovy)
[input] integer number

A non-negative integer.

Guaranteed constraints:
0 ≤ number ≤ 105.

[input] integer width

A positive integer representing the desired length.

Guaranteed constraints:
1 ≤ width ≤ 5.

[output] string

The modified version of number as described above.
 */

String integerToStringOfFixedWidth(int number, int width) {

    def s = number.toString()
    if(s.size() > width){
        s.drop(s.size() - width)
    }else{
        "0" * (width - s.size()) + s
    }
}
