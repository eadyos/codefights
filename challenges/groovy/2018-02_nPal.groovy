/*
https://codefights.com/challenge/r8bT4u7QQWpSB84v5


This is a reverse challenge, enjoy!

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer n

Guaranteed constraints:
0 ≤ n ≤ 2000.

[output] integer

n: 15
Expected Output:
66

...see link for more

*/

int nPal(int n) {
    
    def l = (0..1000001).findAll{
        it.toString() == it.toString().reverse()
    }
    l.getAt(n) ?: 0
    
}
