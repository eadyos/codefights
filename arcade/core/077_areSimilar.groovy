/*
https://codefights.com/arcade/code-arcade/well-of-integration/xYXfzQmnhBvEKJwXP

Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one of the arrays.

Given two arrays a and b, check whether they are similar.

Example

For a = [1, 2, 3] and b = [1, 2, 3], the output should be
areSimilar(a, b) = true.

The arrays are equal, no need to swap any elements.

For a = [1, 2, 3] and b = [2, 1, 3], the output should be
areSimilar(a, b) = true.

We can obtain b from a by swapping 2 and 1 in b.

For a = [1, 2, 2] and b = [2, 1, 1], the output should be
areSimilar(a, b) = false.

Any swap of any two elements either in a or in b won't make a and b equal.

Input/Output

[time limit] 6000ms (groovy)
[input] array.integer a

Array of integers.

Guaranteed constraints:
3 ≤ a.length ≤ 105,
1 ≤ a[i] ≤ 1000.

[input] array.integer b

Array of integers of the same length as a.

Guaranteed constraints:
b.length = a.length,
1 ≤ b[i] ≤ 1000.

[output] boolean

true if a and b are similar, false otherwise.
 */

boolean areSimilar(List<Integer> a, List<Integer> b) {

    def mismatches = []
    (0..<a.size()).each{
        if(a[it] != b[it])
            mismatches << it
    }

    if(mismatches.size() == 0)
        return true

    if(mismatches.size() != 2)
        return false

    def idx1 = mismatches[0]
    def idx2 = mismatches[1]

    [a[idx1],a[idx2]] == [b[idx2], b[idx1]]

}
