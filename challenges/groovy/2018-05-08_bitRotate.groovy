/*

https://app.codesignal.com/challenge/ct2vZTL8N4urXaaSa


In this challenge, you will work with 31 bit integer only. Provided a non-negative integer n and rotate number r. Your mission is to do the left or right rotate base on its sign. If r ≥ 0, rotate n to left s steps or else rotate n to right.

Example

For n = 5 and r = 1, the output should be
bitRotate(n, r) = 10.
We all know that 5(10) is 0000000000000000000000000000101(2).
By rotate n to left 1 step, we get 0000000000000000000000000001010(2), which is 10(10).

For n = 1073741825 and r = -2, the output should be
bitRotate(n, r) = 805306368.
1073741825(10) is 1000000000000000000000000000001(2),
rotate n to right 2 steps, we get 0110000000000000000000000000000(2), which is 1805306368(10).

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer n

Guaranteed constraints:
0 ≤ n < 231.

[input] integer r

Guaranteed constraints:
-231 < n < 231.

[output] integer
*/

int bitRotate(int n, int r) {
    
    T t = new int[31]
    n = n << r
    if(n<0){
        (n | 1) & 2147483647
    }else{
        n
    }
    
    
/*  
    def s = n.toBinaryString(n).padLeft(31,"0").grep()
    if(r > 0){
        
        r%=31
        
        while(r--){
            def t = s.remove(0)
            s << t
        }
    }else{
        r*=-1
        r%=31
        while(r--){
            s.add(0, s.pop())
        }
    }
    n.parseInt(s.join(), 2)
    */
}
