/*
https://codefights.com/challenge/Q5RvzSFqEreKFmf2Y

This is a reverse challenge, enjoy!

Input/Output

[time limit] 6000ms (groovy)
[input] integer n

Guaranteed constraints:
1 ≤ n ≤ 20.

[input] integer k

Guaranteed constraints:
1 ≤ k ≤ n.

[output] integer
 */

//The solution rsums the first elements of the nth row of pascals triangle

T beautyOfMath(n,k) {
    T r = 1
    (1..2*k).sum{
        r = r * n/it - r
    }+1
}


