/*
https://app.codesignal.com/challenge/NaRWRm97N9Y6pjHF8

You are given an array of positive integers (not necessary distinct). Calculate the number of permutations of this array such that the value of each term in the permutation is not less than its index (consider in 1-index). Since the answer can be rather large, return this value modulo 109 + 7.

Example
For data = [1, 2, 3], the output should be
specialPermutation(data) = 1.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.integer data

Guaranteed constraints:
0 < data.length ≤ 104,
0 < data[i] ≤ 106.

[output] integer

*/

T SpecialPermutation(d) {
  

    d.sort{-it}
    T c = 0
    T r = 1l
    T s = d.size()
    (s..1).min{
        while(d[c] >= it)
            c++
        T v = it - (s - c)
        r*= v > 0 ? v : 0
        r%=10**9+7
    }
    r
    
    
    
}
