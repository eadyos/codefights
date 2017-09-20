/*
https://codefights.com/arcade/code-arcade/list-forest-edge/vPJB7T28fyCeh2Ljn

Remove a part of a given array between given 0-based indexes l and r (inclusive).

Example

For inputArray = [2, 3, 2, 3, 4, 5], l = 2 and r = 4, the output should be
removeArrayPart(inputArray, l, r) = [2, 3, 5].

Input/Output

[time limit] 6000ms (groovy)
[input] array.integer inputArray

Guaranteed constraints:
2 ≤ inputArray.length ≤ 10,
-10 ≤ inputArray[i] ≤ 10.

[input] integer l

Left index of the part to be removed (0-based).

Guaranteed constraints:
0 ≤ l ≤ r.

[input] integer r

Right index of the part to be removed (0-based).

Guaranteed constraints:
l ≤ r < inputArray.length.

[output] array.integer
 */

List<Integer> removeArrayPart(List<Integer> inputArray, int l, int r) {

    (0..<l).collect{inputArray[it]} +
            (r+1..<inputArray.size()).collect{inputArray[it]}

}
