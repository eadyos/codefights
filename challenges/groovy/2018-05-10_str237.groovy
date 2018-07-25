/*
https://app.codesignal.com/challenge/gKKyNFMayBBmwDqQh

Provided a string, your mission is to find and count all set (of indices) of characters of that the sum of their ASCII is equal to 237.

Examples

For str = "Hello world!", the output should be
str237(str) = 1.
Here is the ascii values or the above string:
72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33.
From the above list, we can only obtain one set of character which has the ascii sum is 237: H d! (237 = 72 + 32 + 100 + 33).
So the final answer is: 1

For str = "Hello world!!", the output should be
str237(str) = 2.
You have 2 sets H d!. So, the answer is 2.

Input/Ouput

[execution time limit] 6 seconds (groovy)

[input] string str

Guaranteed constraints:
0 ≤ str.length ≤ 237.

[output] integer

*/

T str237(s) {

    T a = [1] + [0] * 237
    int c,i,j
    for (T n = s.bytes; i < n.length;)
        for (j = [237, c += s = n[i++]].min(); j >= s;)
            a[j] += a[j-- - s]

    a[-1]


}
