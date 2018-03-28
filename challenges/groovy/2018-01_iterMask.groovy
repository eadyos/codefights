/*
https://codefights.com/challenge/u9YFDa2WYbbCqWSzv

I am planning an upcoming challenge. But as is common, I am breaking it into little parts first. So this will be a series, 
instead of releasing the full challenge at once. I will release the full challenge after all these! So look forward to it!

The first thing to do is to check that an array,arr, is of pairwise relatively prime integers.

Given an array, arr , check if it is in its entirety relatively prime.

Example

For arr = [2, 3, 11], the output should be
breakDown1(arr) = true;
For arr = [2, 4, 5], the output should be
breakDown1(arr) = false.
CHEATING WILL ONLY HURT YOU LATER

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.integer arr

An array of integers.

Guaranteed constraints:
arr.length = 3,
2 ≤ arr[i] < 3 · 105.

[output] boolean

Return true if the sequence consists of relatively prime numbers, else return false.

*/

T breakDown1(s) {

    s.every{a->
        !(s-a).any{(it+0g).gcd(a) > 1}
    }
    
    
    
}