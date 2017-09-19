=begin
https://codefights.com/challenge/NXE7XwgYZvCXRY6PW


Given a non-negative integer k, you task is to calculate the result of the bitwise OR operation of all the integers from 0 to k, inclusive.

Example

For k = 5, the output should be
totalOr = 7.

0 | 1 | 2 | 3 | 4 | 5 = 02 | 12 | 102 | 112 | 1002 | 1012 = 1112 = 7.

Input/Output

[time limit] 4000ms (rb)
[input] integer k

Guaranteed constraints:
0 ≤ k < 231

[output] integer

Guaranteed constraints:
result < 231
=end

def totalOr k
    k<1?0:2**k.to_s(2).size-1

    #k.to_s(2).gsub(?0,?1).to_i 2

end
