/*
https://codefights.com/arcade/intro/level-7/PTWhv2oWqd6p4AHB9

Given an array of equal-length strings, check if it is possible to rearrange the strings in such a way that after the rearrangement the strings at consecutive positions would differ by exactly one character.

Example

For inputArray = ["aba", "bbb", "bab"], the output should be
stringsRearrangement(inputArray) = false;

All rearrangements don't satisfy the description condition.

For inputArray = ["ab", "bb", "aa"], the output should be
stringsRearrangement(inputArray) = true.

Strings can be rearranged in the following way: "aa", "ab", "bb".
Input/Output

[time limit] 6000ms (groovy)
[input] array.string inputArray

A non-empty array of strings of lowercase letters.

Guaranteed constraints:
2 ≤ inputArray.length ≤ 10,
1 ≤ inputArray[i].length ≤ 15.

[output] boolean
 */

boolean stringsRearrangement(List<String> inputArray) {

    def result = [inputArray.first()]
    def addedElements = [inputArray.first()]
    while(!addedElements.isEmpty()){
        addedElements.each{
            inputArray.removeElement(it)
        }
        addedElements.clear()
        inputArray.each{
            if(diffCount(result.first(), it) == 1){
                result.add(0,it)
                addedElements << it
            }else if(diffCount(result.last(), it) == 1){
                result << it
                addedElements << it
            }
        }
    }
    return inputArray.isEmpty()
}

def diffCount(String a, String b){
    (0..<a.size()).sum{
        a[it] != b[it] ? 1 : 0
    }
}

//I don't love this solution
//More elegance needed

