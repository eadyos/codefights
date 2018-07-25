/*
https://app.codesignal.com/challenge/X2mPWE5pr4okydBF4

​Two friends Davit and Tigran were bored. So they decided to play a game.

Rules of the game are as follows: First, they choose an integer n. Then they take successive turns, starting with Davit. In each turn, a player chooses an integer from 1 to 8 (inclusive) and subtracts it from n.

The player wins if after his turn, n becomes 0.

Your task is to determine whether Davit will win or not, assuming that both players play optimally.

Examples

For n = "5", the output should be boredFriends(n) = true. Davit can make n = 0 after his first move.

For n = "9", the output should be boredFriends(n) = false. Davit can't win during his first move, but no matter what number he chooses, Tigran can win on the next move.

Input / Output

[execution time limit] 2 seconds (d)

[input] string n

A string of digits without leading zeros.

Guaranteed constraints:
1 ≤ n.length ≤ 105

[output] boolean

Return true if Davit wins, and false otherwise.
*/

(defun boredFriends (n) (mod (parse-integer n) 9) )