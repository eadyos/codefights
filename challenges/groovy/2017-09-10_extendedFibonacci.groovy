/*
https://codefights.com/challenge/kTtinMJicpYahwHkW

You want to impress your friends with the Fibonacci Sequence, but they all know it already! Instead, you decide to make Fibonacci-like sequences as follows:

Given nonnegative integers aa and bb, the sequence \{s_n\}_{n\geq 0}{s
​n
​​ }
​n≥0
​​  is defined as:

s_0 = 2 s
​0
​​ =2

s_1 = a s
​1
​​ =a

s_{n+2} = as_{n+1}+bs_{n} s
​n+2
​​ =as
​n+1
​​ +bs
​n
​​

Since you want to impress your friends, you should be able to quickly tell them s_is
​i
​​  for any reasonable ii.

This value might be so large that you can't easily display it. Instead, output the value mod 10^9+710
​9
​​ +7 (which is prime), in the range [0,10^9+7)[0,10
​9
​​ +7).

Note that it is guaranteed that a^2+4ba
​2
​​ +4b is a perfect square, and that calculation of this value will not overflow a double.

If you're having trouble getting started, (rot13) ybbx hc gur qrevingvba bs gur pybfrq sebz bs gur Svobanppv Frdhrapr.

Example

For a = 1, b = 2 and i = 4, the output should be
extendedFibonacci(a, b, i) = 17.
s0 = 2
s1 = a = 1
sn + 2 = asn + 1 + bsn = sn + 1 + 2sn.
s2 = 1 + 2 · 2 = 5
s3 = 5 + 2 · 1 = 7
s4 = 7 + 2 · 5 = 17

For a = 0, b = 15129 and i = 2831, the output should be
extendedFibonacci(a, b, i) = 0.
s1 = a = 0
sn + 2 = asn + 1 + bsn = 15129sn
s3 = 15129 · 0 = 0
s5 = 15129 · 0 = 0
...
s2831 = 15129 · 0 = 0

Input/Output

[time limit] 6000ms (groovy)
[input] integer64 a

Along with bb, defines the sequence \{s_n\}_{n\geq 0}{s
​n
​​ }
​n≥0
​​
a^2+4ba
​2
​​ +4b is a perfect square.
0\leq a<2^{26}0≤a<2
​26
​​

[input] integer64 b

Along with aa, defines the sequence \{s_n\}_{n\geq 0}{s
​n
​​ }
​n≥0
​​
a^2+4ba
​2
​​ +4b is a perfect square.
0\leq b<2^{26}0≤b<2
​26
​​

[input] integer64 i

Index of the desired value in the sequence
0\leq i<2^{53}0≤i<2
​53
​​

[output] integer

s_is
​i
​​  mod 10^9+710
​9
​​ +7
 */

T extendedFibonacci(b, c, i){
    c = b-(b*b+4*c)**0.5 >> 1
    [c+=0g,b-c].sum{it.modPow i,c = 10**9 + 7}%c
}