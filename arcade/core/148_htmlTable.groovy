/*
https://codefights.com/arcade/code-arcade/secret-archives/mnELCFheQvkbcytcz


HTML tables allow web developers to arrange data into rows and columns of cells. They are created using the <table> tag. Its content 
consists of one or more rows denoted by the <tr> tag. Further, the content of each row comprises one or more cells denoted by the <td> 
tag, and content within the <td> tags is what site visitors see in the table. For this task assume that tags have no attributes in 
contrast to real world HTML.

Some tables contain the <th> tag. This tag defines header cells, which shouldn't be counted as regular cells.

You are given a rectangular HTML table. Extract the content of the cell with coordinates (row, column).

If you are not familiar with HTML, check out this note.

Example

For table = "<table><tr><td>1</td><td>TWO</td></tr><tr><td>three</td><td>FoUr4</td></tr></table>", row = 0 and column = 1, the output should be
htmlTable(table, row, column) = "TWO".

<table>
 <tr>
  <td>1</td>
  <td>TWO</td>
 </tr>
 <tr>
  <td>three</td>
  <td>FoUr4</td>
 </tr>
</table>
corresponds to:

1   TWO
three   FoUr4
For table = "<table><tr><td>1</td><td>TWO</td></tr></table>", row = 1 and column = 0, the output should be
htmlTable(table, row, column) = "No such cell".

<table>
 <tr>
  <td>1</td>
  <td>TWO</td>
 </tr>
</table>
corresponds to:

1   TWO
Input/Output

[execution time limit] 6 seconds (groovy)

[input] string table

A syntactically correct representation of a rectangular HTML table with at least one cell. Each of its cells contains only letters and/or digits.

Guaranteed constraints:
35 ≤ table.length ≤ 1600.

[input] integer row

A non-negative integer representing 0-based index of the desired row (rows are numbered from top to bottom).

Guaranteed constraints:
0 ≤ row ≤ 10.

[input] integer column

A non-negative integer representing 0-based index of the desired column (columns are numbered from left to right).

Guaranteed constraints:
0 ≤ column ≤ 10.

[output] string

The content of the cell with coordinates (row, column) or the string "No such cell" if there is no cell with those coordinates in the table.
*/

String htmlTable(String table, int row, int column) {
    
    java.util.regex.Matcher.metaClass.getIt = {
        it < delegate.size() ? delegate[it] : null
    }
    def rows = table =~ /(<tr>(.*?)<\/tr>)/
    def r = rows.getIt(row)?.getAt(2)
    def cells = r =~ /(<td>(.*?)<\/td>)/
    cells?.getIt(column)?.getAt(2) ?: "No such cell"
}
