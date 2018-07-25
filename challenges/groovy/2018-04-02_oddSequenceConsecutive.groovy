/*
https://app.codesignal.com/challenge/R5nr9e9wDdRpEXStc


Given a sequence of integers. Determine if it's possible to divide it into an odd number of non-empty subsequences, where the length of each subsection is odd and the start and end are odd.

Example

For pain = [1,3,5,7,9], the output should be
oddSequenceConsecutive(pain) = true..
There are five subsection: [1], [3], [5], [7], [9] has odd length and start and end are odd.

For pain= [1 ,2 ,3, 5, 6, 7, 9,10, 11], the output should be
oddSequenceConsecutive(pain) = true.
There are three subsections: [1,2,3] , [5,6,7] , [9,10,11].

For pain = [1,2,3,4,5,6,7,8,9,10], the output should be
oddSequenceConsecutive(pain) = false.

Input/Output

[execution time limit] 4 seconds (rb)

[input] array.integer pain

Guaranteed constraints:
2 ≤ pain.length ≤ 50.

[output] boolean

True if sequence of integers is odd sequence consecutive, else false.
*/

T oddSequenceConsecutive(a) {
   
    a[-1]%2 && a.size%2 && a.count{it%2} > 2
    
  
}
