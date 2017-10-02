=begin
https://codefights.com/arcade/code-arcade/spring-of-integration/tKwbrKAQhoCZFqg33

You're given a substring s of some cyclic string. What's the length of the smallest possible
string that can be concatenated to itself many times to obtain this cyclic string?

Example

For s = "cabca", the output should be
cyclicString(s) = 3.

"cabca" is a substring of a cycle string "abcabcabcabc..." that can be obtained by
concatenating "abc" to itself. Thus, the answer is 3.

Input/Output

[time limit] 6000ms (groovy)
[input] string s

Guaranteed constraints:
3 ≤ s.length ≤ 15.

[output] integer
=end

def cyclicString(s)

    count = nil
    for i in 0...s.size
       sub = s[0..i]
       while sub.size < s.size
           sub += sub
       end
       if sub.start_with? s
           count = i + 1
           break
       end
    end
    count

end
