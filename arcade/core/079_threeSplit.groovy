/*
https://codefights.com/arcade/code-arcade/well-of-integration/QmK8kHTyKqh8xDoZk

You have a long strip of paper with integers written on it in a single line from left to right. You wish to cut the paper
into exactly three pieces such that each piece contains at least one integer and the sum of the integers in each piece is
the same. You cannot cut through a number, i.e. each initial number will unambiguously belong to one of the pieces after cutting.
How many ways can you do it?

It is guaranteed that the sum of all elements in the array is divisible by 3.

Example

For a = [0, -1, 0, -1, 0, -1], the output should be
threeSplit(a) = 4.

Here are all possible ways:

[0, -1] [0, -1] [0, -1]
[0, -1] [0, -1, 0] [-1]
[0, -1, 0] [-1, 0] [-1]
[0, -1, 0] [-1] [0, -1]
Input/Output

[time limit] 6000ms (groovy)
[input] array.integer a

Guaranteed constraints:
5 ≤ a.length ≤ 104,
-108 ≤ a[i] ≤ 108.

[output] integer

It's guaranteed that for the given test cases the answer always fits signed 32-bit integer type.
 */

int threeSplit(List<Integer> a) {

    def count = 0
    int partSum = a.sum() / 3
    def leftSum = 0
    (0..(a.size() - 3)).each{i->
        leftSum += a[i]
        if(leftSum == partSum){
            def midSum = 0
            ((i+1)..(a.size() - 2)).each{j->
                midSum += a[j]
                if(midSum == partSum){
                    count++
                }
            }
        }
    }
    count

}
