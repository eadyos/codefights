=begin
You have a binary tree t. Your task is to find the largest value in each row of this tree. In a
tree, a row is a set of nodes that have equal depth. For example, a row with depth 0 is a tree root,
a row with depth 1 is composed of the root's children, etc.

Return an array in which the first element is the largest value in the row with depth 0, the
second element is the largest value in the row with depth 1, the third element is the largest
element in the row with depth 2, etc.

Example

For

t = {
    "value": -1,
    "left": {
        "value": 5,
        "left": null,
        "right": null
    },
    "right": {
        "value": 7,
        "left": null,
        "right": {
            "value": 1,
            "left": null,
            "right": null
        }
    }
}
the output should be largestValuesInTreeRows(t) = [-1, 7, 1].

The tree in the example looks like this:

    -1
   / \
  5   7
       \
        1
In the row with depth 0, there is only one vertex - the root with value -1;
In the row with depth 1, there are two vertices with values 5 and 7, so the largest value
here is 7;
In the row with depth 2, there is only one vertex with value 1.
Input/Output

[time limit] 4000ms (rb)
[input] tree.integer t

A binary tree of integers.

Guaranteed constraints:
0 ≤ tree size ≤ 5 · 104,
-1000 ≤ node value ≤ 1000.

[output] array.integer

An array of the largest values in each row of t.
=end

#
# Definition for binary tree:
# class Tree
#   attr_accessor :value, :left, :right
#   def initialize(val)
#     @value = val
#     @left = nil
#     @right = nil
# end
def largestValuesInTreeRows(t)

    maxValues = {}
    nodes = []
    if t
        nodes << [t, 0]
    end
    while !nodes.empty?
        a = nodes.pop
        node = a[0]
        depth = a[1]
        if !maxValues[depth] || node.value > maxValues[depth]
            maxValues[depth] = node.value
        end
        if node.left
            nodes.unshift [node.left, depth + 1]
        end
        if node.right
            nodes.unshift [node.right, depth + 1]
        end
    end
    maxValues.values

end
