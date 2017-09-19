/*
https://codefights.com/arcade/intro/level-3/JKKuHJknZNj4YGL32

Given two strings, find the number of common characters between them.

Example

For s1 = "aabcc" and s2 = "adcaa", the output should be
commonCharacterCount(s1, s2) = 3.

Strings have 3 common characters - 2 "a"s and 1 "c".

Input/Output

[time limit] 4000ms (rb)
[input] string s1

A string consisting of lowercase latin letters a-z.

Guaranteed constraints:
1 ≤ s1.length ≤ 15.

[input] string s2

A string consisting of lowercase latin letters a-z.

Guaranteed constraints:
1 ≤ s2.length ≤ 15.

[output] integer
*/

int commonCharacterCount(String s1, String s2) {

    def s3 = s2
    s1.each{
        s3 = s3.replaceFirst(it, "")
    }
    s2.size() - s3.size()
}
