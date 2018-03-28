=begin
https://codefights.com/challenge/qc9xeTn6v3wmD7hBF

A group of children stand holding hands in a large circle and a teacher walks around the circle giving 
each child in order a number 1, 2, 3, 4, ...n
circle
If number k is standing opposite number m, how many children are there in the circle?

Example
For k = 1 and m=7, the output should be
circleChildren(k, m) = 12.

Input/Output

[execution time limit] 4 seconds (rb)

[input] integer64 k

k=\{ x \in \mathbb{N}/ 1e14>x \geq 0\}k={x∈N/1e14>x≥0}

[input] integer64 m

m=\{ x \in \mathbb{N}/ 1e14>x \geq 0\}m={x∈N/1e14>x≥0}

[output] integer64

=end

def circleChildren k, m

    (k-m).abs * 2
end
