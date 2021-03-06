/*
https://codefights.com/arcade/code-arcade/well-of-integration/fzsCQGYbxaEcTr2bL

Given an array of strings, return another array containing all of its longest strings.

Example

For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
allLongestStrings(inputArray) = ["aba", "vcd", "aba"].

Input/Output

[time limit] 6000ms (groovy)
[input] array.string inputArray

A non-empty array.

Guaranteed constraints:
1 ≤ inputArray.length ≤ 10,
1 ≤ inputArray[i].length ≤ 10.

[output] array.string

Array of the longest strings, stored in the same order as in the inputArray.
 */

List<String> allLongestStrings(List<String> a) {

    a.findAll{it.size() == a.max{it.size()}.size()}
}
