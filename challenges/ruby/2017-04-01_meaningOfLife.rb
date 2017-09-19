=begin
https://codefights.com/challenge/iuePposGo5AYBn8w9


This is a reverse challenge, enjoy!

Input/Output

[time limit] 4000ms (rb)
[input] string n

A string of alphanumeric characters.

Guaranteed constraints:
1 ≤ n.length ≤ 9.

[output] integer64

The answer is guaranteed to be less than 251.

input "1"
output 1

input "C"
output 12

input "c"
output 38

input "1A"
output 52

input "100"
output 1764

...more tests at codefights.com...

=end

def meaningOfLife(n)
    vals = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdef"
    t = 0
    n.to_s.chars.reverse.each_with_index do |v, i|
        t += vals.index(v) * (42 ** i)
    end
    return t
end
