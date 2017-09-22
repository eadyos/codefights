/*
https://codefights.com/arcade/code-arcade/spring-of-integration/picP24ieQnuqR4kxJ

Yesterday you found some shoes in the back of your closet. Each shoe is described by two values:

type indicates if it's a left or a right shoe;
size is the size of the shoe.
Your task is to check whether it is possible to pair the shoes you found in such a way that each pair consists of a right and a left shoe of an equal size.

Example

For

shoes = [[0, 21],
         [1, 23],
         [1, 21],
         [0, 23]]
the output should be
pairOfShoes(shoes) = true;

For

shoes = [[0, 21],
         [1, 23],
         [1, 21],
         [1, 23]]
the output should be
pairOfShoes(shoes) = false.

Input/Output

[time limit] 6000ms (groovy)
[input] array.array.integer shoes

Array of shoes. Each shoe is given in the format [type, size], where type is either 0 or 1 for left and right respectively, and size is a positive integer.

Guaranteed constraints:
1 ≤ shoes.length ≤ 25,
1 ≤ shoes[i][1] ≤ 100.

[output] boolean

true if it is possible to pair the shoes, false otherwise.
 */



boolean pairOfShoes(List<List<Integer>> shoes) {

    shoes.groupBy{  //Group by size
        it[1]
    }.every{  //Are there an equal number of left & right?
        it.value.count{it[0] == 0} == it.value.count{it[0] == 1}
    }

}
