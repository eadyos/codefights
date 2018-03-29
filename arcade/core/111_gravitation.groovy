/*
https://codefights.com/arcade/code-arcade/waterfall-of-integration/hqrYesGKEaKQnv7Sv


You are given a vertical box divided into equal columns. Someone dropped several stones from its top through the columns. 
Stones are falling straight down at a constant speed (equal for all stones) while possible (i.e. while they haven't reached 
the ground or they are not blocked by another motionless stone). Given the state of the box at some moment in time, find out 
which columns become motionless first.

Example

For

rows = ["#..##",
        ".##.#",
        ".#.##",
        "....."]
the output should be gravitation(rows) = [1, 4].

Check out the image below for better understanding:



Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.string rows

A non-empty array of strings of equal length consisting only of #-s and .-s describing the box at a specific moment in time. Sharps 
represent stones, and dots represent empty cells. row[0] corresponds to the upper row. Last element of rows corresponds to the ground level.

Guaranteed constraints:
2 ≤ rows.length ≤ 10,
2 ≤ rows[i].length ≤ 10.

[output] array.integer

A sorted array containing numbers of all columns (leftmost column's number is 0) in which movements will stop at the same second and 
earlier than in any other column. Assume that if there are no stones in a column then movement stops immediately, i.e. after 0 seconds.

*/

def gravitation(List<String> rows) {
  
    def counts = (0..<rows[0].size()).collect{i->
        def col = rows.collect{it[i]}
        (0..<col.size()).count{
            def s = col.indexOf("#")
            col[it] == "." && it > (s >= 0 ? s : rows.size())
        }
    }
    counts.findIndexValues{
        it == counts.min()
    }
}