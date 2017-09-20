/*
https://codefights.com/arcade/code-arcade/mirror-lake/fQpfgxiY6aGiGHLtv

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
    (0..<matrix.size()-1).each{row->
        (0..<matrix[0].size()-1).each{col->
            def vals = []
            (0..1).each{sRow->
                (0..1).each{sCol->
                    vals << matrix[row+sRow][col+sCol]
                }
            }
            squares << vals.join()
        }
    }
    squares.unique().size()
}