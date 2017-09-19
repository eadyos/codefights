=begin
https://codefights.com/challenge/SR6zZZEzfEwpyCC8f

Christmas is over, which means that production of next year’s toys has already begun. To make all these toys, the elves need raw materials. These raw materials arrive to the North Pole in constant streams during the month of January. Nowadays North Pole is known for its amazingly fast production system, and well developed urban infrastructure, but the route used to deliver raw materials is very obsolete. They are developing better traffic technology, but up until now, the raw materials traffic has been controlled by one traffic elf and his countdown watch.

The traffic elf has a watch that continually counts down, and when the watch gets to zero, the elf stops traffic from one way and starts the flow of traffic from the other way. The watch has two seven segment numbers, and starts at a number and will countdown to zero. This elf has had this watch for over 120 years, so it came to no surprise when the watch started acting weird, and the top half of each seven segment number disappeared. Now that the watch shows only the bottom three segments, it’s hard for the elf to direct traffic, but it’s a good thing Santa’s elves are magical and have high functioning brains that allow for actual multitasking. The elf wants to know what time the countdown starts at, so he can figure out when he should change traffic without having to stare directly at his watch.

Here's what a seven segment display of digit 8 used to look like vs how it looks now:

Seven Segment Display Broken Seven Segment Display

The numbers used in this challenge are in the following format:


You are given an array of strings with two digit seven segment numbers in descending order. The first string in the array represents the time when the timer started, and each of the following strings represent the number that goes after the previous during a countdown. The array does not necessarily contain all the numbers from the n to 0.

Your task is to return the first number in the countdown sequence. Obviously, it's not always possible to determine the answer, so if there are several possible starting numbers you should return them all in descending order.

Example

For countdown=["****_|","*****|","****_|","***|_*","*****|","***|_|"],
the output should be
northPoleTrafficClock(countdown) = [5].

Here's the sequence the given array represents:
Example 1 Explanation

For countdown=["**|**|","**||_|","**|**|"],
the output should be
northPoleTrafficClock(countdown) = [99, 79, 49, 19].

Input/Output

[time limit] 4000ms (rb)
[input] array.string countdown

An array of strings representing pairs of seven segment numbers. Each digit is given as in the format edc, where letters stand for segments. Active segments a and c are denoted by |, and active segment d is denoted by _.
A disabled segment is denoted by *.

For example, number 88 will be formatted “|_||_|”, and number 19 will be given as “**|*_|”.

Constraints:
1 ≤ countdown[i].length ≤ 99,
countdown[i].length = 6,
0 ≤ number(countdown[i]) ≤ 99,
number(countdown[i]) = number(countdown[i+1]) + 1.

[output] array.integer

An array of possible starting points of the countdown in descending order.

It is guaranteed that the given countdown is valid, i.e. the output will contain at least one element.

=end

#See codefights.com link for description images


def c v1, v2, o
    m = false
    d = []
    (0...v2.size).each{ |j|
        if !v1.include? v2[j] + o
            d << v2[j]
            m = true
        end
    }
    for x in d
        v2.delete x
    end
    m
end

def northPoleTrafficClock i

    m = {"|_|": "068",
         "**|": "1479",
         "|_*": "2",
         "*_|": "35",
         "***": "0"}

    p = []

    for s in i
        c1 = s[0..2]
        c2 = s[3..6]
        d1 = m[c1.to_sym].chars
        d2 = m[c2.to_sym].chars
        a = []
        for n1 in d1
            n1 = n1.to_i * 10
            for n2 in d2
                n2 = n2.to_i
                a << n1 + n2
            end
        end
        p << a
    end

    begin
        m = false
        (0...p.size).each{ |i|
            y = p[i]
            z = p[i+1]
            if z
                m = c(y, z, 1) || m
                m = c(z, y, -1) || m
            end
        }
    end while m

    p[0].sort.reverse

end

