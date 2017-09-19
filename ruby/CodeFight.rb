=begin
https://codefights.com/challenge/okok2rHiWhetqWZfR/solutions/JLgXBMhuJinbCZfzR

Given a positive integer n, output the string representation of all the numbers from 1 to n inclusive while replacing multiples of 5 with Code, multiples of 7 with Fight and multiples of both 5 and 7 with CodeFight.

Example

For n = 15, the output should be

CodeFight(n) =
[
    "1",
    "2",
    "3",
    "4",
    "Code",
    "6",
    "Fight",
    "8",
    "9",
    "Code",
    "11",
    "12",
    "13",
    "Fight",
    "Code"
]
Input/Output

[time limit] 4000ms (rb)
[input] integer n

A positive integer.

Constraints:

1 ≤ n ≤ 100.

[output] array.string

An array of strings.
=end


def CodeFight(n)
  (1..n).collect{|i|
      val = ""
      val += "Code" if i % 5 == 0
      val += "Fight" if i % 7 == 0
      val += i.to_s if val.empty?
      val
   }
end
