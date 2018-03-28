/*
https://codefights.com/challenge/i4TuixjTHTDTFZ3nZ

You were rummaging around your closet looking for pants when you fell into a time warp. Now you are back in highschool! 
You have to do your homework (again). Luckily, you know how to do this stuff!
At the time, you were taking Algebra. You are too lazy to do the work out a second time, so you write a 
program to do it for you.
Your assignment is simple. You are working with quadratics and must solve for "x".
Given an array coefficients, return an array of answers in increasing order, rounded to the nearest hundredths place.

Example
For coefficients = [1, -4, 4], the output should be
highschoolThrowback(coefficients) = [2].

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.float coefficients

Guaranteed constraints:
coefficients.length = 3,
-105 ≤ coefficients[i] ≤ 105.

[output] array.float

An array of answer(s), sorted and rounded to the nearest hundredths.

*/

T highschoolThrowback(a,b,c) {
  
    [1,-1].collect{
        ((it*(b*b - 4*a*c)**0.5 - b) / (2 * a)).round 2
    } as TreeSet
    
}

    

