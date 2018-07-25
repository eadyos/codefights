/*
https://app.codesignal.com/challenge/3PxxRAT5q2ENnjjyR

Jackichul is queuing to buy the final ticket VCSA between GAM and EVOS. There are n people queuing but he cannot know exactly his location. He only know that there are not fewer than a people in front of him and there are not over b people behind him. Find the number of different location that Jackichul can stand.

Example
For n = 4, a = 1 and b = 2, the output should be
buyTicket(n, a, b) = 3.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer64 n

Guaranteed constraints:
0 < n < 1016.

[input] integer64 a

Guaranteed constraints:
0 ≤ a < n.

[input] integer64 b

Guaranteed constraints:
0 ≤ b < n.

[output] integer64

*/

T buyTicket(n, a, b) {

    a > n- ++b ? n-a : b
    
}
