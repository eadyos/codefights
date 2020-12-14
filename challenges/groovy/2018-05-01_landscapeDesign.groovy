/*
https://app.codesignal.com/challenge/suXknrsWDFQQWHpEa

Your friend John decided to do landscape design. Now his garden can be represented as n vertical columns, the ith of which begins on the y coordinate 
of a[i], and goes infinitely down. John can do one operation - change the height of any column by 1 (note that the heights can become negative). 
Your friend wants to change the height of the columns from ai to bi, so that for each 1 ≤ i ≤ n - 2, bi = bi + 2, and any two adjacent columns differ
in height exactly on diff.
Help your friend understand, what is the minimum amount of operations he should perform to obtain desired heights.

Example

For a = [1, 2, 3, -1, 2] and diff = 1, the output should be
landscapeDesign(a, diff) = 5.
John can obtain the following b = [2, 1, 2, 1, 2].

     _
   _| |  _             _   _   _ 
 _| | | | |           | |_| |_| |
| | | | | |  -------> | | | | | |
| | | |_| |           | | | | | |
| | | | | |           | | | | | |

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.integer a

Initial heights of the columns.

Guaranteed constraints:
2 ≤ a.length ≤ 105,
-109 ≤ a[i] ≤ 109.

[input] integer diff

The height on which two neighboring columns should differ.

Guaranteed constraints:
0 ≤ diff ≤ 109.

[output] integer64

The minimum number of operations John should perform to obtain the desired heights.

*/

long landscapeDesign(List<Integer> a, int diff) {
  
    /*
        [solveByBruteForce1(a,diff), solveByBruteForce2(a.diff)].min()
    */
    
    /*
    int offset = 1
    def r1 = solveByMedian(a, diff, 0)
    def r2 = solveByMedian(a, diff, offset)
    def r3 = solveByMedian(a, diff, offset * -1)
    if(r3[0] > r1[0]){
        r3[0] = Integer.MAX_VALUE
    }
    if(r2[0] > r1[0]){
        r2[0] = Integer.MAX_VALUE
    }
    while(r1[0] > r2[0] || r1[0] > r3[0]){
        offset++
        if(r2[0] < r1[0]){
            r1 = r2
            r2 = solveByMedian(a, diff, offset, r2[1])
        }else{
            r1 = r3
            r3 = solveByMedian(a, diff, offset * -1, r3[1])
        }
    }
    return r1[0]
    */
    
    medianDiffSolve(a, diff)

}

def medianDiffSolve(a, long diff){

    def b = (0..<a.size()).collect{i->
        a[i] - diff * (i%2)
    }.sort()
    def medianDiff1 = b[a.size() / 2 as int]
    b = (0..<a.size()).collect{i->
        a[i] - diff * ((i+1)%2)
    }.sort()
    def medianDiff2 = b[a.size() / 2 as int]

    long count1 = (0..<a.size()).sum{i->
        (medianDiff1 - a[i] + diff*(i%2)).abs()
    }
    long count2 = (0..<a.size()).sum{i->
        (medianDiff2 - a[i] + diff*((i+1)%2)).abs()
    }
    
    [count1, count2].min()

}

def solveByBruteForce1(a, diff){

    int top = a.max()
    int bottom = top - diff
    int s = a.size()
    int previous = Integer.MAX_VALUE
    int r = previous - 1
    while(r < previous) {
        previous = r
        r = (0..<s).sum { i ->
            if (i % 2 == 0) {
                (a[i] - bottom).abs()
            } else {
                (a[i] - top).abs()
            }
        }
        top--
        bottom--
    }
    return previous
}

def solveByBruteForce2(a, diff){

    int top = a.max()
    int bottom = top - diff
    int s = a.size()
    int previous = Integer.MAX_VALUE
    int r = previous - 1
    while(r < previous) {
        previous = r
        r = (0..<s).sum { i ->
            if (i % 2 == 1) {
                (a[i] - bottom).abs()
            } else {
                (a[i] - top).abs()
            }
        }
        top--
        bottom--
    }
    return previous
}

def solveByMedian(a, diff, offset, which=0){
    int n = a.size()
    def median = a.sort(false)[(a.size() / 2) as int]
    median+=offset
    int half = (diff + 1) / 2
    int top = median + half
    int bottom = median - half
    if(diff%2) top--

    int result1
    int result2
    if(which in [0,1]){
        result1 = (0..<n).collect{i->
            int r
            if(i%2){ // odd
                r = a[i] - top
            }else{
                r = a[i] - bottom
            }
            r.abs()
        }.sum()
    }
    if(which in [0,2]){
        result2 = (0..<n).collect{i->
            int r
            if(i%2==0){ // odd
                r = a[i] - top
            }else{
                r = a[i] - bottom
            }
            r.abs()
        }.sum()
    }
    if(which == 0){
        if(result1 < result2){
            return [result1, 1]
        }else{
            return [result2, 2]
        }
    }else if(which == 2){
        return [result2, 2]
    }else{
        return [result1, 1]
    }
}
