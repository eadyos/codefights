=begin
Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be
asked to do during an interview.

You are given an n x n 2D matrix that represents an image. Rotate the image
by 90 degrees (clockwise).

Example

For

a = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
the output should be

rotateImage(a) =
    [[7, 4, 1],
     [8, 5, 2],
     [9, 6, 3]]
Input/Output

[time limit] 4000ms (rb)
[input] array.array.integer a

Guaranteed constraints:
1 ≤ a.length ≤ 100,
a[i].length = a.length,
1 ≤ a[i][j] ≤ 104.

[output] array.array.integer

=end

def rotateImage(a)


    centerRingDepth = a.size / 2 - 1
    if(centerRingDepth < 0)
        return a
    end

    (0..centerRingDepth).each{|ringDepth|
        (ringDepth...a.size-ringDepth-1).each{|i|
            tempVal = a[ringDepth][i] #UL
            #BL to UL
            a[ringDepth][i] = a[a.size-1-i][ringDepth]
            #BR to BL
            a[a.size-1-i][ringDepth] = a[a.size-1-ringDepth][a.size-1-i]
            #UR to BR
            a[a.size-1-ringDepth][a.size-1-i] = a[i][a.size-ringDepth-1]
            #UL to UR
            a[i][a.size-ringDepth-1] = tempVal
        }
    }
    a

end
