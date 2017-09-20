/*
https://codefights.com/arcade/code-arcade/mirror-lake/chW9F8bCgxYJBcgj3

How many strings equal to a can be constructed using letters from the string b? Each letter can be used only once and in one string only.

Example

For a = "abc" and b = "abccba", the output should be
stringsConstruction(a, b) = 2.

We can construct 2 strings a with letters from b.

Input/Output

[time limit] 6000ms (groovy)
[input] string a

String to construct, a contains only lowercase English letters.

Guaranteed constraints:
3 ≤ a.length ≤ 10.

[input] string b

String containing needed letters, b contains only lowercase English letters.

Guaranteed constraints:
3 ≤ b.length ≤ 50.

[output] integer
 */

int stringsConstruction(String a, String b) {


    def count = 0
    def keepGoing = true
    while(keepGoing){
        a.each{
            if(b.indexOf(it) >= 0){
                b -= it
                count++
            }else{
                keepGoing = false
            }
        }
    }
    count / a.size()

}
