=begin
https://codefights.com/arcade/code-arcade/corner-of-0s-and-1s/dShYZZT4WmvpmfpgB

You're given an arbitrary 32-bit integer n. Take its binary representation, split bits into it in pairs (bit number 0 and 1, bit number 2 and 3, etc.) and swap bits in each pair. Then return the result as a decimal number.

Example

For n = 13, the output should be
swapAdjacentBits(n) = 14.

1310 = 11012 ~> {11}{01}2 ~> 11102 = 1410.

For n = 74, the output should be
swapAdjacentBits(n) = 133.

7410 = 010010102 ~> {01}{00}{10}{10}2 ~> 100001012 = 13310.
Note the preceding zero written in front of the initial number: since both numbers are 32-bit integers, they have 32 bits in their binary representation. The preceding zeros in other cases don't matter, so they are omitted. Here, however, it does make a difference.

Input/Output

[time limit] 4000ms (js)
[input] integer n

Guaranteed constraints:
0 ≤ n < 230.

[output] integer
=end

def swapAdjacentBits(n)
    return (0...((n.to_s(2).size + 1)/2)).map{|i|
        bits = n.to_s(2)
        if bits.size % 2 == 1
            bits = "0" + bits
        end
        bit1 = bits[2 * i]
        bit2 = bits[(2 * i) + 1]
        bit2 + bit1
    }.join.to_i(2)
end
