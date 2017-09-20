/*
https://codefights.com/arcade/code-arcade/lab-of-transformations/vsKRjYKv4SCjzJc8r

Given two version strings composed of several non-negative decimal fields separated by periods ("."), both strings contain equal number of numeric fields. Return true if the first version is higher than the second version and false otherwise.

The syntax follows the regular semver ordering rules:

1.0.5 < 1.1.0 < 1.1.5 < 1.1.10 < 1.2.0 < 1.2.2
< 1.2.10 < 1.10.2 < 2.0.0 < 10.0.0
There are no leading zeros in any of the numeric fields, i.e. you do not have to handle inputs like 100.020.003 (it would instead be given as 100.20.3).

Example

For ver1 = "1.2.2" and ver2 = "1.2.0", the output should be
higherVersion(ver1, ver2) = true;
For ver1 = "1.0.5" and ver2 = "1.1.0", the output should be
higherVersion(ver1, ver2) = false.
Input/Output

[time limit] 6000ms (groovy)
[input] string ver1

Guaranteed constraints:
1 ≤ ver1.length ≤ 15.

[input] string ver2

Guaranteed constraints:
1 ≤ ver2.length ≤ 15.

[output] boolean
 */

boolean higherVersion(String ver1, String ver2) {

    def ver1Parts = ver1.split("\\.")
    def ver2Parts = ver2.split("\\.")

    int v1 = ver1Parts[0] as int
    int v2 = ver2Parts[0] as int

    if(v1 == v2 && ver1Parts.size() > 1){
        higherVersion(
                ver1Parts[1..-1].join("."),
                ver2Parts[1..-1].join(".")
        )
    }else{
        v1 > v2
    }
}
