/*
https://codefights.com/arcade/intro/level-11/pwRLrkrNpnsbgMndb

See link for example images.


Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.

The knight can move to a square that is two squares horizontally and one square vertically, or two squares vertically and one square horizontally away from it. The complete move therefore looks like the letter L. Check out the image below to see all valid moves for a knight piece that is placed on one of the central squares.



Example

For cell = "a1", the output should be
chessKnight(cell) = 2.



For cell = "c2", the output should be
chessKnight(cell) = 6.



Input/Output

[time limit] 6000ms (groovy)
[input] string cell

String consisting of 2 letters - coordinates of the knight on an 8 × 8 chessboard in chess notation.

[output] integer
 */

int chessKnight(String cell) {

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
