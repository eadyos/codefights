/*
https://codefights.com/challenge/axaYy8wMNuLJBRmRS

Find the nth Highly Composite number.

A highly composite number is a positive integer with more divisors than any smaller positive integer has.

For example:

Number  Divisors    Total Divisors  nth Highly Composite Number
1   1   1   1
2   1,2 2   2
3   1,3 2   
4   1,2,4   3   3
5   1,5 2   
6   1,2,3,6 4   4
First highly composite number is 1 since there are no numbers before it. Second is 2 because it has 1 more divisor than 1. 
Then 4 because it has 3, which is more than any number before it.

Solve for the nth highly composite number.

Example
For n = 3, the output should be
antiPrimes(n) = 4.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer n

Guaranteed constraints:
1 ≤ n ≤ 135.

[output] integer64

*/

long antiPrimes(n) {

   new BigInteger("x 1 2 4 6 c o 10 1c 1o 3c 50 6o a0 k0 nc z0 1ao 1y0 3w0 5u0 7s0 bo0 fk0 jg0 le0 z00 12w0 16s0 1s60 2dk0 3kc0 4r40 5xw0 74o0 ap00 bvs0 e9c0 fg40 n660 uw80 1acc0 1psg0 258k0 2koo0 3v100 4ah40 55dc0 6fpo0 8ky80 aaqo0 cvfc0 jb500 lvto0 pquo0 10h1g0 17rnc0 1tnh00 20y2w0 2fjao0 31f4c0 41w5s0 4v2lc0 62u8o0 949d00 bjsno0 c5ohc0 i8iq00 n3lbc0 yndz00 10h1g00 12hziw0 1a76mo0 1lqzac0 24zz1s0 2ked9c0 37hyko0 4t8xv00 6ezx5c0 9mhvq00 ctzuao0 j8zrg00 mghq0o0 til8hc0 xoql100 10w8jlo0 18wzg1c0 1n16gyo0 1vdh6200 21sh37c0 32opmt00 3qqyc400 43ky6eo0 65df9m00 875wctc0 caquj800 ecjbmfc0 khwqw1c0 liszfn00 olhp2g00 sp2n8uo0 14zths2o0 171lyva00 1le5ahpc0 2e37xqk00 36sakzeo0 3avvj5tc0 4s6fvh400 6lrr2bmo0 9kcvqy800 9wnmlhg00 bk3kd2co0 gifdnt2o0 hc5cjlj00 jtb96yw00 n474q4pc0 x0urbm5c0 yoap37200 1a8e9g9eo0 1xcle6e400 2kgsiwitc0 2udg5i09c0 3up6scs800 5oqwb00io0 7pedkpkg00 8j4cgi0s00 9yb2j90wo0 e7v8ri1ao0 exglsvjd00 h28ox01k00 jwm52i1tc0 sfqhj02lc0 tux7lr2q00 13t8a503mo0 1npuf7i5g00 27mgka079c0 2rj2pci92o0 3bfouf0aw00".split()[n],36)

      
}