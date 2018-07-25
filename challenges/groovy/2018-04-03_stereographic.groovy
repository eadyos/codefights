/*
https://app.codesignal.com/challenge/nrD5k2hZdPSfs7REe

This is a reverse challenge, enjoy!

[execution time limit] 6 seconds (groovy)

[input] array.float coordinates

Guaranteed constraints:
2 ≤ coordinates.length ≤ 100,
-100 ≤ coordinates[i] ≤ 100.

[output] array.float

Test 1
Input:
coordinates: [1, 1]
Output:
Run the code to see output
Expected Output:
[3.414213562373094]

Input:
coordinates: [0.6, 0.8]
Output:
Run the code to see output
Expected Output:
[2]
Console Output:
Empty

see link for more


*/

T stereographic(c) {

 c*.div 1 - c[0] / c.sum{it*it + 1e-10}**0.5 tail()

}