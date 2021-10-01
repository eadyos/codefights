=begin
https://codefights.com/challenge/v5Zg8trjoun3PTxrZ/solutions/LRxji22tf3vBnKtqT

This problem can be solved by pre-school children in 5-10 minutes. By programmers in one hour. 
By people with a higher education… Well, it certainly can take them a while.

Since you, CodeFighters, are supposed to be programmers, it shouldn't take you that long to solve it :) 
Take a look at the test cases and figure what this is all about.

Beware the corner cases!

[time limit] 4000ms (rb)
[input] integer n

Constraints:

0 ≤ n ≤ 230

[output] integer

=end


#To solve this problem, we need to count the number of "circles" in the input numbers
#0 contains 1 cirlcle, 8 contains 2 circles, etc.

def countIt(n)

    vals = {0=>1, 1=>0, 2=>0, 3=>0, 4=>0, 5=>0,
        6=>1, 7=>0, 8=>2, 9=>1}

    n.to_s.chars.map(&:to_i).collect{|v| vals[v]}.inject(0){|x, sum| x + sum }

end
