/*
https://codefights.com/arcade/code-arcade/corner-of-0s-and-1s/e3zfPNTwTa9qTQzcX

Reverse the order of the bits in a given integer.

Example

For a = 97, the output should be
mirrorBits(a) = 67.

97 equals to 1100001 in binary, which is 1000011 after mirroring, and that is 67 in base 10.

For a = 8, the output should be
mirrorBits(a) = 1.

Input/Output

[time limit] 6000ms (groovy)
[input] integer a

Guaranteed constraints:
5 ≤ a ≤ 105.

[output] integer
 */

int mirrorBits(int a) {
    Integer.parseInt(a.toBinaryString(a).reverse(), 2)
}
