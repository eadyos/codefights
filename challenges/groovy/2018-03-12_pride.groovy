/*
https://codefights.com/challenge/PZmFhpKbCp2W4YNcH

This is part of a series of reverse challenges, however it is self-contained and you do not need to
have seen my other reverse challenges to attempt it. For your convenience, the public test cases can be viewed here cleanly.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer n

A positive integer.

Guaranteed constraints:
1 ≤ n ≤ 2^20

[output] array.integer

An array of unique (non-repeating) numbers.



*/

//No time for golf today
List<Integer> pride(int n) {
    
    def result = [n] as Set
    while(n > 10 || n % 2 == 0){
        def m10 = false
        if(n%2 == 0){
            if(n%10 == 0){
                n/=10
                m10 = true
            }else if(n%2 == 0){
                n/=2
            }else{
                if(n < 10000){
                    n += "$n".collect{it as int}.sum()
                }else{
                    n -= "$n".collect{it as int}.sum()
                }
            }
        }else{
            if(n < 10000){
                n += "$n".collect{it as int}.sum()
            }else{
                n -= "$n".collect{it as int}.sum()
            }
        }
        result << n
        if(m10 && n < 10 && n%2){
            n += "$n".collect{it as int}.sum()
            result << n
        }
    }
    
    result as List
  
}
