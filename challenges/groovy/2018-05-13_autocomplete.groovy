/*
https://app.codesignal.com/challenge/5vapCTsjKR5GbAFsS

Hey, we all use text editors all the time right? This is another fun challenge based on the algorithmic ideas behind text editors!

This time we'll be looking at autocomplete - a feature commonly found in development environments, search engines, and smartphones. If the user pauses while typing out a word, autocomplete will suggest possible words beginning with the characters they've typed.

Given a list of words and a series of actions (keystrokes or pauses), we'd like to produce an array of suggested words for every time we encounter a pause (sorted lexicographically).

Since it can be frustrating to work with key codes, the input is given as an array of strings (any single alphabet character, or "PAUSE" or "BACKSPACE").

Example

For
wordList = ["under", "understand", "understanding", "understandable", "unacceptable", "undeniable", "unilateral", "universe", "universal", "underestimated", "understated"]
and

actions = ["u", "n", "PAUSE", "d", "e", "PAUSE", "r", "s", "t", "a", "PAUSE", "t", "e", "PAUSE"]
the output should be

autocomplete(wordList, actions) = [["unacceptable", "undeniable", "under", "underestimated", "understand", "understandable", "understanding", "understated", "unilateral", "universal", "universe"],
                                   ["undeniable", "under", "underestimated", "understand", "understandable", "understanding", "understated"],
                                   ["understand", "understandable", "understanding", "understated"],
                                   ["understated"]]


For
wordList = ["cats", "cat", "cap", "cape", "cute", "cuts"]
and

actions = ["c", "a", "PAUSE", "BACKSPACE", "u", "t", "PAUSE"]
the output should be

autocomplete(wordList, actions) = [["cap", "cape", "cat", "cats"],
                                   ["cute", "cuts"]]
Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.string wordList

An array of all the words that autocomplete suggestions will be based on. There are no duplicate words within the list.

Guaranteed constraints:

0 ≤ wordList.length ≤ 150000,
0 ≤ wordList[i].length ≤ 21.

[input] array.string actions

An array of actions the user has taken (in order), consisting of alphabet characters, backspaces, and pauses.

Guaranteed constraints:
0 ≤ actions.length ≤ 105,
actions[i] ∈ {"A" - "Z", "a" - "z", "BACKSPACE", "PAUSE"}.

[output] array.array.string

The length of this array should be equal to the number of "PAUSE" commands in the actions array, and each element is an array of suggested words at the time of the pause.

*/

T autocomplete(w, a) {

    w.sort()
    T t = []
    T r = []

    a.each{c->
        if(c == "PAUSE"){
            if(t){
                T s = t.join()

                T i = -1

                int b
                T h = w.size() - 1
                while (b <= h) {
                    int m = (b + h) / 2
                    if (w[m].startsWith(s)) {
                        i = m
                        break
                    }
                    if (w[m] < s) 
                        b = m + 1
                    else 
                        h = m - 1
                }

                if(i < 0){
                    r << []
                }else{
                    T row = []
                    row << w[i]
                    T left = i-1
                    while(left >= 0 && w[left].startsWith(s))
                        row.add(0,w[left--])
                    
                    T right = i+1
                    while(right < w.size() && w[right].startsWith(s))
                        row << (w[right++])
                    
                    r << row
                }
            }else
                r << w
        }else if(c == "BACKSPACE"){
            if(t)
                t.pop()
        }else
            t += c
    }

    r

}
