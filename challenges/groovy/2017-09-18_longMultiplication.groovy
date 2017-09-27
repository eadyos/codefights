/*
https://codefights.com/challenge/kmRFJGXfqpXeF2RLh


Recently there have been several challenges which require the manipulation of very large numbers. If your
favorite language has built-in support for big integers you might not have given this second thought,
therefor in the interest of spreading the joy you will now need to implement multiplication of two integers
the good-old fashioned way.

Now, before you start hatching up a plan to cheat using built-in big integers, for this challenge you
need to return the number of carry operations.

Reminder, calculating a · b

a=123
b=45

First find 123 · 5

11
---
123
  5
---
615
This yields two carry operations

Next find 123 · 4, padding one zero to the right:

  1
----
 123
   4
----
4920
This yields one additional carry

Now sum 615 + 4920

1
----
 615
4920
----
5535
This again yields one carry operation

The total number of carry operations therefore is 4.

Counting carry operations

Although the product does not depend on the order of a and b, for counting carry operations it is important
that you perform a · b and not b · a;
Only count carry operations, the actual amount carried is not important;
First find all the sub multiplication results, then sum them all at once. During the summation each column
can generate 0 or 1 carry operations, for instance a column containing [9, 8, 7] only counts as a single
carry operation even though any two of these numbers would generate a carry operation.
Example
For a = "123" and b = "45", the output should be
longMultiplication(a, b) = 4.

Input/Output

[time limit] 6000ms (groovy)
[input] string a

The first number.

Guaranteed constraints:
1 ≤ a.length < 850.

[input] string b

The second number.

Guaranteed constraints:
1 ≤ a.length < 850.

[output] integer

The number of carry operations performed while multiplying a by b.
 */


T longMultiplication(a, b) {

    int p,t,z
    T c=b.reverse().collect{i->
        b=[]
        (p++).times{ b << 0 }
        z = 0
        a.reverse().each{j->
            T v = (i as int) * (j as int) + z
            b << v % 10
            z = v / 10
            z && t++
        }
        b << z
    }

    z = 0
    t+(0..<c.max{it.size}.size).count{i->
        a = c.sum{ it[i] ?: 0 } + z
        z = a / 10
        z
    }

}
