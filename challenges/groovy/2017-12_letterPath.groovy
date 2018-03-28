/*
https://codefights.com/challenge/ZjA8rtABExYY9vqAi

You will be given a 2D matrix of English lower case letters. Your mission today is to find the longest
path that following these rules below.

The path can only be straight line or form a 90 degree corner;
In each step, the next letter must be different from the current letter;
The path cannot cut itself or form a loop path;
If there are more than one longest path, pick the highest one.
Example
For

letterMap = 
a   b   c
d   e   f
g   h   i
the output should be
letterPath(letterMap) = "ihgdefcba".
In this example, we have several longest paths: abcfihgde, adghifcbe, edghifcba, etc. The highest 
one is the final answer ihgdefcba

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.array.string letterMap

The 2D matrix of letters

Guaranteed constraints:
0 ≤ letterMap.length ≤ 5,
0 ≤ letterMap[i].length = letterMap[i + 1].length ≤ 5,
letterMap[i][j].length = 1 and contains only a-z.

[output] string

*/

T letterPath(m) {
  
    T p = []
    for(x in 0..<q(m))
        for(y in 0..<q(m.getAt(0)))
            p << s(m,x,y)

    j f(p).collect{ j it }.max()

}

T s(m,x,y, p="", r=[]){
    T l
    T c
    x+1 && x < q(m) && y+1 && y < q(m[0]) && p != (l = m[x][y]) && !r.grep(c = "$l$x$y") && r << c ?
        f( [[x-1,y], [x+1,y], [x,y-1], [x,y+1]].collect{ s(m,it[0],it[1],l,r.clone()) }).max{ j it }
    : r
}

T f(a){
    a.findAll{q(it) == q( a.max{q it })}
}

T j(a){
    a.collect{
        it[0]
    }join()
}

T q(a){
    a?.size()
}