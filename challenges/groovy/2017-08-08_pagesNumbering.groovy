/*
https://codefights.com/challenge/nabwYC86fLpi5NgjN

Given a number of the pages in some book find the number of digits one needs to print to enumerate the pages of the book.

Example

For n = 11, the output should be
pagesNumbering(n) = 13.

Input/Output

[time limit] 6000ms (groovy)
[input] integer n

A positive integer.

Guaranteed constraints:
1 ≤ n ≤ 108.

[output] integer
 */


T pagesNumbering(n) {

    int m,f,t
    m=1

    while(m <= n){
        m *= 10
        t += (m<=n ? 9 * m/10 : n - (m/10-1)) * ++f
    }
    t
}
