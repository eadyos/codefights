/*
https://codefights.com/challenge/RfYr4qxMnJKjRh6MP

Water and fire are two elements that bring great power. There are water gem (W), fire gem (F) and non-elemental gem (N). 
The magician wants to put it into a sequence of length n to create a super power. However, two fire gems can not placed side by side, 
two water gems can not placed side by side because it will not be able to control. Non-elemental gem can be placed anywhere and 
placed side by side.
Because this result can be very large, return it modulo 109 + 7.

Example
For n = 2, the output should be
gemPower(n) = 7.
These are: FN, FW, WF, WN, NF, NW, NN.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer n

Guaranteed constraints:
1 ≤ n ≤ 107.

[output] integer
*/

T gemPower(n) {

  T x,y
  x=y=1l
   
   n.times{
      y = x + 2*(x=y)
      y%=10**9 + 7
   }
   y
      
}

