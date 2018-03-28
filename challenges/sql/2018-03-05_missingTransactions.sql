/*
https://codefights.com/challenge/Zci5fnMJeozEnE5KX

You have the table missingTransactions, which describes seats on an airplane. It has the following columns:

id - The ID of the transaction;
amount - The transaction amount;
name - The name of the person who made this transaction.
This table stores all your incoming transactions. But after careful examination you've noticed that some transactions are missing!

You know that the first transaction has its id set to 0, the second one has id = 1, and so on. Basically, all transactions form a continuous 
integer sequence from 0 to the maximum id. Now you want to find the missing transactions.

Your task is to return the ids of the missing transactions, sorted in ascending order.

Example

For the given table transactions

id  amount  name
0   1000    Farah Dahlquist
1   -500    Jacque Fuhr
2   489 Hisako Shuster
5   333 Oliva Mcgarry
6   100 Allen Reger
8   -1  Jacque Fuhr
9   -999    Leonia Maultsby
10  1500    Oliva Mcgarry
15  0   Hisako Shuster
the output should be

id
3
4
7
11
12
13
14
[execution time limit] 10 seconds (mysql)

[output] undefined


*/

/*Please add ; after each select statement*/
CREATE PROCEDURE missingTransactions()
BEGIN

CREATE OR REPLACE VIEW g16
AS SELECT 0 n UNION  SELECT 1  UNION  SELECT 2  UNION  
   SELECT 3   UNION  SELECT 4  UNION  SELECT 5  UNION 
   SELECT 6   UNION  SELECT 7  UNION  SELECT 8  UNION 
   SELECT 9   UNION  SELECT 10 UNION  SELECT 11 UNION 
   SELECT 12  UNION  SELECT 13 UNION  SELECT 14 UNION  
   SELECT 15;

CREATE OR REPLACE VIEW g256
AS SELECT ( ( hi.n << 4 ) | lo.n ) AS n
     FROM g16 lo, g16 hi;

select t.n as id from (

SELECT ( ( hi.n << 8 ) | lo.n ) AS n
     FROM g256 lo, g256 hi
     
) as t
where n not in (
     select id from transactions
) and n <= (select max(id) from transactions);


END