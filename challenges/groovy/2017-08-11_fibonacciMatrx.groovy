/*
https://codefights.com/challenge/fsnfooDM3fT4mGDQ6

In this task, you need to make an n × n matrix, in which you should represent the Fibonacci spiral. Each number in the spiral, 1, 2, 3, 5, 8, 13..., should be represented as that amount of the number 1.

The spiral will start in the middle of the matrix with the first number, 1. To represent the next number in the series, 2, we consider the existing 1 as the first part of that number and move to the left, adding another 1. To represent the next number, 3, we consider the existing 1 to be the first part and then move up, adding two more 1s. The spiral will grow in this manner until the point when it reaches the outer edge of the matrix without being able to complete a number in the series.

See the the examples below for a visual representation of what we mean!

Example

For n = 5, the output should be
fibonacciMatrix(n) =
[[0,1,1,1,1],
 [0,1,0,0,0],
 [0,1,1,0,0],
 [0,0,0,0,0],
 [0,0,0,0,0]]
The series starts from center of the matrix. First, you have one number 1. Then you go left and add another 1 to represent the number 2. Then you change direction 90 degrees clockwise (up) and write two more 1s to represent the number 3. The next number in the spiral should be five, but we only can fit three more 1s into the row for a total of 4, meaning that the series will terminate.

For n = 12, the output should be
fibonacciMatrix(n) =
[[0,0,0,0,0,0,0,0,0,0,0,0],
 [0,0,0,0,0,0,0,0,0,0,0,0],
 [0,0,0,0,0,0,0,0,0,0,0,0],
 [0,0,0,0,0,0,0,0,0,0,0,0],
 [0,0,0,0,0,1,1,1,1,1,0,0],
 [0,0,0,0,0,1,0,0,0,1,0,0],
 [0,0,0,0,0,1,1,0,0,1,0,0],
 [0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,0,0,1,0,0],
 [1,1,1,1,1,1,1,1,1,1,0,0]]
Input/Output

[time limit] 6000ms (groovy)
[input] integer n

The number of rows and columns in the given matrix.

Guaranteed constraints:
0 ≤ n < 260.

[output] array.array.integer

A Fibonacci spiral, represented as 1s in a matrix. All cells not occupied by numbers from the series should be represented as 0s.
 */

T fibonacciMatrix(n,m=[],y=1) {


    for(i in 0..<n)
        m << new int[n]

    int i,j,d,l,c,x
    i=j= n/2

    (1..20).each{
        l = x + y
        x = y
        y = l--
        while(l > 0 && i in 0..<n && j in 0..<n){
            m[i][j] = 1
            l--
            d == 0 && i++
            d == 1 && j--
            d == 2 && i--
            d == 3 && j++
        }
        d = ++d % 4
    }
    m
}
