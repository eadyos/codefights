/*
https://codefights.com/challenge/c95Zq4kqFi84BTwFT

Bob is trying to keep track of his credit card balance, and he would like to know how many days he is into the billing cycle in order to gauge his spending. Given the current date and the day of the month on which the billing cycle ends (the "cycle day"), calculate the number of days he is into his credit cycle.

Day 1 is the day of the month after the cycle day. The cycle day is the last day of the cycle.

Example
For month = 8, day = 26, year = 2017 and cycleDay = 20, the output should be
creditCycle(month, day, year, cycleDay) = 6.

For August 26, 2017 and a cycle date of the 20th of the month, Bob is 6 days into the cycle. Day 1 is August 21, so the 26th is day 6.

Input/Output

[time limit] 6000ms (groovy)
[input] integer month

The number of current month (1-based, so 1 stands for January, 2 for February and so on).

Guaranteed constraints:
1 ≤ month ≤ 12.

[input] integer day

The current day of the month. It's guaranteed that given day is valid for the current month and year.

Guaranteed constraints:
1 ≤ day ≤ 31.

[input] integer year

The current year.

Guaranteed constraints:
2000 ≤ year ≤ 2050.

[input] integer cycleDay

Day of the month the current credit cycle ends.

Guaranteed constraints:
1 ≤ cycleDay ≤ 28.

[output] integer

The number of days that have elapsed in the current cycle, including the current date.
 */

T creditCycle(m,d,y,c,o={j->new Date(y-1900,--m,j)}) {

    c < d ? d - c : o(d) - o(c)
}