/*
https://codefights.com/arcade/code-arcade/labyrinth-of-nested-loops/yBFfNv5fTqhcacZ7w

Determine if the given number is a power of some non-negative integer.

Example

For n = 125, the output should be
isPower(n) = true;
For n = 72, the output should be
isPower(n) = false.
Input/Output

[time limit] 6000ms (groovy)
[input] integer n

A positive integer.

Guaranteed constraints:
1 ≤ n ≤ 400.

[output] boolean

true if n can be represented in the form ab (a to the power of b) where a and b are some non-negative integers and b ≥ 2, false otherwise.
 */

boolean isPower(int n) {

    if(n == 1)
        return true

    int a = 2
    int b = 2
    boolean isPower = false

    while(a ** b <= n && !isPower){
        while(a ** b <= n && !isPower){
            if(a ** b == n){
                isPower = true
            }
            b++
        }
        b = 2
        a++
    }
    isPower
}
