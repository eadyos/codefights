/*

https://app.codesignal.com/challenge/hqLbYHvpTMZYYLA6h

Two strings are called anagrams, if they contain the same characters, but the order of the characters may be different.

Given a string consisting of lowercase letters and question marks, s1, and another string consisting of lowercase letters, s2, determine whether these two strings could become anagrams by replacing each ? character in s1 with a letter.

Examples

For s1 = listen and s2 = silent, the output should be couldBeAnagram(s1, s2) = true. The letters of s1 could be rearranged to form s2.

For s1 = cat and s2 = dog, the output should be couldBeAnagram(s1, s2) = false. There's no way s2 could be formed using the letters of s1.

For s1 = n?ce and s2 = nice, the output should be couldBeAnagram(s1, s2) = true. By replacing the ? with i in s1, the two strings will have the same characters.

Input / Output

[execution time limit] 4 seconds (rb)

[input] string s1

A string of lowercase letters and question marks.

Guaranteed constraints:
0 ≤ s1.length ≤ 80000

[input] string s2

A string of lowercase letters.

Guaranteed constraints:
0 ≤ s2.length ≤ 80000

[output] boolean

Return true if the strings could become anagrams by replacing all the ? characters with letters, and false otherwise.


*/


T couldBeAnagram(a, b) {
    
    a.each{
        b -= it
    }.count("?") == b.size()

    
}
