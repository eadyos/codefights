=begin
https://codefights.com/challenge/kFDiPpGEvL7jfiEit

This is a reverse challenge, enjoy!

[time limit] 4000ms (rb)
[input] integer inputNumber

A number that should satisfy some hidden rule.

Constraints:
0 ≤ inputNumber ≤ 109.

[output] boolean

true if inputNumber satisfies the hidden rule, false otherwise.

input: 1
output: true

input: 124
output: true

input: 248
output: true

input: 753
output: false

...more at codefights.com...

=end


def NumberRule n

    d = n.to_s.chars
    d == d.sort

end
