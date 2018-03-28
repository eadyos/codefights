/*
https://codefights.com/challenge/LyTYTjZBNHTLBMkrv

A circular mass of negligible radius is suspended from the circumference of a larger circular mass of radius r via a string of length l. 
The larger mass is held in place while the smaller mass hangs directly under it. The smaller mass is then given a horizontal kick strong 
enough to make it collide with the larger mass. If the string is kept taut until the masses collide how much area did the string cover 
before the collision?

Drawing (See link)

Alternative Art thanks to @ernie_y

Ernie

Example
For r = 1 and l = 1, the output should be
areaOne(r, l) = 0.9520648300974482.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] float r

Radius of large mass.

Guaranteed constraints:
1 ≤ r ≤ 100000.

[input] float l

Length of string suspending the smaller mass.

Guaranteed constraints:
1 ≤ l ≤ π*r.

[output] float

Area covered by string.

*/

T areaOne(r, l) {
  
    
    Math.PI * l*l / 4    +    l**3 / 6 / r

}
