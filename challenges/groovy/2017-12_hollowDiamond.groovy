/*
https://codefights.com/challenge/tPxKm8LM85F2LXoMS

Given an integer number n, return a Hollow Diamond where:

Use asterisk signs * separated by a space to show the diamond;
The diamond's diagonal must be equals to 2n + 1;
Remove the largest possible square in the middle of the diamond where none of the asterisk signs of the diamond's sides shouldn't be removed;
Instead of the next line, use a space.
Example

(See link for proper images)

For n = 3, the output should be
hollowDiamond(n) =
"      *     * * *   *       * * *       * *   *       *     * * *       *".
which represents:
alt text

For n = 4, the output should be
hollowDiamond(n) =
"        *       * * *     * * * * *   * *       * * * * *       * * *   * *       * *     * * * * *       * * *         *".
which represents:
alt text

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer n

Guaranteed constraints:
0 < n ≤ 160.

[output] string

The requested Hollow Diamond as a string.

*/

T hollowDiamond(n) {
    
    T d = 2*n
    T r = ""
    T i = n % 2 ? n : n - 1
    (0..d).each{
        T o = (n - it).abs()
        T s = d - 2*o + 1
        T p = (s - i) / 2 
        r += "  " * o
        r += o < i/2 ? "* " * p + "  " * i + "* " * p :  "* " * s
    }
    r[0..-2]
    
    
}
