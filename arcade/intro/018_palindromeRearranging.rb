=begin
https://codefights.com/arcade/intro/level-4/Xfeo7r9SBSpo3Wico
Given a string, find out if its characters can be rearranged to form a palindrome.

Example

For inputString = "aabb", the output should be
palindromeRearranging(inputString) = true.

We can rearrange "aabb" to make "abba", which is a palindrome.

Input/Output

[time limit] 4000ms (rb)
[input] string inputString

A string consisting of lowercase English letters.

Guaranteed constraints:
1 ≤ inputString.length ≤ 50.

[output] boolean

true if the characters of the inputString can be rearranged to form a palindrome, false otherwise.
=end

def palindromeRearranging(inputString)

    sorted = inputString.chars.sort
    middleFreebie = false
    if(sorted.size % 2 == 1)
        middleFreebie = true
    end
    (0...sorted.size).all? {|idx|
        if idx % 2 == 0 || sorted[idx] == sorted[idx-1]
            true
        elsif middleFreebie
            middleFreebie = false
            last = sorted.last
            if(sorted[idx] == last || sorted[idx-1] == last)
               true
            else
               false
            end
        else
            false
        end
    }

end
