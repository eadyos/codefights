/*
https://app.codesignal.com/challenge/7scRyRXmG5R8PigCY

You just got a job as the egg-catcher in a poorly-designed egg factory.

The chickens are all lined up in a row on one side of the factory.
Each chicken has a conveyor belt under it that is delivering dropped eggs to you.
If you are at the end of a conveyor belt when the egg arrives, you catch it.
If not, the egg falls onto the floor and you do not catch it.

You begin your shift at the conveyor belt for chicken #1.

During a "turn":

Eggs travel down the conveyor belts 1 positional unit.
You can move 1 position to the left, 1 position to the right, or stay where you are.
Given the input. Return the maximum number of eggs that you could possibly catch during your shift.

Example
For numberOfChickens = 3, conveyorLength = 1 and eggs = [[1, 3], [2], [3] ], the output should be
catchTheEggs(numberOfChickens, conveyorLength, eggs) = 3.

Turn1:

---------------
Chickens  1 2 3
Conveyor  o   o
You       U
---------------
Stay by chicken1 and catch 1 egg.
You could move to chicken2, but there is no egg there.
You can't reach chicken 3 because you can only move
1 position to the left or right.

Turn2:

---------------
Chickens  1 2 3
Conveyor    o
You         U
---------------
Move to chicken2 and catch 1 egg.

Turn3:

---------------
Chickens  1 2 3
Conveyor      o
You           U
---------------
Move to chicken3 and catch 1 egg.

So, the number of caught eggs is 3.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer numberOfChickens

The number of chickens.

Guaranteed constraints:
0 ≤ numberOfChickens ≤ 500.

[input] integer conveyorLength

The length of the conveyor belts.

Guaranteed constraints:
0 < n ≤ 100.

[input] array.array.integer eggs

List of arrays containing the egg positions as they come down the conveyor belts.

Guaranteed constraints:
0 ≤ eggs.length ≤ 500.

[output] integer

The maximum number of eggs you could possibly catch.

*/

//The problem is essentially a shortest path solution.
//Consider a 2d graph where the start space is 0,0
//Chart a path to the top row on the grid, which is the row after all the eggs
//have been dropped.
//Chart this path using Dijkstra’s algorithm for uniform cost search.
//The coordinates without eggs have a movement cost of 1, the coordinates with
//eggs have a movement cost of 0.
//Once the map has been generated,  chart the path from every position on the top
//row, back to the starting position, counting the number of eggs along the way.
//The path back to the start with the most number of eggs is the answer.
//
//The conveyor belt length is just artificial complication that can add artificial rows
//to the bottom of the graph, allowing the egg cathcer to reach a wider breadth
//of starting positions.
//
//I'm in the discord server.  Msg me if you have any questions or concerns.
    


//Rolled my own Priority Queue class because Java's is unecessarily complicated.
def class PQueue{
    def tm = new TreeMap()

    def put(val, priority){
        def list = tm[priority] ?: []
        list << val
        tm[priority] = list
    }

    def isEmpty(){
        tm.isEmpty()
    }

    def nextValue(){
        def list = tm.entrySet()[0]
        def n = list.value.remove(0)
        if(list.value.isEmpty()){
            tm.remove(list.key)
        }
        return n
    }
}

//Returns the coordinates that the current position can
//navigate to.  Since we are dealing with conveyor belts
//and the user can only move left/right/center.
//This returns neighbors to the NorthWest/North/NorthEast
//if they are within the bounds of the graph.
def getNeighbors(grid, value){
    def height = grid.size()
    def width = grid[0].size()

    int x = value[0]
    int y = value[1]
    def neighbors = []
    x++
    if(x < height){
        (-1..1).each{
            def j = y + it
            if(j >= 0 && j < width){
                neighbors << [x,j]
            }
        }
    }
    return neighbors
}

//Movement cost for spaces with eggs is free (0)
//movement cost for spaces without eggs is (1)
def getCost(grid, next){
    def x = next[0]
    def y = next[1]
    return grid[x][y]
}



int catchTheEggs(int numberOfChickens, int conveyorLength, List<List<Integer>> eggs) {    
    def grid = []
    grid << [1] * numberOfChickens //bottom row of graph where user starts
    //Pad for height
    //Artificial rows based on conveyor belt length
    def padding = conveyorLength - 1
    padding.times{
        grid << [1] * numberOfChickens
    }
    eggs.each{row->
        grid << (1..numberOfChickens).collect{i->
            row.contains(i) ? 0 : 1
        }
    }
    //Top row are all the end points of the graph
    //perhaps not necessary.
    grid << [1] * numberOfChickens //top
    

    def start = [0,0]
    def frontier = new PQueue()
    frontier.put(start, 0)
    def cameFrom = [:]
    def costSoFar = [:]
    cameFrom[start] = null
    costSoFar[start] = 0

    while(!frontier.isEmpty()){

        def current = frontier.nextValue()

        for(def next in getNeighbors(grid, current)) {
            def newCost = costSoFar[current] + getCost(grid, next)
            if(costSoFar[next] == null || newCost < costSoFar[next]){
                costSoFar[next] = newCost
                def priority = newCost
                frontier.put(next, priority)
                cameFrom[next] = current
            }
        }
    }

    def width = numberOfChickens
    def height = grid.size() - 1
    def result = (0..<width).collect{y->
        def check = [height,y]
        int eggCount = 0
        while(cameFrom[check]){
            check = cameFrom[check]
            if(getCost(grid, check) == 0){
                eggCount++
            }
        }
        eggCount
    }.max()

    return result
}


