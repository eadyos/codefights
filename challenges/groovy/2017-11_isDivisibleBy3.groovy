/*
https://codefights.com/challenge/WpnhtifjPLiNNC98o

A masked number is a string that consists of digits and one asterisk (*) that should be 
replaced by exactly one digit. Given a masked number find all the possible options to
 replace the asterisk with a digit to produce an integer divisible by 3.

Example

For inputString = "1*0", the output should be
isDivisibleBy3(inputString) = ["120", "150", "180"].

Input/Output

[execution time limit] 6 seconds (groovy)

[input] string inputString

A masked number.

Guaranteed constraints:
1 ≤ inputString.length ≤ 105.

[output] array.string

Sorted array of strings representing all non-negative integers that correspond to the 
given mask and are divisible by 3.
*/


T isDivisibleBy3(s) {
  
//    (0..9).collect{
  //      s.tr "*", "$it"
    //}.grep{(it as BigInteger) % 3 == 0}

    (0..9).each{
        t = s.tr "*", "$it"
        if((t as BigInteger) % 3 == 0)
            a << t
    }
    a
    
}
