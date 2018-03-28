/*
https://codefights.com/challenge/kP5SCb8NRn7vX9636

Given an integer n, find the nth number in Pascal's Triangle.

Example
For n = 5, the output should be
nthPascalNumber(n) = 2.
The first few lines of the triangle are:
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
The 5th element is 2.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer n

Guaranteed constraints:
0 < n ≤ 300.

[output] integer

*/

def f = { it <= 1 ? 1 : it * f(it - 1) }

T nthPascalNumber(r) {
  
    T n = 0g
    while(r > n )
        r -= n++

    f(n-=1) / (f(r-=1) * f(n - r))
    
}


    

