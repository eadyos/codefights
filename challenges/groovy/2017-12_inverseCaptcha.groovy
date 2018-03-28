/*
https://codefights.com/challenge/RCxi4uNooRPdzcaS5

You must solve a captcha to prove that you're not a human. Find the sum of all digits that match the next digit in the given number. 
Let's say that the number is circular, so the digit after the last digit is the first digit of this number.

Example
For a = 11221, the output should be
inverseCaptcha(a) = 4.
The result is 4 (1 + 2 + 1) because the first 1 and 2 matches the next digit, while the last 1 matches the first digit.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer64 a

Guaranteed constraints:
2 ≤ a < 1016.

[output] integer

The value of the captcha.

*/

T inverseCaptcha(a) {
  
    T p = a%10
    "$a"*.toLong().sum{
        p - (p=it) ? 0 : p
    }
    
    
}
