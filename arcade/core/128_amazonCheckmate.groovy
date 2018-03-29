/*
https://codefights.com/arcade/code-arcade/chess-tavern/3hvEEqS7wuoEMZJJC

An amazon (also known as a queen+knight compound) is an imaginary chess piece that can move like a queen or a knight 
(or, equivalently, like a rook, bishop, or knight). The diagram below shows all squares which the amazon attacks from e4 (circles 
represent knight-like moves while crosses correspond to queen-like moves).



Recently you've come across a diagram with only three pieces left on the board: a white amazon, white king and black king. It's black's 
move. You don't have time to determine whether the game is over or not, but you'd like to figure it out in your head. Unfortunately, the 
diagram is smudged and you can't see the position of the black's king, so it looks like you'll have to check them all.

Given the positions of white pieces on a standard chessboard, determine the number of possible black king's positions such that:

it's checkmate (i.e. black's king is under amazon's attack and it cannot make a valid move);
it's check (i.e. black's king is under amazon's attack but it can reach a safe square in one move);
it's stalemate (i.e. black's king is on a safe square but it cannot make a valid move);
black's king is on a safe square and it can make a valid move.
Note that two kings cannot be placed on two adjacent squares (including two diagonally adjacent ones).

Example

For king = "d3" and amazon = "e4", the output should be
amazonCheckmate(king, amazon) = [5, 21, 0, 29].



Red crosses correspond to the checkmate positions, orange pluses refer to checks and green circles denote safe squares.

For king = "a1" and amazon = "g5", the output should be
amazonCheckmate(king, amazon) = [0, 29, 1, 29].



Stalemate position is marked by a blue square.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] string king

Position of the white's king in the chess notation.

[input] string amazon

Position of the white's amazon in the same notation.

Guaranteed constraints:
amazon ≠ king.

[output] array.integer

Array of four integers, each equal to the number of black's king positions corresponding to a specific situation. The integers should be 
presented in the same order as the situations were described, i.e. 0 for checkmates, 1 for checks, etc.
*/

List<Integer> amazonCheckmate(String king, String amazon) {
    def l = "abcdefgh"
    def k = [king[1].toInteger()-1, l.indexOf(king[0])]
    def q = [amazon[1].toInteger()-1, l.indexOf(amazon[0])]        
    def (safe, check, checkmate, stalemate) = [[],[]]
    
    (0..7).each{x->
        (0..7).each{y->
            def kd = [(k[0]-x).abs(), (k[1]-y).abs()]     
            def qd = [(q[0]-x).abs(), (q[1]-y).abs()]
            //can't be on same space or next to king
            if(!([x,y] in [k,q]) && kd.any{it > 1}){
                def rookOffsets = [[0,1],[0,-1],[1,0],[-1,0]]
                def isCheck = false
                rookOffsets.each{o->
                    int i=x+o[0]
                    int j=y+o[1]
                    while(i in 0..7 && j in 0..7 && !([i,j] in [q,k])){
                        i+=o[0]
                        j+=o[1]
                    }
                    isCheck = [i,j] == q || isCheck 
                }
                def bishopOffsets = [[1,1],[-1,1],[-1,-1],[1,-1]]
                bishopOffsets.each{o->
                    int i=x+o[0]
                    int j=y+o[1]
                    while(i in 0..7 && j in 0..7 && !([i,j] in [q,k])){
                        i+=o[0]
                        j+=o[1]
                    }
                    isCheck = [i,j] == q || isCheck 
                }
                def knightOffsets = [[1,2],[-1,2],[1,-2],[-1,-2]]
                knightOffsets.each{o->
                    if(q in [[x+o[0],y+o[1]], [x+o[1],y+o[0]]]){
                        isCheck = true
                    }
                }
                if(isCheck){
                    check << [x,y]
                }else{
                    safe << [x,y]
                }
            }
        }
    }
    stalemate = safe.findAll{p->
        (-1..1).every{x->
            (-1..1).every{y->
                if(p[0] + x in (0..7) && p[1] + y in (0..7) && (x!=0 || y !=0)){
                    def c = [p[0] + x, p[1] + y]
                    def kd = [(k[0]-c[0]).abs(), (k[1]-c[1]).abs()]     
                    check.contains(c) || kd.every{it <= 1}
                }else{
                    true
                }
            }
        }
    }
    stalemate.each{
        safe.remove(it)
    }
    checkmate = check.findAll{p->
        (-1..1).every{x->
            (-1..1).every{y->
                if(p[0] + x in (0..7) && p[1] + y in (0..7) && (x!=0 || y !=0)){
                    def c = [p[0] + x, p[1] + y]
                    def kd = [(k[0]-c[0]).abs(), (k[1]-c[1]).abs()]     
                    check.contains(c) || kd.every{it <= 1}
                }else{
                    true
                }
            }
        }
    }
    checkmate.each{
        check.remove(it)
    }    
    
    [checkmate.size(), check.size(), stalemate.size(), safe.size()]
}
