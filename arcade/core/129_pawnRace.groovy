/*
https://codefights.com/arcade/code-arcade/chess-tavern/ybkbv7e6qMaucZWig

Pawn race is a game for two people, played on an ordinary 8 × 8 chessboard. The first player has a white pawn, the second one - a black pawn. 
Initially the pawns are placed somewhere on the board so that the 1st and the 8th rows are not occupied. Players take turns to make a move.

White pawn moves upwards, black one moves downwards. The following moves are allowed:

one-cell move on the same vertical in the allowed direction;
two-cell move on the same vertical in the allowed direction, if the pawn is standing on the 2nd (for the white pawn) or the 7th (for the black pawn) 
row. Note that even with the two-cell move a pawn can't jump over the opponent's pawn;
capture move one cell forward in the allowed direction and one cell to the left or to the right.


The purpose of the game is to reach the the 1st row (for the black pawn) or the 8th row (for the white one), or to capture the opponent's pawn.

Given the initial positions and whose turn it is, determine who will win or declare it a draw (i.e. it is impossible for any player to win). Assume 
that the players play optimally.

Example

For white = "e2", black = "e7" and toMove = 'w', the output should be
pawnRace(white, black, toMove) = "draw";
For white = "e3", black = "d7" and toMove = 'b', the output should be
pawnRace(white, black, toMove) = "black";
For white = "a7", black = "h2" and toMove = 'w', the output should be
pawnRace(white, black, toMove) = "white".
Input/Output

[execution time limit] 6 seconds (groovy)

[input] string white

Coordinates of the white pawn in the chess notation.

[input] string black

Position of the black pawn in the same notation. It is guaranteed that white ≠ black.

[input] char toMove

'w' if it is the first player's turn, 'b' otherwise.

[output] string

"white", "black" or "draw" depending on the result of the game.
*/

T pawnRace(white, black, turn) {
  
    def l = "abcdefgh"
    
    def w = [white[1].toInteger() - 1, l.indexOf(white[0])]
    def b = [black[1].toInteger() - 1, l.indexOf(black[0])]
    
    if(w[0]==7){
        return "white"
    }
    if(b[0]==0){
        return "black"
    }
    
    def t = turn == 'w'
    def player = t ? w : b
    def offset = t ? 1 : -1
    def startline = t ? 1 : 6
    def next = [player[0]+offset, player[1]]
    def xDistance = b[0]-w[0]
    def yDistance = (w[1]-b[1]).abs()
    if(yDistance == 0 && xDistance == 1){
        return "draw"
    }
    if(yDistance == 1 && xDistance == 1){
        return t ? "white" : "black"
    }
    if(player[0]==startline 
       && !(yDistance == 1 && xDistance == 3) 
       && !(yDistance == 0 && xDistance == 2)){
        next = [player[0]+2*offset, player[1]]
    }
    player = next
    
    t ? (w = player) : (b = player)
    turn = t ? 'b' : 'w'

    w = "${l[w[1]]}${w[0] + 1}"
    b = "${l[b[1]]}${b[0] + 1}"
    
    return pawnRace(w, b, turn)
}
