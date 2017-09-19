=begin
https://codefights.com/arcade/intro/level-4/ZCD7NQnED724bJtjN

Given a rectangular matrix of characters, add a border of asterisks(*) to it.

Example

For

picture = ["abc",
           "ded"]
the output should be

addBorder(picture) = ["*****",
                      "*abc*",
                      "*ded*",
                      "*****"]
Input/Output

[time limit] 4000ms (rb)
[input] array.string picture

A non-empty array of non-empty equal-length strings.

Guaranteed constraints:
1 ≤ picture.length ≤ 5,
1 ≤ picture[i].length ≤ 5.

[output] array.string

The same matrix of characters, framed with a border of asterisks of width 1.
=end

def addBorder(picture)

    picture.each{|row|
        row.insert(0,"*")
        row << "*"
    }
    border = "*" * picture[0].size
    picture.insert(0, border)
    picture << border

end

