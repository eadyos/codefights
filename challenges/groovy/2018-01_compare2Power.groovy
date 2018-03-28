/*
https://codefights.com/challenge/232L7JtNciBKFfQuS

Let A = a^(b^(c^d)) and B = x^(y^(z^t)).
You have to compare A and B.

Input an array m with length 8.
m[0] = a, m[1] = b, m[2] = c, m[3] = d, m[4] = x, m[5] = y, m[6] = z and m[7] = t.
If A &gt; B, return 1.
If A == B, return 0.
If A &lt; B, return -1.

Example

For m = [2, 5, 2, 5, 5, 2, 5, 2], the output should be compare2Power(m) = 1.
It means 2^(5^(2^5)) &gt; 5^(2^(5^2)).

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.integer m

An array contains 8 integers: a, b, c, d, x, y, z, t.

Guaranteed constraints:
m.length == 8,
2 ≤ m[i] ≤ 100.

[output] integer

If A &gt; B, return 1.
If A == B, return 0.
If A &lt; B, return -1.


*/

T compare2Power(m) {
  
    m[2]**m[3] <=> m[6]**m[7]
    
}

