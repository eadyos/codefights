/*
https://codefights.com/challenge/8YwGEZD5m4sgkEyJj

coolMachine is similar to universal Alan Turing's machine.
The input is string tape and arrangement of states program.
Each state in program have 5 comma separated values like:
'state,read,write,left/right,next state´.

0,1,0,L,3: State 0, If read 1: write 0, move left, next state 3.
3,0,1,R,4: State 3, If read 0: write 1, move right, next state 4.

Start in state 0, and read first element of tape.
Stop in state 9.
Target: Obtain the tape resulting from the operation of the machine.

Example

For tape = "00010000" and program =
["0,0,0,R,0", "0,1,0,R,1", "1,0,1,R,9"], the output should be
coolMachine(tape, program) = "00001000".

Start in tape[0] = 0 , and state 0, '0,0,0,R,0', write 0, and move right, next state - 0.
Read tape[1] = 0 state is 0, and '0,0,0,R,0', write 0, and move right, next state is 0.
Read tape[2] = 0 state is 0, and '0,0,0,R,0', write 0, and move right, next state is 0.
Read tape[3] = 1 state is 0, and '0,1,0,R,1', write 0, and move right, next state - 1.
Read tape[4] = 0 state is 1, and '1,0,1,R,9', write 1, and move right, next state 9.
State 9 then stop machine.
Input/Output

[execution time limit] 6 seconds (groovy)

[input] string tape

Tape in.

Guaranteed constraints:
1 ≤ tape.length ≤ 10000.

[input] array.string program

Guaranteed constraints:
1 ≤ program.length ≤ 100.

[output] string

Tape out.


*/

T coolMachine(t, p) {

    t = t as List
    T s = 0
    int i
    while(s-9){
        s = p.min{s+t[i] - it[0,2]}
        t[i] = s[4]
        s[6] < 77 ? i-- : i++ 
        s = s[8]
    }    
    t.sum()             
}
