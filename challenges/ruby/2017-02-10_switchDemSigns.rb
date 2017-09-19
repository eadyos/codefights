=begin
https://codefights.com/challenge/CHajJHHfGYuGKMW7D/solutions

Given a string that represents a linear algebraic expression, invert each plus or minus sign that is outside of any brackets in the expression.

Note that:

There can be three types of brackets in the expression: round (around me), curly {around me} or square [around me].
The expression will only contain plus and minus signs. There will not be any multiplication or division signs.
The only operands in the expression are variables, so the expression will not contain any numbers.
Each variable can be represented by an arbitrary number of consecutive characters.
The first variable in the input might not have a sign in front of it. In this case, the sign is assumed to be a plus sign.
In the output, there should be a sign in front of each variable, including the first one.
Brackets can form nested constructions of any depth. Brackets of a certain type can contain brackets of the same type inside (e.g. (...(...)...)). In addition, the order of nesting is not fixed (so both (...{...}...) and {...(...)...} are equally possible).
Example:

For linEq = "a + b - (c + d - {e})", the output should be
switchDemSigns(linEq) = "- a - b + (c + d - {e})".

Explanation:

a is outside all of the expression's brackets and does not have a sign in front of it, so it is considered positive in the input. Inverting the sign produces - a in the output.
b is also outside all of the brackets and has a plus sign in front of it, so it should be changed to - b in the output.
The sign right before (c + d - {e}) is negative, so we should put a plus sign there in the output.
All the other signs are inside the brackets, so they remain untouched.
[time limit] 6000ms (groovy)
[input] string linEq

Constraints:
linEq.length ≤ 150

[output] string

=end


def switchDemSigns p

    a = []
    s = 0
    b = nil

    p.chars.each_with_index{|c, i|
        if i == 0 && c != "-"
            a << "- "
        end

        if c == "(" and b == nil
            b = "("
            s += 1
        elsif c == "(" and b == "("
            s += 1
        end
        if c == "{" and b == nil
            b = "{"
            s += 1
            puts "found it and nil #{c} #{s}"
        elsif c == "{" and b == "{"
            s += 1
            puts "found it #{c} #{s}"
        end
        if c == "[" and b == nil
            b = "["
            s += 1
        elsif c == "[" and b == "["
            s += 1
        end
        if c == ")"
            if b == "("
                s -= 1
                if s == 0
                    b = nil
                end
            end
        end
        if c == "}"
            if b == "{"
                s -= 1
                if s == 0
                    b = nil
                end
            end
        end
        if c == "]"
            if b == "["
                s -= 1
                if s == 0
                    b = nil
                end
            end
        end
        if s == 0
            if c == "+"
                a << "-"
            elsif c == "-"
                a << "+"
            else
                a << c
            end
        else
            a << c
        end
    }
    a.join

end
