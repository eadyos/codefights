/*
https://codefights.com/arcade/code-arcade/chess-tavern/zqDuSLMHhAknqnLtA

Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.

The knight can move to a square that is two squares horizontally and one square vertically, or two squares vertically 
and one square horizontally away from it. The complete move therefore looks like the letter L. Check out the image below 
to see all valid moves for a knight piece that is placed on one of the central squares.



Example

For cell = "a1", the output should be
chessKnightMoves(cell) = 2.



For cell = "c2", the output should be
chessKnightMoves(cell) = 6.



Input/Output

[execution time limit] 6 seconds (groovy)

[input] string cell

String consisting of 2 letters - coordinates of the knight on an 8 × 8 chessboard in chess notation.

[output] integer
*/

int chessKnightMoves(String cell) {
    
    def values = ["abcdefgh".indexOf(cell[0]), cell[1].toString().toInteger() - 1]
    [-1,1].sum{i->
        [-1,1].sum{j->
            [
                [values[0] + (i * 2), values[1] + (j * 1)],
                [values[0] + (i * 1), values[1] + (j * 2)]
            ].count{
                it.every{ it >=0 && it < 8}
            }
        }
    }
}
