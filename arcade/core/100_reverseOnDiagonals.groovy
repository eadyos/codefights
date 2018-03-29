/*
https://codefights.com/arcade/code-arcade/list-backwoods/Akspcu9ewiYapWkrp

The longest diagonals of a square matrix are defined as follows:

the first longest diagonal goes from the top left corner to the bottom right one;
the second longest diagonal goes from the top right corner to the bottom left one.
Given a square matrix, your task is to reverse the order of elements on both of its longest diagonals.

Example

For

matrix = [[1, 2, 3],
          [4, 5, 6],
          [7, 8, 9]]
the output should be

reverseOnDiagonals(matrix) = [[9, 2, 7],
                              [4, 5, 6],
                              [3, 8, 1]]
Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.array.integer matrix

Guaranteed constraints:
1 ≤ matrix.length ≤ 10,
matrix.length = matrix[i].length,
1 ≤ matrix[i][j] ≤ 1000.

[output] array.array.integer

Matrix with the order of elements on its longest diagonals reversed.

*/

def reverseOnDiagonals(m) {
  
    def offset = 0
    def size = m.size() - 1
    
    while(offset < size / 2){
        //Swap first longest diagnol
        def t = m[offset][offset]
        m[offset][offset] = m[size - offset][size - offset]
        m[size - offset][size - offset] = t
        //Swap second longest diagnol
        t = m[offset][size - offset]
        m[offset][size - offset] = m[size - offset][offset] 
        m[size - offset][offset++] = t
    }
    m
    
}
