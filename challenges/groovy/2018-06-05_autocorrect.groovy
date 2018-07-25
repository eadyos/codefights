/*
https://app.codesignal.com/challenge/tbnvdumnQNifQJ8CK

Hey, let's do one more text editor themed challenge!

Autocorrect is a feature commonly found in mobile phones - when the user does a typo, it gets automatically replaced with the closest matching word from a list of known words.

Given a set of known words, trainingWords, and a sequence of words input by the user, typedWords, our task is to find the string we'll get once the elements of typedWords have been autocorrected. Since parsing words can be tedious, both trainingWords and typedWords are given as arrays of strings. The final text should be output as a single string (words joined by spaces).

How to select the closest word
To compare strings, we'll be using Levenshtein distance, which is basically a measure of how many edits would be required in order to transform one word into another. An edit is one of the following three operations:

insertion - add a new character to some part of the string
(eg: from "awkward" to "bawkward")
deletion - remove a character from some part of the string
(eg: from "friend" to "fiend")
replacement - replace one character in the string with a different character
(eg: from "nice" to "vice")
For any string in typedWords that doesn't occur in trainingWords, we'll replace it with the string from trainingWords that's considered closest according to Levenshtein distance. If there's a tie for the closest match, choose the one that appears earliest in trainingWords. Comparisons are case-sensitive.

Example

For
trainingWords = ["without", "night", "text", "cellar", "requirement", "some", "park", "instinct", "flourish", "computing", "vision", "mean", "round", "mistakes", "vain", "exemption", "fast"]
and

typedWords = ["some", "tex", "whith", "mistakesd"]
the output should be

autocorrect(trainingWords, typedWords) = "some text without mistakes"
Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.string trainingWords

The set of words our autocorrect algorithm has been trained on. All of the words in the output will be chosen from this list. All words consist of uppercase and lowercase letters only. There are no repeat words in the list.

Guaranteed constraints:
1 ≤ trainingWords.length ≤ 2000
1 ≤ trainingWords[i].length ≤ 100

[input] array.string typedWords

A list of words typed by the user (in order). Each word will be replaced with the closest word from trainingWords (according to Levenshtein distance). All words consist of uppercase and lowercase letters only.

Guaranteed constraints:
0 ≤ typedWords.length ≤ 2000
1 ≤ typedWords[i].length ≤ 100

[output] string

The resulting sentence after typedWords have been autocorrected, joined by spaces.

*/

T autocorrect(a, b){
    b.collect{
        h it, a
    }join " "
}

def h = {w, a ->
    a.min{ f w, it }
}.memoize()

T f(a, b) {
    T c = (0..b.size()+1) as ArrayList
    for (int i = 1; i <= a.size(); i++) {
        c[0] = i
        int nw = i - 1
        for (int j = 1; j <= b.size(); j++) {
            int cj = Math.min(1 + Math.min(c[j], c[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1)
            nw = c[j]
            c[j] = cj
        }
    }
    c[b.length()]
}