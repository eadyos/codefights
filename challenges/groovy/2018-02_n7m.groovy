/*
https://codefights.com/challenge/6iWifbDCGEGsB396e

You have to detect long words and convert them into their numeronym counterparts. A numeronym is the shortening 
of a long word by only keeping the first 1-2 letters and the last letter, replacing everything in between with the 
number of letters removed. Also, it is always all lowercase, regardless of their placement in a sentence.

A vowel is any of aeiou. If the second letter is not a vowel, it is kept, otherwise it is part of the letters to replace.

Example where the second letter is a vowel: Numeronym -> N (length of "umerony") m -> n7m

Example where the second letter is not a vowel: Translation -> tr (length of "anslatio") n -> tr8n

Given a sentence, replace all words (alphabetic sequences) into numeronyms if the result is shorter than the original word.

Example
For sentence = "Shorten this text.", the output should be
n9m(sentence) = "sh4n this t2t.".

Input/Output

[execution time limit] 6 seconds (groovy)

[input] string sentence

A sentence. It consists of alphabetical characters (which makes up words), spaces and punctuation (any of .,;:?!-"'()/).

Guaranteed constraints:
sentence.length < 1000.

[output] string

The new sentence, long words are replaced with their numeronym counterparts.
*/

T n7m(s) {
  
    s.replaceAll(/\w{4,}/){i->
        s = i.size()-2
        T v = "aeiou" =~ i[1] ? i[0]
        : s-- > 2 ? i[0,1]
        : 0 
        v ? (v + s + i[-1]).toLowerCase() : i
    }
    
}





