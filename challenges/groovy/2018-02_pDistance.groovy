/*
https://codefights.com/challenge/y2YhExQi3bPBE4XKb


Two vertical pole, height a and b, are located at a distance c one from another. It is desired to connect its upper ends 
with a cable, which must also touch the ground between both, as the figure shows. At what point x of the ground, which is
 supposed to be horizontal.

Where you should tie the cable in x so that its length is minimal?

image

Example
For a = 1, b = 1 and c = 1, the output should be
pDistance(a, b, c) = 0.5.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer a

Height pole a.

Guaranteed constraints:
0 ≤ a ≤ 100000.

[input] integer b

Height pole b.

Guaranteed constraints:
0 ≤ b ≤ 100000.

[input] integer c

Distance c.

Guaranteed constraints:
0 ≤ c ≤ 100000.

[output] float

Distance x.
*/

T pDistance(a, b, c) {
    
    b+=a?:1
    a / b * c
}


