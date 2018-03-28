...
https://codefights.com/challenge/G77e49Sztk9BY8GA2


Find the last digit of n!(factorial), which is different from zero.

Example

For n = 5, the output should be
lastDigitDiffZero(n) = 2.
5! = 1 · 2 · 3 · 4 · 5 = 120.

For n = 6, the output should be
lastDigitDiffZero(n) = 2.
6! =1 · 2 · 3 · 4 · 5 · 6 = 720.

For n = 10, the output should be
lastDigitDiffZero(n) = 8.
10! = 3628800.

[execution time limit] 4 seconds (py)

[input] integer64 n

Guaranteed constraints:
1 ≤ n ≤ 109.

[output] integer
...

def lastDigitDiffZero(n):
   if n<=1: return 1
   return 6*[1, 1, 2, 6, 4, 4, 4, 8, 4, 6][n%10]*3**((n/5)%4)*lastDigitDiffZero(n/5)%10    

