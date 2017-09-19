=begin
https://codefights.com/challenge/EDCz9GZAnnmqRTBBB

A pile of boxes can be constructed by placing boxes one on top of the other forming a vertical column (it is not possible to place more than one box on top of another one directly). Each box has a strength value - the number of boxes that it can be under without collapsing.

Given some boxes with their strength values, calculate the minimal number of piles that need to be constructed to use up all of these boxes.

Example

For a = [4, 3, 1, 1, 0, 0], the output should be
boxPiles(a) = 2.

It is possible to construct 2 piles: [4, 3, 1, 0] and [1, 0].

Input/Output

[time limit] 6000ms (groovy)
[input] array.integer a

Strength values of boxes, array of non-negative integers.

Guaranteed constraints:
1 ≤ a.length ≤ 250,
0 ≤ a[i] ≤ 109.

[output] integer
=end

def boxPiles a

    t=[]
    a.sort.each{|s|
        t.any?{|v|
            v.size <= s && v << s
        } || t << [s]
    }
    t.size

end