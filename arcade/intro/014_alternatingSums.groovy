/*
https://codefights.com/arcade/intro/level-4/cC5QuL9fqvZjXJsW9

Several people are standing in a row and need to be divided into two teams. The first person goes into team 1, the second goes into team 2, the third goes into team 1 again, the fourth into team 2, and so on.

You are given an array of positive integers - the weights of the people. Return an array of two integers, where the first element is the total weight of team 1, and the second element is the total weight of team 2 after the division is complete.

Example

For a = [50, 60, 60, 45, 70], the output should be
alternatingSums(a) = [180, 105].

Input/Output

[time limit] 6000ms (groovy)
[input] array.integer a

Guaranteed constraints:
1 ≤ a.length ≤ 10,
45 ≤ a[i] ≤ 100.

[output] array.integer
 */

List<Integer> alternatingSums(List<Integer> a) {

    def s1 = 0
    def s2 = 0
    (0..<a.size()).each{idx->
        if (idx%2 == 0)
            s1+=a[idx]
        if (idx%2 != 0)
            s2+=a[idx]
    }
    [s1,s2]
}
