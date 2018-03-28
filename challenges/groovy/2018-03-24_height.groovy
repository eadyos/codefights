/*
https://codefights.com/challenge/aGpe4ajL7qi3rJMZZ

This is a reverse challenge, enjoy!

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.integer tallerThan

Guaranteed constraints:
tallerThan.length < 2^16,
0 ≤ tallerThan[i] < 2^16.

[output] array.integer

*/

T height(a) {
  
    T p = []
    a[a=-1..0].collect{
        int m,l,r = p.size - 1
        while(l <= r)
            p[m = l + r >> 1] < it ? l = ++m : (r = --m)
        
        p.add l,it
        l
    }[a]
}
