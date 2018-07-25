/*
https://app.codesignal.com/challenge/FRvDNjYNZFDdjkTyb

You're a famous treasure hunter who collects artifacts from all around the world. On your most recent quest, you've entered a dungeon to collect an ancient artifact. You have a map of each floor, so you are able to avoid all the deadly traps easily. Once you reach the bottom, you pick up the artifact, but suddenly, the entire dungeon begins collapsing! You must now leave the dungeon as quickly as possible while still avoiding the traps!

Given a two dimensional array which represents the map of the dungeon, return the length of the shortest path between the two doors. The path may only move in the four cardinal directions (left, right, up, down), and cannot touch any trap. Each tile you would have to move counts towards your path length, so a path between two adjacent doors has a length of 1. You have already traveled through the dungeon, so you know that there is always a possible route.

Examples

For
map =  [[0, 0, 0, 0],
        [2, 0, 1, 0],
        [0, 1, 0, 0],
        [1, 0, 2, 0]]
the output should be shortestPathBetweenDoors(map) = 8.

If the above is the dungeon floor, a path must be drawn around the traps in the center. There are a few similar routes, but they will all look something like this:

[[⇨,⇨,⇨,⇩],
 [2, 0, 1,⇩],
 [0, 1, 0,⇩],
 [1, 0, 2,⇦]]
Note that starting from the other door gives you the same result, just backwards. You must move 8 squares to reach your destination, so the output should be 8.

For
map = [[0, 0],
       [2, 2]]
the output should be shortestPathBetweenDoors(map) = 1.

The exits are right next to each other, so you only need to move 1 tile to reach one door from the other.

[execution time limit] 6 seconds (groovy)

[input] array.array.integer map

A matrix of integers representing the dungeon. A 0 represents a floor tile, which you may use in your path. A 1 represents a trap and must be avoided. A 2 represents a door, which you enter and exit the floor from. There will always be exactly two doors on the map, and it's guaranteed that there's a path between them. No other numbers will be in the array.

Guaranteed constraints:
2 ≤ map.length ≤ 1000
2 ≤ map[i].length ≤ 1000
0 ≤ map[i][j] ≤ 2

[output] integer

The length of the shortest possible path between the two doors on the map. The path must travel only in the cardinal directions and avoid traps.

*/

T shortestPathBetweenDoors(m) {

    T e = []
    T d = []
    
    T l = m[0].size
    T p = m.size
    
    for(i in 0..<p) {
        d << [-1] * l
        for (j in 0..<l)
            m[i][j] - 2 || e << [i, j]
    }

    T s = e[0]
    T f = [s]
    d[s[0]][s[1]] = 0

    T t

    T c

    while(c != e[1]){
        c = f.remove 0
        t = d[c[0]][c[1]]
        [[-1,0],[1,0],[0,-1],[0,1]].min{
            T x = c[0] + it[0]
            T y = c[1] + it[1]
            if(x >= 0 & x < p & y >= 0 & y < l && d[x][y] < 0 && m[x][y] - 1){
                f << [x,y]
                d[x][y] = t + 1
            }
        }
    }
    t
}