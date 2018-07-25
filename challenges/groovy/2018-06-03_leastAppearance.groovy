/*
https://app.codesignal.com/challenge/vvaEwn4NbpLYGMt5G

We'd like to construct a diverse array of numbers. At each step, we'll be given two choices for the next number we can add, and we'd like to select the number that appears least frequently in our array so far. If both numbers appear with equal frequency, we'll choose the smaller one.

Our choices will be given in the form of an array, choices, consisting of 2-element arrays of integers.

Example

For choices = [[1, 2], [3, 4], [1, 2]], the output should be leastAppearance(choices) = [1, 3, 2].

Initially, our array is empty, so given the choice between 1 and 2, we'll pick 1 since it's smaller.

On the next step, our array looks like [1], which doesn't contain 3 or 4, so we'll pick 3 (again, because it's smaller than 4).

On the final step, our array looks like [1, 3], so we'll pick 2 since the array already contains a 1.

Input / Output

[execution time limit] 6 seconds (groovy)

[input] array.array.integer choices

An array containing sorted 2-element arrays of integers. Each 2-element array represents the two choices for the next number to add to our array of results.

Guaranteed constraints
0 ≤ choices.length ≤ 105
choices[i].length = 2
choices[i][0] ≤ choices[i][1]
1 ≤ choices[i][j] ≤ 100

[output] array.integer

An array of numbers where each number appears as infrequently as possible up to the index at which it was selected.

*/

T leastAppearance(a) {
    
    T c = [:]
    a.collect{
        c[a = it.min{c[it]}] += "	"
        a
    }
    
  
}
