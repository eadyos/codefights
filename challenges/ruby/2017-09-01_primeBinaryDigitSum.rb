=begin
https://codefights.com/challenge/JpaX42MHerMYeTMjD

Your task is to find all the prime numbers in a given range (from rangeStart to rangeEnd, inclusive), digits in binary representation of which sums to a given number sum.

Example
For rangeStart = 1, rangeEnd = 3 and sum = 1, the output should be
primeBinaryDigitSum(rangeStart ,rangeEnd, sum) = [2].

Because:

The numbers in the range = [1; 2; 3];
The prime numbers in the range = [2; 3];
The prime numbers in the range, represented in binary = [10; 11];
The *sum of the digits* for the prime numbers in the range, represented in binary = [10 => 1 + 0 = 1; 11 => 1 + 1 = 2];
Return `2`, because it is the only prime number in the given range for which the sum of the digits of its binary representation is `1`.
Input/Output

[time limit] 6000ms (groovy)
[input] integer rangeStart

The starting number of the range.

Guaranteed constraints:
1 ≤ rangeStart ≤ 231 - 1.

[input] integer rangeEnd

The ending number of the range.

Guaranteed constraints:
1 ≤ rangeEnd ≤ 231 - 1,
rangeStart ≤ rangeEnd.

[input] integer sum

The sum of the binary digits we are looking for.

Guaranteed constraints:
1 ≤ sum ≤ 100.

[output] array.integer

The numbers that meet the criteria outlined in the description. If there is no such number, return an empty array.
=end

require 'prime'
def primeBinaryDigitSum b, e, s

    (b..e).select{|n|
        n.to_s(2).count(?1) == s && Prime.prime?(n)
    }
end

