/*
https://codefights.com/arcade/code-arcade/chess-tavern/NhRZQrrMqeWYL9L9Z

Consider a bishop, a knight and a rook on an n × m chessboard. They are said to form a triangle if each piece attacks exactly 
one other piece and is attacked by exactly one piece. Calculate the number of ways to choose positions of the pieces to form
a triangle.

Note that the bishop attacks pieces sharing the common diagonal with it; the rook attacks in horizontal and vertical directions; 
and, finally, the knight attacks squares which are two squares horizontally and one square vertically, or two squares vertically 
and one square horizontally away from its position.



Example

For n = 2 and m = 3, the output should be
chessTriangle(n, m) = 8.



Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer n

Guaranteed constraints:
1 ≤ n ≤ 40.

[input] integer m

Guaranteed constraints:
1 ≤ m ≤ 40,
3 ≤ n · m.

[output] integer

[Groovy] Syntax Tips
*/

int chessTriangle(int n, int m) {
  
    
    def a = n-1 < 0 ? 0 : n-1
    def b = m-2 < 0 ? 0 : m-2
    def c = m-1 < 0 ? 0 : m-1
    def d = n-2 < 0 ? 0 : n-2    
    def e = n-3 < 0 ? 0 : n-3
    def f = m-3 < 0 ? 0 : m-3
        
    8*a*b + 8*c*d + 16*b*d + 8*e*c + 8*f*a + 8*e*b + 8*f*d
}
