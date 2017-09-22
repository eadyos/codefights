/*
https://codefights.com/arcade/code-arcade/spring-of-integration/6ceKutpnCs4LzBKgf


Miss X has only two combs in her possession, both of which are old and miss a tooth or two. She also has many purses of
different length, in which she carries the combs. The only way they fit is horizontally and without overlapping. Given teeth'
positions on both combs, find the minimum length of the purse she needs to take them with her.

It is guaranteed that there is at least one tooth at each end of the comb.
It is also guaranteed that the total length of two strings is smaller than 32.
Note, that the combs can not be rotated/reversed.

Example

For comb1 = "*..*" and comb2 = "*.*", the output should be
combs(comb1, comb2) = 5.

Although it is possible to place the combs like on the first picture, the best way to do this is either picture 2 or picture 3.



Input/Output

[time limit] 6000ms (groovy)
[input] string comb1

A comb is represented as a string. If there is an asterisk ('*') in the ith position, there is a tooth there. Otherwise
there is a dot ('.'), which means there is a missing tooth on the comb.

Guaranteed constraints:
1 ≤ comb1.length ≤ 10.

[input] string comb2

The second comb is represented in the same way as the first one.

Guaranteed constraints:
1 ≤ comb2.length ≤ 10.

[output] integer

The minimum length of a purse Miss X needs.

 */

int combs(String comb1, String comb2) {

    comb1 = comb1.replaceAll("\\.", " ")
    comb2 = comb2.replaceAll("\\.", " ")
    comb1 = " " * comb2.size() + comb1 + " " * --comb2.size()

    def rightIndex = comb1.size() - comb2.size()
    def combCombinations = (0..<rightIndex).collect{offset->
        def combined = comb1.split("")
        (0..<comb2.size()).each{i->
            def comb1Index = i + offset
            if(comb2[i] == "*" && comb1[comb1Index] == "*"){
                combined[comb1Index] = "X"
            }else if(comb2[i] == "*"){
                combined[comb1Index] = comb2[i]
            }
        }
        combined.join()
    }

    combCombinations.findAll{
        !it.contains("X")
    }*.trim()*.size().min()
}
