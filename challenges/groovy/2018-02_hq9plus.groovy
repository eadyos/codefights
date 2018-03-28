/*
https://codefights.com/challenge/r7bErxjna9MKs8ush

HQ9+ is a joke programming language with four instructions:

H: Print "hello, world"
Q: Print the program's source code
9: Print the lyrics to "99 Bottles of Beer" (See Test 3)
+: Increment the accumulator (What does this do, anyway?)
Any other characters are not valid instructions and will be ignored.

While the language is pretty useless, it can be useful to try to implement it, since doing so means you know how to do all of the above.

Good luck!

Example
For program = "H", the output should be
hq9plus(program) = "hello, world".

Input/Output

[execution time limit] 6 seconds (groovy)

[input] string program

The HQ9+ program.

Guaranteed constraints:
1 ≤ program.length < 15.

[output] string

The output when running the HQ9+ program.
*/

T hq9plus(p) {
    
   p.grep().sum{
     [H:"hello, world",
      Q:p,
      "9":(99..1).sum{i->
            T f = {"${i ?: 99} bottle${ --i ? 's' : ''} of beer"}
            T g = f i
            "$g     n the wall,z$g.\n${i ? "Take    ne d    wn, pass it ar  und" : "G    t   the st re and buy s    me m    re"},z${f i}    n the wall.zz".tr"  z",/o
/
         }[0..-3]
     ][it] ?: ""
    }
}
 