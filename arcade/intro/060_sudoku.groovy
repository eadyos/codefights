/*
https://codefights.com/arcade/intro/level-12/tQgasP8b62JBeirMS

See link for example images.

Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with digits so that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid contains all of the digits from 1 to 9.

This algorithm should check if the given grid of numbers represents a correct solution to Sudoku.

Example

For the first example below, the output should be true. For the other grid, the output should be false: each of the nine 3 × 3 sub-grids should contain all of the digits from 1 to 9.



Input/Output

[time limit] 6000ms (groovy)
[input] array.array.integer grid

A matrix representing 9 × 9 grid already filled with numbers from 1 to 9.

[output] boolean

true if the given grid represents a correct solution to Sudoku, false otherwise.
 */

boolean sudoku(List<List<Integer>> grid) {

    areRowsUnique(grid) &&
    areRowsUnique(grid.transpose()) &&
    areRowsUnique(getSubgrids(grid))
}

def areRowsUnique(def grid){
    grid.every{it.unique().size() == 9}
}

def getSubgrids(def grid){

    def subgrids = []
    (0..2).each{x->
        (0..2).each{y->
            subgrids << (0..2).collect{i->
                (0..2).collect{j->
                    grid[(x*3) + i][(y*3)+j]
                }
            }.flatten()
        }
    }
    subgrids
}
