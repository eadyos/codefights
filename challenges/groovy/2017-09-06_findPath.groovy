/*
https://codefights.com/challenge/n927Ns3HD2q3EMeXB

You are given an n × m matrix, which contains all the integers from 1 to n * m, inclusive, each exactly once.

Initially you are standing in the cell containing the number 1. On each turn you are allowed to move to an adjacent cell, i.e. to a cell that shares a common side with the one you are standing on now. It is prohibited to visit any cell more than once.

Check if it is possible to visit all the cells of the matrix in the order of increasing numbers in the cells, i.e. get to the cell with the number 2 on the first turn, then move to 3, etc.

Example

For

matrix = [[1, 4, 5],
          [2, 3, 6]]
the output should be
findPath(matrix) = true;

For

matrix = [[1, 3, 6],
          [2, 4, 5]]
the output should be
findPath(matrix) = false.

Input/Output

[time limit] 6000ms (groovy)
[input] array.array.integer matrix

A non-empty 2-dimensional array of integers representing a rectangular matrix.

Guaranteed constraints:
1 ≤ matrix.length ≤ 5,
1 ≤ matrix[0].length ≤ 10,
1 ≤ matrix[i][j] ≤ 25.

[output] boolean
 */

T findPath(m) {

    def i,j,p,q
    m.flatten().sort().every{n->
        i=m.findIndexOf{it.contains(n)}
        j=m[i].indexOf(n)
        q = p
        p = [i,j]
        n == 1 ||
        q[0] == i && q[1] in (j-1..j+1) ||
        q[1] == j && q[0] in (i-1..i+1)
    }

}
