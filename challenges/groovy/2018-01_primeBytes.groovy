/*
https://codefights.com/challenge/36EZcdik6of6Xp4TW


This is a reverse challenge challenge, enjoy!

Input/Output

[execution time limit] 6 seconds (groovy)

[input] string c

Guaranteed constraints:
1 ≤ c.length ≤ 312000.

[output] integer

c: "Làm hết sức mình, mọi người"
Expected Output:
10

see link for more input/output

*/

T primeBytes(c) {

    c.bytes*.abs()count{
        (2**it-1)%it<2
    }
  
}
