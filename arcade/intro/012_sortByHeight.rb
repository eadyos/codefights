=begin
https://codefights.com/arcade/intro/level-3/D6qmdBL2NYz49XHwM

Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to rearrange the people by their heights in a non-descending order without moving the trees.

Example

For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].

Input/Output

[time limit] 4000ms (rb)
[input] array.integer a

If a[i] = -1, then the ith position is occupied by a tree. Otherwise a[i] is the height of a person standing in the ith position.

Guaranteed constraints:
5 ≤ a.length ≤ 15,
-1 ≤ a[i] ≤ 200.

[output] array.integer

Sorted array a with all the trees untouched.
=end

def sortByHeight(a)

    people = a.select{|n| n >= 0}.sort
    (0...a.size).each{|i|
        a[i] = a[i] == -1 ? -1 : people.shift
    }
    a

end
