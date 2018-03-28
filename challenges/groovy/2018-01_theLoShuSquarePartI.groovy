/*
https://codefights.com/challenge/2wT8P8ghQqtzt9DHa

Lo Shu Square is part of the legacy of the most ancient Chinese mathematical and divinatory (Yi Jing 易經) traditions, 
and is an important emblem in Feng Shui (風水).
The original form of the Lo Shu square is one of the 3 × 3 magic square where each row, each column and both diagonal are 
all equal to 15.
Here is the original form (year 2013) of Lo Shu Square in matrix representation:

[[4, 9, 2],
 [3, 5, 7],
 [8, 1, 6]]
So, for each year, numbers will shift one position accordingly, here is the result for the next year(2014):

[[3, 8, 1],
 [2, 4, 6],
 [7, 9, 5]]
Here is result for the previous year(2012):

[[5, 1, 3],
 [4, 6, 8],
 [9, 2, 7]]
Now is the task, write the program which can generate the matrix for a particular year.
Hopefully you guys like it and welcome to ask question if the example is not clear enough.

Example
For year = 2013, the output should be

theLoShuSquarePartI(year) =
[[4, 9, 2], 
 [3, 5, 7], 
 [8, 1, 6]]
Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer year

Find the result for the particular year.

Guaranteed constraints:
1949 < year < 2051.

[output] array.array.integer

A 3 × 3 matrix as the example shown.

*/

T theLoShuSquarePartI(y) {
    
    "168924573".collect{
        (y+ it as int)%9+1
    }collate 3
    
}
