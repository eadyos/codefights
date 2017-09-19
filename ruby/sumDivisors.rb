#https://codefights.com/challenge/A9hB67Kfqc7ADHGCo/solutions/j3iCJZ824JjsXLsRN

=begin
Given a non-negative integer n, your task is to calculate the sum of its non-prime divisors.

Example

For number = 8, the output should be

sumDivisors(number) = 13.

number's divisors are 1, 2, 4 and 8. 2 is a prime, so it shouldn't be added to the result. The answer is thus 1 + 4 + 8 = 13.

Input/Output

[time limit] 4000ms (rb)
[input] integer number

Cconstraints:

0 ≤ number ≤ 107

[output] integer
=end


require 'prime'

def sumDivisors(n)
    (1..n).inject(0){|sum,x|
        sum + (n % x == 0 && !Prime.prime?(x) ? x : 0)
    }
end
