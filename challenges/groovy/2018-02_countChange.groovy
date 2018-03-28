/*
https://codefights.com/challenge/cJMfrHGiu364pdfZa

This is a reverse challenge, enjoy!

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer change

Guaranteed constraints:
0 < = change < 10^6 

[input] array.integer coins

Guaranteed constraints:
0 < coins.length < 25.

[output] integer64

change: 91
coins: [1, 4, 13]
Expected Output:
96

...see link for more
*/

T countChange(n, c) {
    
        T t = new long[n+1]
        t[0] = 1
        for (int i; i<c.size(); i++)
            for (T j=c[i]; j<=n;)
                t[j] += t[j++ -c[i]]
 
        t[n]
}
