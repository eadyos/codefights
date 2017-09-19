=begin
https://codefights.com/challenge/J9tdW6Fo7FiHmsqk4

Conway's Game of Life is a zero-player game that simulates a population of growing cells. Every cell interacts with its neighbors, which are the cells that are vertically, horizontally, or diagonally adjacent. At each step in time, the following changes take place:

Any live cell with fewer than two live neighbors dies (to simulate underpopulation);
Any live cell with two or three live neighbors lives on to the next generation;
Any live cell with more than three live neighbors dies (to simulate overpopulation);
Any dead cell with exactly three live neighbors becomes a live cell (to simulate reproduction).
In this challenge, the initial population is represented as a matrix of integers, seed, where 0 indicates a dead cell and 1 indicates a live cell. Your task here is to find the next population's pattern after one step in time.

Example:
For

seed = [[0, 1, 0],
        [0, 1, 0],
        [0, 1, 0]]
the output should be:

nextGameOfLife(seed) =
[[0, 0, 0],
 [1, 1, 1],
 [0, 0, 0]]
Visualisation: (credit to Wikipedia)


Input/Output

[time limit] 4000ms (rb)
[input] array.array.integer seed

seed only contains arrays of 1's and 0's.

Guaranteed constraints:
1≤ seed.length ≤ 100,
1≤ seed[i].length ≤ 100,
All seed[i].length are guaranteed to be the same, no matter what i is.

[output] array.array.integer

Return what seed looks like after one step in time.
=end

def nextGameOfLife(seed)

   result = []

   for r in 0...seed.length
      result << []
       for c in 0...seed[r].length
           count = countLiveNeighbors(seed,r,c)
           #if life
           if(seed[r][c] == 1)
              if(count < 2 || count > 3)
                 result[r] << 0
              else
                 result[r] << 1
              end
           else
              if(count == 3)
                 result[r] << 1
              else
                 result[r] << 0
              end
           end
       end
   end

   return result
end



def countLiveNeighbors(seed, r, c)
   upperLeft = -1
   upper = -1
   upperRight = -1
   left = -1
   right = -1
   lowerLeft = -1
   lower = -1
   lowerRight = -1

   if(r - 1 >= 0 && c - 1 >= 0)
      upperLeft = seed[r-1][c-1]
   end
   if(r - 1 >= 0)
      upper = seed[r-1][c]
   end
   if(r - 1 >=0 && c + 1 < seed[0].length)
      upperRight = seed[r-1][c+1]
   end
   if(c - 1 >= 0)
      left = seed[r][c-1]
   end
   if(c < seed[0].length )
      right = seed[r][c+1]
   end
   if(r + 1 < seed.length && c-1 >= 0)
      lowerLeft = seed[r+1][c-1]
   end
   if(r + 1 < seed.length)
      lower = seed[r+1][c]
   end
   if(r + 1 < seed.length && c + 1 < seed[0].length)
      lowerRight = seed[r+1][c+1]
   end

#   puts "ul " + upperLeft.to_s
#   puts "up " + upper.to_s
#   puts "ur " + upperRight.to_s
#   puts "lf " + left.to_s
#   puts "rt " + right.to_s
#   puts "ll " + lowerLeft.to_s
#   puts "lo " + lower.to_s
#   puts "lr " + lowerRight.to_s


   count = 0
   count += upperLeft == 1 ? 1 : 0
   count += upper == 1 ? 1 : 0
   count += upperRight == 1 ? 1 : 0
   count += left == 1 ? 1 : 0
   count += right == 1 ? 1 : 0
   count += lowerLeft == 1 ? 1 : 0
   count += lower == 1 ? 1 : 0
   count += lowerRight == 1 ? 1 : 0

   return count


end

