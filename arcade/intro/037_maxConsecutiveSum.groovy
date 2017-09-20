/*
https://codefights.com/arcade/intro/level-8/Rqvw3daffNE7sT7d5

Given array of integers, find the maximal possible sum of some of its k consecutive elements.

Example

For inputArray = [2, 3, 5, 1, 6] and k = 2, the output should be
arrayMaxConsecutiveSum(inputArray, k) = 8.
All possible sums of 2 consecutive elements are:

2 + 3 = 5;
3 + 5 = 8;
5 + 1 = 6;
1 + 6 = 7.
Thus, the answer is 8.
Input/Output

[time limit] 6000ms (groovy)
[input] array.integer inputArray

Array of positive integers.

Guaranteed constraints:
3 ≤ inputArray.length ≤ 105,
1 ≤ inputArray[i] ≤ 1000.

[input] integer k

An integer (not greater than the length of inputArray).

Guaranteed constraints:
1 ≤ k ≤ inputArray.length.

[output] integer

The maximal possible sum.
 */

int arrayMaxConsecutiveSum(List<Integer> inputArray, int k) {

    def sums = []
    (0..(inputArray.size()-k)).each{
        if(sums.isEmpty()){
            sums << (it..<it + k).sum{inputArray[it]}
        }else{
            sums << sums.last() + inputArray[it + k - 1] - inputArray[it-1]
        }
    }
    sums.max()
}
