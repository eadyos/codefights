=begin
https://codefights.com/challenge/xkEsQ3fYxMHwtvFMG

Vanya got an important task — he should enumerate the books in the library and label each book with its number. Each of the n books should be assigned with a number from 1 to n. Naturally, each book should have a unique number.

Vanya wants to know how many digits he will have to write down as he labels the books. Your task is to help him!

Example

For n = 13, the output should be
VanyaAndBook1s(n) = 17.

The books should be labeled with numbers 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, which totals to 17 digits.

Input/Output

[time limit] 6000ms (groovy)
[input] integer n

The number of books in the library.

Constraints:
1 ≤ n ≤ 108.

[output] integer

The number of digits that Vasya needs to write down in order to label all the books.
=end

def VanyaAndBook1s n

    b = 10
    c = 0
    l = 1
    while n > b - 1
        c += (b - (b / 10)) * l
        b *= 10
        l += 1
    end
    c += (n - (b/10) + 1) * l
end
