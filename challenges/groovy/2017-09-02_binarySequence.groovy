/*
https://codefights.com/challenge/MLohbJfu3GhAAh92X

You are building an infinite string using the following rule:

Start from str = "0";
str = str + not(str), where not(str) is a binary sequence that's generated by swapping 0 to 1 and vice versa.
Given an integer n, find the substring of str with a length of 3 that starts at position n.

Example
For n = 3, the output should be
binarySequence(n) = "010".

First we build str until it has the needed length:
Step 1: str = "0" + "1" = "01".
Step 2: str = "01" + "10" = "0110".
Step 3: str = "0110" + "1001" = "01101001".
The substring of length 3 starting from position 3 is "010", which is the answer.

Input/Output

[time limit] 6000ms (groovy)
[input] integer64 n

The start of the required substring. 0-based index.

Guaranteed constraints:
0 ≤ n ≤ 2 · 1015.

[output] string

The substring of str that has a length of 3 and starts at position n.
 */

T binarySequence(n,r="") {

    (n..n+2).each{
        r += it.bitCount(it) % 2
    }
    r
}

