/*
https://codefights.com/arcade/code-arcade/regular-hell/E6eYu8dsfwch2My27


Given a string s, determine if it is a subsequence of a given string t.

Example

For t = "CodeFights" and s = "CoFi", the output should be
isSubsequence(t, s) = true;

For t = "CodeFights" and s = "cofi", the output should be
the output should be
isSubsequence(t, s) = false.

Input/Output

[execution time limit] 4 seconds (js)

[input] string t

A string consisting of Latin letters, whitespace characters (' '), digits and punctuation marks (".,?!=*+-").

Guaranteed constraints:
0 ≤ t.length ≤ 500.

[input] string s

A string consisting of Latin letters, whitespace characters (' '), digits and punctuation marks (".,?!=*+-").

Guaranteed constraints:
0 ≤ s.length ≤ 50.

[output] boolean

true if the s is a subsequence of t, false otherwise.
*/

function isSubsequence(t, s) {
  var pattern = "";
  for (var i = 0; i < s.length; i++) {
    pattern += "[" + s[i] + "]" + ".*" ;
  }
  var re = new RegExp(pattern);
  return re.test(t);
}
