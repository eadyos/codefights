/*
https://codefights.com/arcade/intro/level-12/NJJhENpgheFRQbPRA

Given an integer product, find the smallest positive (i.e. greater than 0) integer the product of whose digits is equal to product. If there is no such integer, return -1 instead.

Example

For product = 12, the output should be
digitsProduct(product) = 26;
For product = 19, the output should be
digitsProduct(product) = -1.
Input/Output

[time limit] 6000ms (groovy)
[input] integer product

Guaranteed constraints:
0 ≤ product ≤ 600.

[output] integer
 */


int digitsProduct(int product) {

    if(product == 0){
        return 10
    }

    def originalProduct = product
    def result = [1]
    while(prod(result) != originalProduct){
        def d = (9..2).find{product % it == 0}
        if(d){
            result << d
            product /= d
        }else{
            break
        }
    }
    if(result.size() > 1){
        result.removeAt(0)
    }
    if(prod(result) == originalProduct){
        return result.sort().join().toInteger()
    }else{
        return -1
    }
}

def prod(def vals){
    vals.inject(1){p,v-> p *= v}
}