=begin
https://codefights.com/arcade/intro/level-5/EEJxjQ7oo7C5wAGjE

Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.

Example

For inputArray = [2, 4, 1, 0], the output should be
arrayMaximalAdjacentDifference(inputArray) = 3.

Input/Output

[time limit] 4000ms (rb)
[input] array.integer inputArray

Guaranteed constraints:
3 ≤ inputArray.length ≤ 10,
-15 ≤ inputArray[i] ≤ 15.

[output] integer

The maximal absolute difference.
=end

def arrayMaximalAdjacentDifference(inputArray)

    (1...inputArray.size).collect{|i|
        (inputArray[i-1] - inputArray[i]).abs
    }.max

end
