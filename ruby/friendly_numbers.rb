=begin
https://codefights.com/challenge/zeS6of248AhuJB3xM

Numbers x and y (x ≠ y) are called friendly if the sum of proper divisors of x is equal to y, and the other way round.

Given two integers x and y, your task is to check whether they are friendly or not.

Example

For x = 220 and y = 284, the output should be
friendly_numbers(x, y) = "Yes".

The proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110, which add up to 284; and the proper divisors of 284 are 1, 2, 4, 71 and 142, which add up to 220.

Input/Output

[time limit] 6000ms (groovy)
[input] integer x

Constraints:
1 ≤ x ≤ 105.

[input] integer y

Constraints:
1 ≤ y ≤ 105.

[output] string

"Yes" if x and y are friendly and "No" otherwise.
=end


def friendly_numbers x, y
    s=->n{(1..n/2).inject{|t,i| n % i < 1 ? t + i : t}}

    x != y &&
    s[x] == y &&
    s[y] == x ? :Yes : :No
end