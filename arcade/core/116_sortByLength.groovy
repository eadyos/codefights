/*
https://codefights.com/arcade/code-arcade/sorting-outpost/QQB7f8ouAqY6jf7xi

Given an array of strings, sort them in the order of increasing lengths. If two strings have the same length, their 
relative order must be the same as in the initial array.

Example

For

inputArray = ["abc",
              "",
              "aaa",
              "a",
              "zz"]
the output should be

sortByLength(inputArray) = ["",
                            "a",
                            "zz",
                            "abc",
                            "aaa"]
Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.string inputArray

A non-empty array of strings.

Guaranteed constraints:
3 ≤ inputArray.length ≤ 10,
0 ≤ inputArray[i].length ≤ 10.

[output] array.string
*/

List<String> sortByLength(List<String> a) {
  
    a.sort{it.size()}
}
