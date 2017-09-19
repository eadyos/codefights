/*
https://codefights.com/challenge/vQ3EJBWeGDHEPb8aK

You are at the International Monkey Bars Climbing Competition 2017! Each contestant must climb various stretches of monkey bars during each round. The rules are that you may not more move than 3 bars at a time. Find the number of distinct ways to climb a given section.

Example
For n = 4, the output should be
monkeyBars(n) = 7.
        There are 7 distinct ways to climb the bars - 3 + 1, 1 + 3, 2 + 1 + 1, 1 + 2 + 1, 1 + 1 + 2, 1 + 1 + 1 + 1, 2 + 2.

        Input/Output

[time limit] 6000ms (groovy)
[input] integer n

Number of bars.

        Guaranteed constraints:
        1 ≤ n ≤ 60.

[output] integer64

Number of distinct ways to climb.

*/


T monkeyBars (n) {
    long a,b,c=1
    n.times{
        c=a+(a=b)+(b=c)
    }
    c
}