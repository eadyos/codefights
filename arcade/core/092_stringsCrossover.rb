=begin
https://codefights.com/arcade/code-arcade/spring-of-integration/6QDtjNr3WoL5W4Kvo

Define crossover operation over two equal-length strings A and B as follows:

the result of that operation is a string of the same length as the input strings
result[i] is either A[i] or B[i], chosen at random
Given array of strings inputArray and a string result, find for how many pairs of strings from
inputArray the result of the crossover operation over them may be equal to result.

Note that (A, B) and (B, A) are the same pair. Also note that the pair cannot include the same
element of the array twice (however, if there are two equal elements in the array, they can form a
pair).

Example

For inputArray = ["abc", "aaa", "aba", "bab"] and result = "bbb", the output should be
stringsCrossover(inputArray, result) = 2.

Input/Output

[time limit] 4000ms (rb)
[input] array.string inputArray

A non-empty array of equal-length strings.

Guaranteed constraints:
2 ≤ inputArray.length ≤ 10,
1 ≤ inputArray[i].length ≤ 10.

[input] string result

A string of the same length as each of the inputArray elements.

Guaranteed constraints:
result.length = inputArray[i].length.

[output] integer
=end

def stringsCrossover(inputArray, result)

    inputArray.combination(2).count{|a|
        (0...result.size).all?{|charIndex|
            [a[0].chars[charIndex],
             a[1].chars[charIndex]
            ].include? result[charIndex]
        }
    }

end
