/*
https://codefights.com/challenge/QFgZGhQYc6GRZM65F

This is part of a series of reverse challenges, however it is self-contained and you do not need to have seen 
my other reverse challenges to attempt it. For your convenience, the public test cases can be viewed here cleanly.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer d

A non-zero integer digit.

Guaranteed constraints:
1 ≤ d ≤ 9.

[output] array.integer

An array of unique (non-repeating) numbers.




*/

T vainglory(d) {
    
    T a = ["$d"]
    
    for(n in 0..7)
    for(v in a.grep{it.size() > n})
    for(i in "          245 13456   256 12578   12346789    23589   458 45679   568".split("\t")[v[-1] as int])
    v.grep(i) || a << v+i
    

    a*.toLong() - d
}
