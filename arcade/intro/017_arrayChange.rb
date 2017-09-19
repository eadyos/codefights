=begin
https://codefights.com/arcade/intro/level-4/xvkRbxYkdHdHNCKjg

You are given an array of integers. On each move you are allowed to increase exactly one of its element by one. Find the minimal number of moves required to obtain a strictly increasing sequence from the input.

Example

For inputArray = [1, 1, 1], the output should be
arrayChange(inputArray) = 3.

Input/Output

[time limit] 4000ms (rb)
[input] array.integer inputArray

Guaranteed constraints:
3 ≤ inputArray.length ≤ 105,
-105 ≤ inputArray[i] ≤ 105.

[output] integer

The minimal number of moves needed to obtain a strictly increasing sequence from inputArray.
It's guaranteed that for the given test cases the answer always fits signed 32-bit integer type.
=end

def arrayChange(inputArray)

    ceiling = nil
    turns = 0
    inputArray.each{|n|
        if !ceiling || n > ceiling
            ceiling = n
        else
            ceiling += 1
            turns += ceiling - n
        end
    }
    turns

end
