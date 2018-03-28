/*
https://codefights.com/challenge/uTaa6ELcB5u6cwifr

I define a shortened string as a string after being shortened from a full-string (a full-string is a string just contains 
uppercase English letters) and it follows the rules:

Xm - The character X rewrites m times;
(S)m - The string S rewrites m times.
For example, "H3A" is a shortened string of "HHHA".
(HDL)5 is a shortened string of "HDLHDLHDLHDLHDL".
(AH0)2AD is a shortened string of "AAAD".

Given a shortened string, return its full-string.

Example
For ss = "KB2 (Y2F)2 B5A". the output should be
shortenedString(ss) = "KBBYYFYYFBBBBBA".

Input/Output

[execution time limit] 6 seconds (groovy)

[input] string ss

A string consisting of uppercase English letters (A, B, C,...,Z), numbers, whitespace characters and brackets. It is 
guaranteed that parentheses form a regular bracket sequence.

Guaranteed constraints:
1 ≤ ss.length ≤ 1000.

[output] string

A string just contains uppercase English letters. The whitespace characters is unnecessary in a full-string.

*/

T shortenedString(s) {
  while(s!=(s=s.replaceAll(/\(([A-Z0-9\s]*)\)(\d+)/){ it[1] * (it[2] as int) } - " ")) 0
  s.replaceAll( /([A-Z])(\d+)/ ) { it[1] * (it[2] as int) }
}
