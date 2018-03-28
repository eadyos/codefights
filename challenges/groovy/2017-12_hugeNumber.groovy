/*
https://codefights.com/challenge/6vsr4h45Kji7bSuiQ


Given an array of string numbers (i.e. strings that contain only digits), return the greatest possible number of 
appending these numbers to each other as a string.

Example

For nums = [ "20", "3005", "2" ], the output should be
greatestNumber(nums) = "3005220".
Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.string nums

An array of string numbers (i.e. strings that contain only digits).
String numbers are valid integer non-negative numbers.

Guaranteed constraints:
0 < nums.length ≤ 50,
0 < nums[i].length ≤ 6.

[output] string

The greatest possible number of appending given array's numbers to each other as a string.
*/

T hugeNumber(n) {

    n.sort{a,b->
        b+a <=> a+b
    }.join() as BigInteger
}
