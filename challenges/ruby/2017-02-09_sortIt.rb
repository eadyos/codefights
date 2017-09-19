=begin
https://codefights.com/challenge/KBmHkh6b7q68QBiHd

You are given a string, your goal is to rearrange its letters in alphabetical order. If the same letter is present both in lowercase and uppercase forms in the initial string, the uppercase occurrence should go first in the resulting string.

Example

For str = "Vaibhav", the output should be
sortIt(str) = "aabhiVv".

[time limit] 6000ms (groovy)
[input] string str

A string consisting only of letters.

Constraints:
1 ≤ str.length ≤ 20

[output] string
=end


def sortIt s

    s.chars.sort_by{|c| [c.upcase,c]}.join

end
