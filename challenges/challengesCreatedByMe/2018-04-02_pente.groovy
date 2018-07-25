/*
https://app.codesignal.com/challenge/28JPkEv9P4WASy8MT

Pente is a game of stones played on a Go board.

Each player takes turns placing a stone on the board.
The objective is to place 5 of your stones in a row horizontally, vertically, or diagonally.

When a player has placed 4 open-ended stones in a row, they have nearly won the game, because the opposing player cannot block both ends on a single turn.

When a player has placed 3 open-ended stones in a row, they must be blocked or they can create a series of 4 stones on the next turn.

Assume that it is player two's turn.

Given a 15 × 15 board, and the positions of player one and player two.
Return the coordinates where player two should place a stone to block player one.

A position that is under threat from having a 5th (winning) stone placed is a higher priority than blocking the placement of a 4th stone.

If a position is under threat to have a 4th stone placed from multiple directions, it is a higher priority than a position that is only under threat from one direction.

Edit (Additional clarification): Any given coordinate has a threat priority level that is defined as follows:

Coordinates under threat from a 5th stone.
If any coordinate is under threat from the placement of a 5th stone, then any threats due to the placement of a 4th stone do not matter.
Coordinates under threat from a 4th stone that would result in an open-ended sequence of 4 stones, from multiple directions. The more directions, the higher the priority. (Test case 6).
Coordinates under threat from a 4th stone that would result in an open-ended sequence of 4 stones from only 1 direction.
If no stones under threat = empty list.
Example 1
For playerOne = [[7,7], [7,8], [7,9], [10,9]] and playerTwo = [[0,0],[6,8], [8,7], [9,8]], the output should be
penter(playerOne, playerTwo) = [[7,6], [7,10]].

  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4
0 2 _ _ _ _ _ _ _ _ _ _ _ _ _ _
1 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
2 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
3 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
4 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
5 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
6 _ _ _ _ _ _ _ _ 2 _ _ _ _ _ _
7 _ _ _ _ _ _ X 1 1 1 X _ _ _ _
8 _ _ _ _ _ _ _ 2 _ _ _ _ _ _ _
9 _ _ _ _ _ _ _ _ 2 _ _ _ _ _ _
0 _ _ _ _ _ _ _ _ _ 1 _ _ _ _ _
1 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
2 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
3 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
4 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
Player one should be blocked at either position marked X.

For playerOne = [[7,8], [9,6], [10,5], [10,9]] and playerTwo = [[10,6], [10,7], [10,8]], the output should be
penter(playerOne, playerTwo) = [[6,9], [11,4]].

  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4
0 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
1 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
2 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
3 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
4 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
5 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
6 _ _ _ _ _ _ _ _ _ X _ _ _ _ _
7 _ _ _ _ _ _ _ _ 1 _ _ _ _ _ _
8 _ _ _ _ _ _ _ 1 _ _ _ _ _ _ _
9 _ _ _ _ _ _ 1 _ _ _ _ _ _ _ _
0 _ _ _ _ _ 1 2 2 2 1 _ _ _ _ _
1 _ _ _ _ X _ _ _ _ _ _ _ _ _ _
2 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
3 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
4 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
Player one should be blocked at position X.

The goal is to return the highest-priority block, if it exists.

(In the game of Pente, players can also capture opponent's stones if they enclose 2 of them, but this rule is ignored for the sake of challenge simplicity.)

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.array.integer playerOne

Player One's positions

[input] array.array.integer playerTwo

Player Two's positions

[output] array.array.integer

Highest threat positions or an empty list if no positions are under threat.
Coordinates should be returned in lexical order.

*/

List<List<Integer>> pente(List<List<Integer>> playerOne, List<List<Integer>> playerTwo) {
  
    //Convert input to a grid
    def input = []
    15.times{input << new int[15]}
    playerOne.each{
        def x = it[0]
        def y = it[1]
        input[x][y] = 1
    }
    playerTwo.each{
        def x = it[0]
        def y = it[1]
        input[x][y] = 2
    }
    //Print out the input for easy debugging
    println "  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4\n"
    int row
    input.each{
        print row++%10 + " "
        println it.collect{it==0 ? "_" : it}.join(" ")
    }

    //Get the coordiantes under threat
    def coordinateThreat = [:]

    (0..<input.size()).each{x->
        (0..<input[0].size()).each{y->
            def threat = 0
            threat += getThreat(input,x,y, -1, 0) //up+down
            threat += getThreat(input,x,y, 0, -1) //left+right
            threat += getThreat(input,x,y, -1, -1) //diag1
            threat += getThreat(input,x,y, -1, 1) //diag2
            threat = threat >= 5 ? 5 : threat
            if(threat > 0){
                def coordinates = coordinateThreat[threat] ?: []
                coordinates << [x,y]
                coordinateThreat[threat] = coordinates
            }
        }
    }
    def maxThreat = coordinateThreat.keySet().max()
    return coordinateThreat[maxThreat] ?: []
}

def getThreat(input,x,y,offsetX,offsetY){
    def threat = 0
    if(input[x][y] == 0){
        int northCount = 0
        int offset = 1
        int i = x + offsetX
        int j = y + offsetY
        boolean canPlaceNorth = false
        while(offset <= 4 && j >= 0 && i >= 0 && j <input.size() && i < input.size() && input[i][j] == 1){
            northCount++
            offset++
            i = x+offset*offsetX
            j = y+offset*offsetY
        }
        if(offset==4 && j >= 0 && i >= 0 && j <input.size() && i < input.size() && input[i][j] == 0)
            canPlaceNorth = true

        int southCount = 0
        offset = 1
        i = x - offsetX
        j = y - offsetY
        boolean canPlaceSouth = false
        while(offset <= 4 && j >= 0 && i >= 0 && j <input.size() && i < input.size() && input[i][j] == 1){
            if(offset==4 && input[i][j] == 0)
                canPlaceSouth = true
            southCount++
            offset++
            i = x-offset*offsetX
            j = y-offset*offsetY
        }
        if(offset==4 && j >= 0 && i >= 0 && j <input.size() && i < input.size() && input[i][j] == 0)
            canPlaceSouth = true

        if(northCount >= 2 && southCount >= 1){
            threat = 5
        }else if(northCount >= 1 && southCount >= 2){
            threat = 5
        }else if(northCount == 4 || southCount == 4){
            threat = 5
        }else if(northCount == 3 && canPlaceNorth){
            threat = 1
        }else if(southCount == 3 && canPlaceSouth) {
            threat = 1
        }
    }
    return threat
}
