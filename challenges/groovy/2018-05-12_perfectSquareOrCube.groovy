/*
https://app.codesignal.com/challenge/jtbjBgG7Fhhn7S4Ac

It's your lucky day: you just landed a role on the hit TV show "The Walking Dead"!

In your first episode, the scene is pretty stressful already: you've found a serum that will make you immune to zombies, but it's inside a locked safe (and the zombies are scratching outside the door!). First you try to shoot out the lock mechanism with your gun, to no avail. Suddenly you notice a message scrawled on the side of the safe: "the password is a perfect square or a perfect cube". There is also a number on this note.

Determine the number of ways you can rearrange the digits of the number to make a correct password. If the given number is already a perfect square or a perfect cube, include it in your answer as well. In your answer, also include correct passwords with leading zeroes.

Example

For number = 414, the output should be
perfectSquareOrCube(number) = 2.
You can get numbers 144, which is a perfect square of 12, and 441, which is a perfect square of 21.

For number = 64, the output should be
perfectSquareOrCube(number) = 1.
The number 64 is a perfect square of 8 and a perfect cube of 4.

For number = 71, the output should be
perfectSquareOrCube(number) = 0.
71 and 17 aren't perfect squares or perfect cubes.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer number

An integer, the number on the note.

Guaranteed constraints:
1 ≤ number ≤ 900.

[output] integer

The number of ways to rearrange the digits of the number to get a perfect square or a perfect cube.

*/

T perfectSquareOrCube(n) {
    
    "$n".grep()permutations()count{
        Math.cbrt(n = it.sum() as int)%1 * (n**0.5%1) == 0
    }
  
}
