/*
https://codefights.com/arcade/code-arcade/list-forest-edge/3LmZafR9wMCWpdgra

We define the middle of the array arr as follows:

if arr contains an odd number of elements, its middle is the element whose index number is the same when counting from the beginning of the array and from its end;
if arr contains an even number of elements, its middle is the sum of the two elements whose index numbers when counting from the beginning and from the end of the array differ by one.
An array is called smooth if its first and its last elements are equal to one another and to the middle. Given an array arr, determine if it is smooth or not.

Example

For arr = [7, 2, 2, 5, 10, 7], the output should be
isSmooth(arr) = true.

The first and the last elements of arr are equal to 7, and its middle also equals 2 + 5 = 7. Thus, the array is smooth and the output is true.

For arr = [-5, -5, 10], the output should be
isSmooth(arr) = false.

The first and middle elements are equal to -5, but the last element equals 10. Thus, arr is not smooth and the output is false.

Input/Output

[time limit] 6000ms (groovy)
[input] array.integer arr

The given array.

Guaranteed constraints:
2 ≤ arr.length ≤ 105,
-109 ≤ arr[i] ≤ 109.

[output] boolean

true if arr is smooth, false otherwise.
 */

boolean isSmooth(List<Integer> arr) {

    def middlePoint = [(arr.size() / 2).toInteger()]
    if(arr.size() % 2 == 0){
        middlePoint[0] -= 1
        middlePoint << middlePoint[0] + 1
    }
    int middleValue = middlePoint.sum{arr[it]}
    [arr[0], arr[-1], middleValue].unique().size() == 1
}
