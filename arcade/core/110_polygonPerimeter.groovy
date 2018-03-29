/*
https://codefights.com/arcade/code-arcade/waterfall-of-integration/L7KWEYbPoornGyf7K


You have a rectangular white board with some black cells. The black cells create a connected black figure, i.e. it is 
possible to get from any black cell to any other one through connected adjacent (sharing a common side) black cells.

Find the perimeter of the black figure assuming that a single cell has unit length.

It's guaranteed that there is at least one black cell on the table.

Example

For

matrix = [[false, true,  true ],
          [true,  true,  false],
          [true,  false, false]]
the output should be
polygonPerimeter(matrix) = 12.



For

matrix = [[true, true,  true],
          [true, false, true],
          [true, true,  true]]
the output should be
polygonPerimeter(matrix) = 16.



Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.array.boolean matrix

A matrix of booleans representing the rectangular board where true means a black cell and false means a white one.

Guaranteed constraints:
2 ≤ matrix.length ≤ 5,
2 ≤ matrix[0].length ≤ 5.

[output] integer

*/

def polygonPerimeter(m) {
  
    def offsets = [[-1,0],[0,1],[1,0],[0,-1]]
    def l = m.size()
    def w = m[0].size()
    (0..<l).sum{x->
        (0..<w).sum{y->
            offsets.count{o->
                def c = [x+o[0], y+o[1]]
                m[x][y] && (c[0] < 0 || c[0] >= l || c[1] < 0 || c[1] >= w || !m[c[0]][c[1]])
            }
        }
    }
    
}
