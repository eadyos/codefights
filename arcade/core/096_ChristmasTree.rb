=begin
https://codefights.com/arcade/code-arcade/spring-of-integration/FvMZwyYRsGaA7Q3A8


It's Christmas time! To share his Christmas spirit with all his friends, the young Christmas Elf
decided to send each of them a Christmas e-mail with a nice Christmas tree. Unfortunately,
Internet traffic is very expensive in the North Pole, so instead of sending an actual image he
got creative and drew the tree using nothing but asterisks ('*' symbols). He has given you the
specs (see below) and your task is to write a program that will generate trees following the
spec and some initial parameters.

Here is a formal definition of how the tree should be built, but before you read it the Elf
HIGHLY recommends first looking at the examples that follow:

Each tree has a crown as follows:

 *
 *
***
Define a line as a horizontal group of asterisks and a level as a collection of levelHeight
lines stacked one on top of the other.

Below the crown there are levelNum levels.

The tree is perfectly symmetrical so all the middle asterisks of the lines lie on the center
of the tree.

Each line of the same level (excluding the first one) has two more asterisks than the previous
one (one added to each end);

The number of asterisks in the first line of each level is chosen as follows:

the first line of the first level has 5 asterisks;
the first line of each consecutive level contains two more asterisks than the first line of
the previous level.
And finally there is the tree foot which has a height of levelNum and a width of:

levelHeight asterisks if levelHeight is odd;
levelHeight + 1 asterisks if levelHeight is even.
Given levelNum and levelHeight, return the Christmas tree of the young elf.

Example

For levelNum = 1 and levelHeight = 3, the output should be

christmasTree(levelNum, levelHeight) =
    ["    *",
     "    *",
     "   ***",
     "  *****",
     " *******",
     "*********",
     "   ***"]
, which represents the following tree:

            ___
      *        |
      *        |-- the crown
     ***    ___|
    *****      |
   *******     |-- level 1
  ********* ___|
     ***    ___|-- the foot
For levelNum = 2 and levelHeight = 4, the output should be

christmasTree(levelNum, levelHeight) =
    ["      *",
     "      *",
     "     ***",
     "    *****",
     "   *******",
     "  *********",
     " ***********",
     "   *******",
     "  *********",
     " ***********",
     "*************",
     "    *****",
     "    *****"]
, which represents the following tree:

                ___
        *          |
        *          | -- the crown
       ***      ___|
      *****        |
     *******       | -- level 1
    *********      |
   ***********  ___|
     *******       |
    *********      | -- level 2
   ***********     |
  ************* ___|
      *****        | -- the foot
      *****     ___|
Input/Output

[time limit] 4000ms (rb)
[input] integer levelNum

A positive integer, the number of levels.

Guaranteed constraints:
1 ≤ levelNum ≤ 8.

[input] integer levelHeight

The number of lines in each level.

Guaranteed constraints:
3 ≤ levelHeight ≤ 8.

[output] array.string

The Christmas tree according to the specs and inputs. Output elements should not contain
trailing whitespaces, and at least one of them should start with the '*' symbol.
=end

def christmasTree(levelNum, levelHeight)

    tree = []
    (1..levelNum).each{|lIndex|
        level = []
        if lIndex == 1
            level += [
             "  *",
             "  *",
             " ***"
            ]
        end
        (1..levelHeight).each{|hIndex|
            if hIndex == 1
                level << "*" * (5 + ((lIndex - 1) * 2))
            else
                (0...level.size).each{|i|
                    level[i] = " " + level[i]
                }
                level << "*" * (level[-1].size + 1)
            end
        }
        (0...tree.size).each{|i|
            tree[i] = " " + tree[i]
        }
        tree += level
    }
    footWidth = levelHeight
    footWidth += footWidth % 2 == 0 ? 1 : 0
    indent = (tree[-1].size - footWidth) / 2
    levelNum.times do
        tree << (" " * indent) + ("*" * footWidth)
    end
    tree
end
