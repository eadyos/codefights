/*
https://codefights.com/challenge/dNKLPGwENpZPYbvDp

This is a reverse challenge, enjoy!

Input/Output

[time limit] 6000ms (groovy)
[input] string s

Guaranteed constraints:
0 ≤ s.length < 200.

[output] string

input "a"
output "21

input "ab"
output "2122"

input "aa"
output "221"

input "hello world"
output "423225363019163735331"

input "hacker"
output "422123523273"

input "code fights"
output "2363313201334341428174"
 */

T texting(s,l=""" 

abc
def
ghi
jkl
mno
pqrs
tuv
wxyz""".split("\n")) {

    s.inject([]){a,c->
        def i = l.findIndexOf({it.contains(c)}), v =  "$i${l[i].trim().indexOf(c) + 1}"
        c == ' ' && (v = '01')
        if(a && a[-1] == v){
            if(a.size() > 1 && a[-2] instanceof Integer)
                a[-2]++
            else
                a.add(a.size -1, 2)
        }else
            a << v
        a
    }.join()
}
