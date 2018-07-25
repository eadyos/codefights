/*
https://app.codesignal.com/challenge/uYSoY28HtFcfuhdYS

Given a matrix of integers, your task is to find the biggest plus (+) shape formed by adjacent equal numbers.

More formally, the size of the plus is based on the distance from its centre to its shortest arm. For example, the plus formed by the 2's below would have a size of 1, even though one of its arms extends further.

[[1,0,2,3],
 [2,2,2,2],
 [4,3,2,5]]
Specifically, we would like to find the coordinates of the center of the biggest plus (row index and column index). If there is more than one biggest plus, return the coordinates with the smallest row index; if there is more than one biggest plus with the same row indices, return the coordinates with the smallest column index.

Example

For
arr = [[6,8,0,5,9,6,7,8,9,7], 
       [6,6,0,1,9,6,7,8,2,7], 
       [7,7,7,7,7,7,7,7,7,7], 
       [6,7,0,1,7,6,7,6,7,7], 
       [6,6,0,1,6,6,7,6,9,7], 
       [6,6,0,1,6,6,7,6,6,7], 
       [1,1,1,1,1,1,7,1,1,7], 
       [8,8,0,1,6,6,7,6,6,7], 
       [1,1,1,1,1,1,7,6,5,7]]
the output should be biggestPlus(arr) = [2, 6]

although there's another plus of size 2 centered at [6, 3], the one at [2, 6] has a smaller row index

Input / Output

[execution time limit] 6 seconds (groovy)

[input] array.array.integer arr

A rectangular matrix of whole numbers

Guaranteed constraints:
1 ≤ arr.length ≤ 500,
1 ≤ arr[i].length ≤ 500,
0 ≤ arr[i][j] ≤ 10.

[output] array.integer

A 2-element array consisting of the row index and column index of the center of the biggest plus made up of equal numbers

*/

T biggestplus(m) {
    
    T r = m.size
    T s = m[0].size
    T c
    int z
    for(i in 0..<r)
        (0..<s).min{j->
            T x=[[-1,0],[1,0],[0,-1],[0,1]].collect{
                T a,b,o = 1
                while((a=i+o*it[0]) >= 0 && a<r && (b=j+o*it[1]) >= 0 && b<s && m[a][b] == m[i][j])
                    o++
                
                o
            }min()
            if(x > z){
                z = x
                c = [i,j]
            }
        }

    
    c
    
}
