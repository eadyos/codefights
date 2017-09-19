//https://codefights.com/challenge/pA34fzHCHE9fJMi4F

/*
Sofia really likes the exponentiation of positive integers. She loves to take the numbers of a particular power and arrange them in a table in such a way that the sum of numbers in every row and in every column is the same. She calls this sum the key.

Check out this cute table that Sofia created by placing the fourth powers of positive integers in a 6 × 6 table that has a key equal to 261:

256	1	1	1	1	1
1	81	81	16	1	81
1	81	16	81	1	81
1	1	1	1	256	1
1	81	81	81	1	16
1	16	81	81	1	81
For the given upper bound of the key, the size of the table, and the exponent Sofia would like to use, calculate the number of positive integers that do not exceed the bound that can be used as a key in a table of size size × size that is filled with integers in the power of exponent.

Example

For size = 3, bound = 10, and exponent=2, the output should be
fillByPowers(size, bound, exponent) = 3 .

The possible keys are 3, 6, and 9. Here are the corresponding tables:

1	1	1
1	1	1
1	1	1
1	1	4
4	1	1
1	4	1
4	1	4
4	4	1
1	4	4
Input/Output

[time limit] 4000ms (rb)
[input] integer size

The size of the square table that Sofia wants to fill.

Guaranteed constraints:
2 ≤ size ≤ 15.

[input] integer bound

The upper limit for the key Sofia would like to use.

Guaranteed constraints:
size ≤ bound ≤ 15000.

[input] integer exponent

The exponent that Sofia wants to use to compile her table.

Guaranteed constraints:
2 ≤ exponent ≤ 8.

[output] integer

The number of possible keys that do not exceed the bound and allow Sofia to compile a table of size size × size, using the exact powers of positive integers with the given exponent.
*/

function fillByPowers(s, b, e) {

   c = []
   n = 1
   r = Math.pow(n, e)
   while (r + s - 1 <= b) {
       c.push(r);
       n += 1
       r = Math.pow(n, e)
   }

    h = {1 : c}
    d = 2;
    while (d <= s) {
        a = h[d - 1]
        t = new Set()
        for(i = 0; i < a.length; i++){
            for(j = 0; j < c.length; j++){
                v = a[i] + c[j]
                if(v > b){
                    break
                }else{
                    t.add(v)
                }
            }
        }
        h[d] = [...t]
        d += 1
    }
    return h[s].length
}



