=begin
https://codefights.com/arcade/code-arcade/corner-of-0s-and-1s/9nSj6DgqLDsBePJha

Presented with the integer n, find the 0-based position of the second rightmost zero bit in its binary representation (it is guaranteed that such a bit exists), counting from right to left.

Return the value of 2position_of_the_found_bit.

Example

For n = 37, the output should be
secondRightmostZeroBit(n) = 8.

3710 = 1001012. The second rightmost zero bit is at position 3 (0-based) from the right in the binary representation of n.
Thus, the answer is 23 = 8.

Input/Output

[time limit] 4000ms (js)
[input] integer n

Guaranteed constraints:
4 ≤ n ≤ 230.

[output] integer
=end

def secondRightmostZeroBit(n)

    return 2 ** n.to_s(2).reverse.sub("0", "1").index("0")

end
