/*
https://codefights.com/arcade/code-arcade/well-of-integration/Z9opBsx5fX6XfQJdt

Check whether the given string is a subsequence of the plaintext alphabet.

Example

For s = "effg" or s = "cdce", the output should be
alphabetSubsequence(s) = false;
For s = "ace" or s = "bxz", the output should be
alphabetSubsequence(s) = true.
Input/Output

[time limit] 6000ms (groovy)
[input] string s

Guaranteed constraints:
2 ≤ s.length ≤ 15.

[output] boolean

true if the given string is a subsequence of the alphabet, false otherwise.
 */


boolean alphabetSubsequence(String s) {

    def prev = ""
    s.every{
        it > prev && (prev = it)
    }
}
