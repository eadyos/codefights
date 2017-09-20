/*
https://codefights.com/arcade/intro/level-12/uRWu6K8E7uLi3Qtvx

Construct a square matrix with a size N × N containing integers from 1 to N * N in a spiral order, starting from top-left and in clockwise direction.

Example

For n = 3, the output should be

spiralNumbers(n) = [[1, 2, 3],
                    [8, 9, 4],
                    [7, 6, 5]]
Input/Output

[time limit] 6000ms (groovy)
[input] integer n

Matrix size, a positive integer.

Guaranteed constraints:
3 ≤ n ≤ 10.

[output] array.array.integer
 */

List<List<Integer>> spiralNumbers(int n) {

    //Build Matrix
    def m = []
    (0..<n).each{m << new Integer[n]}

    def dir = "right"
    def x = 0
    def y = 0
    (1..(n*n)).each{num->
        m[x][y] = num
        if(dir == "right"){
            if(y + 1 < m[0].size() && !m[x][y + 1]){
                y += 1
            }else{
                x += 1
                dir = "down"
            }
        }else if(dir == "down"){
            if(x + 1 < m.size() && !m[x+1][y]){
                x += 1
            }else{
                y -= 1
                dir = "left"
            }
        }else if(dir == "left"){
            if(y - 1 >= 0 && !m[x][y-1]){
                y -= 1
            }else{
                x -= 1
                dir = "up"
            }
        }else{
            if(!m[x-1][y]){
                x -= 1
            }else{
                y += 1
                dir = "right"
            }
        }
    }
    return m

}
