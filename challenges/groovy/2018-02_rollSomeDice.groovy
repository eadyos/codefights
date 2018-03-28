/*
https://codefights.com/challenge/Y7WJEdr8RSzr5yPbz


When you roll some dice, there are many different possible outcomes. The more dice you roll, the higher the value of the 
outcomes on average. You're curious about how the outcome of a theoretical roll would be, so you decided to write a program 
that simulates it (kinda) for yourself!

Example
For dices = 2, the output should be
rollSomeDice(dices) = [[2, 1], [3, 2], [4, 3], [5, 4], [6, 5], [7, 6], [8, 5], [9, 4], [10, 3], [11, 2], [12, 1]].

Suppose you roll two dice:

1   2   3   4   5   6
1   2   3   4   5   6   7
2   3   4   5   6   7   8
3   4   5   6   7   8   9
4   5   6   7   8   9   10
5   6   7   8   9   10  11
6   7   8   9   10  11  12
There is 1 way to get 2 or 12, 2 ways to get 3 or 11, etc, for all 11 values in 2 to 12. So return this array as a count for 
all the results:

2   3   4   5   6   7   8   9   10  11  12
1   2   3   4   5   6   5   4   3   2   1
[[2, 1], [3, 2], [4, 3], [5, 4], [6, 5], [7, 6], [8, 5], [9, 4], [10, 3], [11, 2], [12, 1]].

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer dices

An integer, describing how many dice we have.

Guaranteed constraints:
1 ≤ dices ≤ 20.

[output] array.array.integer64

A 2-dimensional array with the following pairs of values:
A number, representing the sum of the dices being rolled of a combination.
A number which is the count of the number of times the sum will be reached out of every combination of the dice results.
The entire array must be sorted according to the sum, that is the result would be arranged from dices to dices * 6 in ascending order.

*/

T rollSomeDice(n) {
  
    (n..n*6).collect{x->
        [x, 
            {
                T t = new long[n + 1][x + 1]

                for (T j = 1; j < 7 && j <= x;)
                    t[1][j++] = 1

                for (T i = 1; i < n; i++)
                    for (T j = 1; j <= x; j++)
                        for (T k = 1; k < 7 && k < j;)
                            t[i+1][j] += t[i][j-k++]

                t[n][x]
            }()        
        ]
    }
}
