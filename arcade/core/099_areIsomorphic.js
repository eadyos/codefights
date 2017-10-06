/*
https://codefights.com/arcade/code-arcade/list-backwoods/xKYm98etd9JRsTcZY

Two two-dimensional arrays are isomorphic if they have the same number of rows and each pair of
respective rows contains the same number of elements.

Given two two-dimensional arrays, check if they are isomorphic.

Example

For

array1 = [[1, 1, 1],
          [0, 0]]
and

array2 = [[2, 1, 1],
          [2, 1]]
the output should be
areIsomorphic(array1, array2) = true;

For

array1 = [[2],
          []]
and

array2 = [[2]]
the output should be
areIsomorphic(array1, array2) = false.

Input/Output

[time limit] 6000ms (groovy)
[input] array.array.integer array1

Guaranteed constraints:
1 ≤ array1.length ≤ 5,
0 ≤ array1[i].length ≤ 5,
0 ≤ array1[i][j] ≤ 50.

[input] array.array.integer array2

Guaranteed constraints:
1 ≤ array2.length ≤ 5,
0 ≤ array2[i].length ≤ 5,
0 ≤ array2[i][j] ≤ 50.

[output] boolean
*/

function areIsomorphic(array1, array2) {

    isomorphic = array1.length == array2.length;

    for(i=0; i < array1.length && isomorphic; i++){
        isomorphic = array1[i].length == array2[i].length;
    }

    return isomorphic;

}
