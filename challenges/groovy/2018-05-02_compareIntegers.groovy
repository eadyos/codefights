/*
https://app.codesignal.com/challenge/hXhTZHDPRBSMExs6r

Compare two integers given as strings.

Example

For a = "12" and b = "13", the output should be
compareIntegers(a, b) = "less";
For a = "875" and b = "799", the output should be
compareIntegers(a, b) = "greater";
For a = "1000" and b = "1000", the output should be
compareIntegers(a, b) = "equal".
Input/Output

[execution time limit] 6 seconds (groovy)

[input] string a

A string representing a positive integer without leading zeroes.

Guaranteed constraints:
1 ≤ a.length ≤ 10.

[input] string b

A string representing a positive integer without leading zeroes.

Guaranteed constraints:
1 ≤ b.length ≤ 10.

[output] string

'less' if int(a) < int(b), 'equal' if int(a) = int(b), and 'greater' if int(a) > int(b), where int(x) is equal to integer represented by the string x.

*/

T compareIntegers(a, b) {
    
    ["equal","greater","less"][a as int <=> b as int]
}
