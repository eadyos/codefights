/*

https://app.codesignal.com/challenge/BMeS89iMfGe7TzDhy

Given an integer n, find the number of ways to select four points with integer coordinates between 0 and n, such that the four points form the vertices of a square.

Since the number of squares could be very large, return the result mod 109 + 7.

Example

For n = 3, the output should be countingSquares(n) = 20. There are 20 possible squares with integer coordinates, that fit in a 3 x 3 grid:

square possibilities

Input / Output

[execution time limit] 6 seconds (groovy)

[input] integer n

An integer representing the side length of the boundary that the vertices of the square must fit within.

Guaranteed constraints:
0 ≤ n ≤ 109

[output] integer

An integer representing the number of different squares that can be formed (mode 109 + 7).

*/

T countingSquares(n) {
   
   n+=2g 
   (n-- * n * n-- * n   / 12).remainder 10e8+7
    
}
