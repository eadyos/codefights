/*
https://codefights.com/challenge/HM5GQi6CRgkFtntFC

This is a reverse challenge, enjoy!

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer n

Guaranteed constraints:
1 ≤ n ≤ 100.

[output] array.array.integer

example input/outout. see link for more

n: 3
Expected Output:
[[1,2,6], 
 [3,5,7], 
 [4,8,9]]

*/

T zZIAGG(n) {
  
    T r = new int[n][n]
    int x,y,d
    (1..n*n).each{
        r[x][y] = it
        if(!d){
            if(x-1 >=0 && y+1 < n){
                x--
                y++
            }else if(y+1 < n){
                y++
                d=1
            }else{
                x++
                d=1
            }
        }else{
            if(x+1 <n && y-1 >= 0){
                x++
                y--
            }else if(x+1 < n){
                x++
                d=0
            }else{
                y++
                d=0
            }
        }   
    }
    r
}
//No time for code golf today
