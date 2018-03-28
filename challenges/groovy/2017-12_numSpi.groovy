/*
https://codefights.com/challenge/gr972YHyYBcguGziR

This is a reverse challenge, enjoy!

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer width

Guaranteed constraints:
0 ≤ width ≤ 200.

[input] integer height

Guaranteed constraints:
0 ≤ height ≤ 200.

[output] array.array.integer

see link for more input/output examples

width: 2
height: 20

Expected Output:
[[1,2], 
 [40,3], 
 [39,4], 
 [38,5], 
 [37,6], 
 [36,7], 
 [35,8], 
 [34,9], 
 [33,10], 
 [32,11], 
 [31,12], 
 [30,13], 
 [29,14], 
 [28,15], 
 [27,16], 
 [26,17], 
 [25,18], 
 [24,19], 
 [23,20], 
 [22,21]]

*/

T numSpi(w,h) {
    
    T a = w ? new int[h][w] : []
    
    int d,c,x,y,i,j
    y--    
    
    T o=[0,1,0,-1,0]
    while(c<w*h){
        i=x+o[d]
        j=y+o[d+1]
        j < w && i < h && i+1 && j+1 && !a[i][j] ?
            (a[x=i][y=j] = ++c)
        :
            (d=++d%4)
    }    
    a
    
}
