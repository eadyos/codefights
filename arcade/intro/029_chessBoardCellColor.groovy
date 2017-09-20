/*
https://codefights.com/arcade/intro/level-6/t97bpjfrMDZH8GJhi

See link for images.

Given two cells on the standard chess board, determine whether they have the same color or not.

Example

For cell1 = "A1" and cell2 = "C3", the output should be
chessBoardCellColor(cell1, cell2) = true.


For cell1 = "A1" and cell2 = "H3", the output should be
chessBoardCellColor(cell1, cell2) = false.


Input/Output

[time limit] 6000ms (groovy)
[input] string cell1
[input] string cell2
[output] boolean

true if both cells have the same color, false otherwise.
 */



boolean chessBoardCellColor(String cell1, String cell2) {

    //If the 2 squares are on the same color, their
    //coordinates will sum to an even number
    //which makes this simple
    //The 'char/int' value for both 1 and 'a' are odd values

    (cell1 + cell2).chars.collect{(int)it}.sum() % 2 == 0
}
