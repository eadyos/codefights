/*
https://codefights.com/challenge/hFYXqhed542aq6pWX

This is a reverse challenge, enjoy!

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer64 n

Guaranteed constraints:
0 ≤ n ≤ 9007199254740991.

[output] integer




*/

T firstorlastBase2(n) {

    n.toString("$n"[n < 999 ? -1 : 0] as int, 2) as int
    
}
