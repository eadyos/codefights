=begin
https://codefights.com/arcade/intro/level-3/3o6QFqgYSontKsyk4

You have a string s that consists of English letters, punctuation marks, whitespace characters, and brackets. It is guaranteed that the parentheses in s form a regular bracket sequence.

Your task is to reverse the strings contained in each pair of matching parentheses, starting from the innermost pair. The results string should not contain any parentheses.

Example

For string s = "a(bc)de", the output should be
reverseParentheses(s) = "acbde".

Input/Output

[time limit] 4000ms (rb)
[input] string s

A string consisting of English letters, punctuation marks, whitespace characters and brackets. It is guaranteed that parentheses form a regular bracket sequence.

Constraints:
5 ≤ s.length ≤ 55.

[output] string
=end

def reverseParentheses(s)
    result = []
    stacks = []
    s.chars.each{|c|
        if(c == '(')
            stacks << []
        elsif(c == ')')
            stack = stacks.pop
            while(!stack.empty?)
               if(stacks.empty?)
                   result << stack.pop
               else
                   stacks.last.push stack.pop
               end
            end
        else
            if(stacks.empty?)
                result << c
            else
                stacks.last.push c
            end
        end
    }
    result.join
end
