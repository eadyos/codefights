=begin
https://codefights.com/arcade/intro/level-5/ZMR5n7vJbexnLrgaM

In the popular Minesweeper game you have a board with some mines and those cells that don't contain a mine have a number in it that indicates the total number of mines in the neighboring cells. Starting off with some arrangement of mines we want to create a Minesweeper game setup.

Example

For

matrix = [[true, false, false],
          [false, true, false],
          [false, false, false]]
the output should be

minesweeper(matrix) = [[1, 2, 1],
                       [2, 1, 1],
                       [1, 1, 1]]
Check out the image below for better understanding:
(see link for image)


Input/Output

[time limit] 4000ms (rb)
[input] array.array.boolean matrix

A non-empty rectangular matrix consisting of boolean values - true if the corresponding cell contains a mine, false otherwise.

Guaranteed constraints:
2 ≤ matrix.length ≤ 5,
2 ≤ matrix[0].length ≤ 5.

[output] array.array.integer

Rectangular matrix of the same size as matrix each cell of which contains an integer equal to the number of mines in the neighboring cells. Two cells are called neighboring if they share at least one corner.
=end

def minesweeper(matrix)

    result = []
    height = matrix.size
    width = matrix[0].size
    for i in 0...height
        row = []
        for j in 0...width
            sum = 0
            for a in -1..1
                for b in -1..1
                   if(!(a == 0 && b == 0))
                       ia = i + a
                       jb = j + b
                       sum += 1 if ia >=0 && jb >= 0 && ia < height &&
                           jb < width && matrix[ia][jb]
                   end
                end
            end
            row << sum
        end
        result << row
    end
    result
end

