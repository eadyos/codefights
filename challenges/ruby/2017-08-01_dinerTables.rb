=begin
https://codefights.com/challenge/hiZCrg5MS7mQ3Wy8h

Your favorite restaurant can take reservations for n people. They have an interesting algorithm to determine how many tables they will need to set up based on these reservations. They take the number of people who have reservations, and then dividing it by ever incrementing integers. They start at 1, because they always need to have at least 1 table set up. They do this until the number of tables is greater than n. So your task is to find out how many times n will be divided until they determine the number of tables they need to set up.

Example
For n = 100, the output should be
dinerTables(n) = 5.

Walk-through:

[100, 1] < We start with 1 table for 100 people (100 / 1);
[100, 2] < 100 people / 2 tables = 50 people per table;
[50, 3] < 50 people / 3 tables = 16 people per table;
[16, 4] < 16 people / 4 tables = 4 people per table;
[4, 5] < 4 people / 5 tables = done.
Since n was divided 5 times before the number of tables was greater than the number of people, the answer is 5.
[time limit] 6000ms (groovy)
[input] integer64 n

The number of people who made reservations.

Guaranteed constrains:
0 ≤ n ≤ 253 - 1.

[output] integer

The number of times that n will be divided by incrementing integers before the number of tables becomes greater than the number of people.
=end


def dinerTables n

    c=1
    while n >= c
        n /= c
        c = c + 1
    end
    c

end
