/*
https://codefights.com/challenge/Z2ZgyaQtu96WDH6Pn


Given a list of strings g and an integer z, sort the strings by the zth 1-based character ignoring the characters' case.

In case of a tie, the first element that appears in g should go first.

Example

For g = ["Cow", "Chicken", "Deer", "Rabbit"] and z = 3,
the output should be
sortByZ(g, z) = ["Rabbit", "Deer", "Chicken", "Cow"].

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.string g

A list of strings.

Guaranteed constraints:
3 ≤ g.length ≤ 50,
2 ≤ g[i].length < 40.

[input] integer z

Sort the list based on the zth character.

Guaranteed constraints:
 1 ≤ z ≤ length of the shortest string in g.

[output] array.string

The sorted list.

*/

T SortByZ(g,z) {
  
    g.sort{
        9 & (int)it[z-1]       
    }

}
