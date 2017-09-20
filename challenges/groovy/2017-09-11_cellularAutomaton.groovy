/*
https://codefights.com/challenge/wwiKS64bNrqvLp4EJ

We all know Conway's Game of Life. Long time codefighters may remember once in a while there will be a challenge to simulate Game of Life. But did you know that these kind of cellular automaton has an one-dimensional variant?

This is called Elementary Cellular Automaton. Mathematician Stephen Wolfram studies this kind of automaton and its generalization back in 1983, and published as the book A New Kind of Science in 2002.

Like the two-dimensional Game of Life, the board is a row of cells that can be either black or white, and what color a cell will be in the next step is determined by the color of itself and its two neighbors. There are 8 possible color combinations, so there are 28 = 256 kinds of possible rule. Wolfram uses an 8-bit binary number to describe this rule, now known as the Wolfram code. In the code, you list out 3-bit binary numbers from 7 to 0 representing these 8 configurations, with 1 representing black cell and 0 representing white cell. Then write down the corresponding color of the next iteration, forming a 8-bit number, with the configuration corresponds to 111 (7) being most significant bit. The decimal value of this 8-bit number is the Wolfram code of the rule.

For example, the following rule:



has Wolfram code of 10000111bin = 135dec, and is called Rule 135. This is the pattern used on the building of the recently opened Cambridge North railway station.

Here's a possible evolution of Rule 135, with time going from top to bottom:


These 256 rules exhibits different properties ranging from quickly stabilized, to simple and repeating pattern, to chaotic and random behavior. There's Rule 184 that can model a wide variaty of things from traffic to ballistic annihilation; Rule 110 is proven to be Turing complete just like Game of Life, meaning under certain configuration it can perform calculation; and Rule 30 (which is just Rule 135 but swapping black and white) generates a seemly random behavior, so much that Wolfram himself proposes using it as a random number generator.

Your task here is simple: given a rule and an initialRow as a string, where '#' represents black cell and '.' represents white cell, simulate specified iterations and return the final row. The string is considered to be cyclic, meaning that the rightmost cell is considered to be the left neighbor of the leftmost cell, and vice versa.

Example

For rule = 135, initialRow = "#..#.##...#.###..##.#." and iterations = 11, the output should be
cellularAutomation(rule, initialRow, iterations) = "...#...#....#.######..".
This is the evolution shown above.
For rule = 170, initialRow = "...###..." and iterations = 4, the output should be
cellularAutomation(rule, initialRow, iterations) = "##......#".
Rule 170, written in binary being 10101010, is this rule:

It is easy to see this rule let each cell copies the color of its right neighbor as its next color. Therefore, the whole pattern shifts to the left one cell every iteration.
Input/Output

[time limit] 6000ms (groovy)
[input] integer rule

The Wolfram code of the rule.

Guaranteed constraints:
0 ≤ rule ≤ 255.

[input] string initialRow

Strings made of pound ('#') and dot ('.') characters.

Guaranteed constraints:
1 ≤ initialRow.length ≤ 1000.

[input] integer iterations

Number of iterations to perform.

Guaranteed constraints:
1 ≤ iterations ≤ 1000.

[output] string

The final result after specified iterations.
 */

T cellularAutomaton(r, i, c,s=i.size()) {

    i=i.collect{it == "#" ? 1 : 0}

    c.times{
        i = (0..<s).collect{j->
            def p = i[j-1] ? 4 : 0
            p += i[j] ? 2 : 0
            p += i[(j+1) % s] ? 1 : 0
            r >> p & 1
        }
    }
    i.join().tr("10","#.")
}





/*
String cellularAutomaton(rule, initialRow, iterations) {

    def binString = rule.toBinaryString(rule).padLeft(8,"0").reverse()
    binString = binString.collect{it == "0" ? 0 : 1}
    initialRow=initialRow.collect{it == "#" ? 1 : 0}

    while(iterations--){
        initialRow = (0..<initialRow.size()).collect{i->
            def position = initialRow[i-1] == 1 ? 4 : 0
            position += initialRow[i] == 1 ? 2 : 0
            position += initialRow[(i+1) % initialRow.size()] == 1 ? 1 : 0
            binString[position]
        }
    }
    initialRow.join().tr("10","#.")
}
*/
