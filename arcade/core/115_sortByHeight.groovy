/*
https://codefights.com/arcade/code-arcade/sorting-outpost/D6qmdBL2NYz49XHwM

Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to rearrange the people 
by their heights in a non-descending order without moving the trees.

Example

For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.integer a

If a[i] = -1, then the ith position is occupied by a tree. Otherwise a[i] is the height of a person standing in the ith position.

Guaranteed constraints:
5 ≤ a.length ≤ 15,
-1 ≤ a[i] ≤ 200.

[output] array.integer

Sorted array a with all the trees untouched.
*/

List<Integer> sortByHeight(List<Integer> a) {

    def people = a.findAll{it >= 0}.sort()
    (0..<a.size()).each{
        a[it] = a[it] == -1 ? -1 : people.remove(0)
    }
    a

}
