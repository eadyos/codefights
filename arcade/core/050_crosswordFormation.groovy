/*
https://codefights.com/arcade/code-arcade/labyrinth-of-nested-loops/W5Sq7taLSzNHh8GiF

You're a crossword fanatic, and have finally decided to try and create your own. However, you also love symmetry and good design, so you come up with a set of rules they should follow:

the crossword must contain exactly four words;
these four words should form four pairwise intersections;
all words must be written either left-to-right or top-to-bottom;
the area of the rectangle formed by empty cells inside the intersections isn't equal to zero.
Given 4 words, find the number of ways to make a crossword following the above-described rules. Note that two crosswords which differ by rotation are considered different.

Example

For words = ["crossword", "square", "formation", "something"], the output should be
crosswordFormation(words) = 6.

The six crosswords can be formed as shown below:

  f                         f                             f
  o                     c r o s s w o r d     c r o s s w o r d
c r o s s w o r d           r   o                   q     r
  m   q                     m   m                   u     m
  a   u            ;  s q u a r e          ;        a     a
  t   a                     t   t                   r     t
  i   r                     i   h             s o m e t h i n g
s o m e t h i n g           o   i                         o
  n                         n   n                         n
                                g

    c         s               s
f o r m a t i o n       c     q               c         s
    o         m         r     u               r         o
    s q u a r e       f o r m a t i o n       o         m
    s         t    ;    s     r            ;  s q u a r e
    w         h         s o m e t h i n g     s         t
    o         i         w                     w         h
    r         n         o                   f o r m a t i o n
    d         g         r                     r         n
                        d                     d         g
Input/Output

[time limit] 6000ms (groovy)
[input] array.string words

An array of distinct strings, the words you need to use in your crossword.

Guaranteed constraints:
words.length = 4,
3 ≤ words[i].length < 15.

[output] integer

The number of ways to make a correct crossword of the desired formation.
 */

//There is probably a more elegant solution than all of this nested looping.
int crosswordFormation(List<String> words) {

    initIndexMatches(words)

    int count = 0
    words.eachPermutation{
        def v1 = it[0]
        def v2 = it[1]
        def h1 = it[2]
        def h2 = it[3]

        for(int v1Index = 0; v1Index < v1.size() - 2;v1Index++){
            def h1Indexes = getMatchingIndexes(h1, v1[v1Index])
            for(int h1Index in h1Indexes){
                for(int h1Idx = h1Index+2; h1Idx < h1.size();h1Idx++){
                    def v2Indexes = getMatchingIndexes(v2, h1[h1Idx])
                    for(int v2Index in v2Indexes){
                        for(int v2Idx = v2Index+2; v2Idx < v2.size();v2Idx++){
                            def h2Indexes = getMatchingIndexes(h2, v2[v2Idx])
                            def voffset = v2Index - v1Index
                            def hoffset = h1Idx - h1Index
                            for(int h2Index in h2Indexes){
                                def vPos = v2Idx - voffset
                                def hPos = h2Index - hoffset
                                if(vPos >=0 && vPos < v1.size() && hPos >= 0 && hPos < h2.size()){
                                    if(v1[vPos] == h2[hPos]){
                                        count++
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }
    count
}

//I had to speed up the altorithm so I pre-initialized the
//index matches into this hash cache to save an order of magnitude
//on the nth-most loop
def indexMatches = [:]

def initIndexMatches(def words){
    def allLetters = words.join().grep().unique()
    words.each{word->
        allLetters.each{letter->
            def indexes = []
            for(int i = 0; i < word.size();i++){
                if(word[i] == letter)
                    indexes.add(i)
            }
            indexMatches[[word,letter]] = indexes
        }
    }
}

def getMatchingIndexes(String a, String b){
    indexMatches[[a,b]]
}
