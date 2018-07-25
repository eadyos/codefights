/*
https://app.codesignal.com/challenge/J2KshRwM483QWTwYe

Your terraforming crew is busy at work on a mountaintop, but it's time to break for lunch. In order to allow everyone to have lunch together, we'd like to find a plateau on the mountain where everyone can sit.

Given a topographic map in the form of a matrix of integers map, find the area of the largest plateau.

Example

For

map = [[1,0,0,2,2,0],
       [0,0,2,1,0,2],
       [0,1,1,2,2,2],
       [1,2,1,0,2,1]]
the output should be largestPlateau(map) = 5. The crew could either choose the plateau with elevation 0 or the one with elevation 2; both of which have an area of 5:

relief maps

Input / Output

[execution time limit] 6 seconds (groovy)

[input] array.array.integer map

A matrix of integers representing the height at each point of the topographic map of the mountain.

Guaranteed constraints:
0 ≤ map.length ≤ 1000
0 ≤ map[i].length ≤ 1000
0 ≤ map[i][j] ≤ 106

[output] integer

The area of the largest plateau on the map (largest number of adjacent elements sharing the same value).

*/

T largestPlateau(m) {
  
    T l = m.size()
    int r,i
    for(;i < l;i++){
        T w = m[0].size()
        for(int j; j < w; j++){
            T v = m[i][j]
            T p = 0
            if(v+1){
                T q = [[i,j]]
                while(q){
                    T c = q.pop()
                    T f = c[0]
                    T g = c[1]
                    if(m[f][g] == v){
                        p++
                        m[f][g] = -1
                        [[-1,0],[1,0],[0,-1],[0,1]].each{
                            T x = it[0] + f
                            T y = it[1] + g
                            if(x+1 && x < l && y+1 && y < w)
                                q << [x,y]
                        }
                    }
                }
            }
            r = p > r ? p : r
        }
    }
    r
    
    
}
