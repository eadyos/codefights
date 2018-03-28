/*
https://codefights.com/challenge/aazQK7ogdnca6ygaa

You accidentally lost some lines from your code, and now you are curious what the average of the lost line's numbers is. 
You have the table lines, which contains only one column:

line_number - the unique number of a remaining line.
Your goal is to find the average of the missing line numbers from 1 to the maximal number of the remaining lines. 
Return it as a single value in the only column of the output table, average, with only 5 numbers after the decimal point.

Example

For given table lines

line_number
2
5
10
the output should be

average
5.42857
The numbers of the missing lines are: 1, 3, 4, 6, 7, 8, and 9. The average of these numbers is 5.42857142.... 
Returning only 5 digits after the decimal point gives us the answer, 5.42857.

[execution time limit] 10 seconds (mysql)

*/

CREATE PROCEDURE lostLines()
BEGIN

SET @l = `lines`;
SET @m = (select max(line_number) from `lines`);

select round(coalesce((((@m * (@m + 1)) / 2 - (select sum(line_number) from `lines`)) / (@m - (select count(*) from `lines`))),0), 5) as average;


END