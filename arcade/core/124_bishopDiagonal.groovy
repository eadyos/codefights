/*
https://codefights.com/arcade/code-arcade/chess-tavern/wGLCfzpdcA2o9kSpD

In the Land Of Chess, bishops don't really like each other. In fact, when two bishops happen to stand on the 
same diagonal, they immediately rush towards the opposite ends of that same diagonal.

Given the initial positions (in chess notation) of two bishops, bishop1 and bishop2, calculate their future positions. 
Keep in mind that bishops won't move unless they see each other along the same diagonal.

Example

For bishop1 = "d7" and bishop2 = "f5", the output should be
bishopDiagonal(bishop1, bishop2) = ["c8", "h3"].



For bishop1 = "d8" and bishop2 = "b5", the output should be
bishopDiagonal(bishop1, bishop2) = ["b5", "d8"].

The bishops don't belong to the same diagonal, so they don't move.


Input/Output

[execution time limit] 6 seconds (groovy)

[input] string bishop1

Coordinates of the first bishop in chess notation.

[input] string bishop2

Coordinates of the second bishop in the same notation.

[output] array.string

Coordinates of the bishops in lexicographical order after they check the diagonals they stand on.
*/

List<String> bishopDiagonal(a, b) {
    
    def l = "abcdefgh"
  
    a = [l.indexOf(a[0]), a[1].toString().toInteger() - 1]
    b = [l.indexOf(b[0]), b[1].toString().toInteger() - 1]
    def d = [a[0]-b[0], a[1]-b[1]]
    
    if(d[0].abs() == d[1].abs()){

        def aOffset = [d[0] < 0 ? a[0] : 7-a[0], d[1] < 0 ? a[1] : 7-a[1]].min()
        def bOffset = [d[0] < 0 ? 7-b[0] : b[0], d[1] < 0 ? 7-b[1] : b[1]].min()
        if(d[0] < 0){
            a = [a[0]-aOffset, a[1]]
            b = [b[0]+bOffset, b[1]]
        }else{
            a = [a[0]+aOffset, a[1]]
            b = [b[0]-bOffset, b[1]]
        }
        if(d[1] < 0){
            a = [a[0], a[1]-aOffset]
            b = [b[0], b[1]+bOffset]
        }else{
            a = [a[0], a[1]+aOffset]
            b = [b[0], b[1]-bOffset]
        }
    }
    [l[a[0]] + (a[1] + 1), l[b[0]] + (b[1] + 1)].sort()
}
