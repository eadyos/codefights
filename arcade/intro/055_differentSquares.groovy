/*
https://codefights.com/arcade/intro/level-12/fQpfgxiY6aGiGHLtv

Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.

Example

For

matrix = [[1, 2, 1],
          [2, 2, 2],
          [2, 2, 2],
          [1, 2, 3],
          [2, 2, 1]]
the output should be
differentSquares(matrix) = 6.

Here are all 6 different 2 × 2 squares:

1 2
2 2
2 1
2 2
2 2
2 2
2 2
1 2
2 2
2 3
2 3
2 1
Input/Output

[time limit] 6000ms (groovy)
[input] array.array.integer matrix

Guaranteed constraints:
1 ≤ matrix.length ≤ 100,
1 ≤ matrix[i].length ≤ 100,
0 ≤ matrix[i][j] ≤ 9.

[output] integer

The number of different 2 × 2 squares in matrix.
 */

int differentSquares(List<List<Integer>> matrix) {

    def squares = []
    for (i in 0..<(matrix.size() - 1)){
        for (j in 0..<(matrix[0].size() -1)){
            def vals = []
            for(a in 0..1){
                for(b in 0..1){
                    vals << matrix[i + a][j + b]
                }
            }
            squares << vals.join()
        }
    }
    squares.unique().size()
}
