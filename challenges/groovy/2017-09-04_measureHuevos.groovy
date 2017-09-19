/*
https://codefights.com/challenge/yCdzcnbxdRKxyxMwg

This is a reverse challenge, enjoy!

Input/Output

[time limit] 6000ms (groovy)
[input] integer g

Guaranteed constraints:
0 ≤ g ≤ 11000.

[input] string ct

Guaranteed constraints:
ct ∈ ["hd", "d", "bd", "g"].

[output] string

input:
g: 0
ct: "hd"
output: "nope"

input:
g: 213
ct: "hd"
output: "p"

input:
g: 512
ct: "d"
output: "s"

input:
g: 645
ct: "bd"
output: "m"

...see codefights link for a few more examples...
 */

T measureHuevos(g,c) {

    "j xl l m s p nope".split()[
            [70.9, 63.8, 56.7, 49.6, 42.5, 35.4].findIndexOf{
                it <= g / (["d":12, "bd":13, "g":144][c] ?: 6)
            }
    ]
}
