=begin
https://codefights.com/arcade/intro/level-2/xzKiBHjhoinnpdh6m

Given an array of integers, find the pair of adjacent elements that has the largest product and return that product.

Example

For inputArray = [3, 6, -2, -5, 7, 3], the output should be
adjacentElementsProduct(inputArray) = 21.

7 and 3 produce the largest product.

Input/Output

[time limit] 4000ms (rb)
[input] array.integer inputArray

An array of integers containing at least two elements.

Guaranteed constraints:
2 ≤ inputArray.length ≤ 10,
-1000 ≤ inputArray[i] ≤ 1000.

[output] integer

The largest product of adjacent elements.
=end

def adjacentElementsProduct(inputArray)

    (0...inputArray.size-1).collect{|n|
        inputArray[n] * inputArray[n+1]
    }.sort.last

end
