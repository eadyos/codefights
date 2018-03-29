/*
https://codefights.com/arcade/code-arcade/list-backwoods/uFQEiM4trARdm2z46

You are implementing a command-line version of the Paint app. Since the command line doesn't support colors, you are using different characters 
to represent pixels. Your current goal is to support rectangle x1 y1 x2 y2 operation, which draws a rectangle that has an upper left corner at 
(x1, y1) and a lower right corner at (x2, y2). Here the x-axis points from left to right, and the y-axis points from top to bottom.

Given the initial canvas state and the array that represents the coordinates of the two corners, return the canvas state after the operation is 
applied. For the details about how rectangles are painted, see the example.

Example

For

canvas = [['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
          ['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
          ['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
          ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'],
          ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b']]
and rectangle = [1, 1, 4, 3], the output should be


drawRectangle(canvas, rectangle) = [['a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'],
                                    ['a', '*', '-', '-', '*', 'a', 'a', 'a'],
                                    ['a', '|', 'a', 'a', '|', 'a', 'a', 'a'],
                                    ['b', '*', '-', '-', '*', 'b', 'b', 'b'],
                                    ['b', 'b', 'b', 'b', 'b', 'b', 'b', 'b']]
Note that rectangle sides are depicted as -s and |s, asterisks (*) stand for its corners and all of the other "pixels" remain the same. 
Color in the example is used only for illustration.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.array.char canvas

A non-empty rectangular matrix of characters.

Guaranteed constraints:
2 ≤ canvas.length ≤ 10,
2 ≤ canvas[0].length ≤ 10.

[input] array.integer rectangle

Array of four integers - [x1, y1, x2, y2].

Guaranteed constraints:
0 ≤ x1 < x2 < canvas[i].length,
0 ≤ y1 < y2 < canvas.length.

[output] array.array.char

*/

List<List<Character>> drawRectangle(List<List<Character>> canvas, List<Integer> r) {
  

    (0..<canvas.size()).collect{row->
        (0..<canvas[0].size()).collect{col->
            def p = [col, row]
            def (c1, r1, c2, r2) = r
            if(p in [[c1,r1], [c1,r2], [c2, r2], [c2,r1]]){
                "*"
            }else if(row in [r1, r2] && col in c1..c2){
                "-"
            }else if(col in [c1,c2] && row in r1..r2){
                "|"
            }else{
                canvas[row][col]
            }
        }
    }
    
    
}
