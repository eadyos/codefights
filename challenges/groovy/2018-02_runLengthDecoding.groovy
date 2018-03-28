/*
https://codefights.com/challenge/tj3CWdQDETJsp47TZ

Run length encoding is a very common image compression technique. Its procedure is as follows:

The image is scanned every pixel from left to right for every row.
The image is scanned every row of pixels from the top row to the bottom one.
For every group of pixels that are the same continuously, the count of the amount of pixels is marked, then the
 value as a character, if it is not blank / spaces. These values are separated by spaces.
You will be given a string that represents the encoded data. Decode it back into an image (with lines separated
 by the newline character).

Example

For encoded = "5 15 1 # 3 3 # 1 3 # 1 4 # 3 1 # 3 1 # 4 2 # 3 2 # 2 2 # 3 2 # 3 1 # 3 1 # 4 4 # 1 3 # 1 1 # 4 1 # 1", the
output should be
runLengthDecoding(encoded) = "# ### ### ###\n# # # #\n# ## ## #\n# # # #\n### ### # #".
Looks like:

#   ### ### ###
#   #   #    #
#   ##  ##   #
#   #   #    #
### ### #    #
Since the image is height 5 and width 15, there is 1 #, 3 spaces (missing character), 3 more #'s, etc. Only the blank space
 between visible pixels are padded with spaces; the trailing area in lines 2 to 5 have no spaces.

The images are realistically small, and all count of pixels will be between 1 to 9 inclusive.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] string encoded

A string representing the encoded image. It is of the following format:
int:HEIGHT int:WIDTH pixels,
Where pixels is either int:COUNT char:CHAR or only int:COUNT, where COUNT is a one-digit integer and CHAR is length-one and not an integer.

Guaranteed constraints:
0 < HEIGHT, WIDTH < 100,
COUNT < 10,
encoded.length < 4000.

[output] string

A string representing the decoded image. Lines are separated by a new line character only. Blank areas are filled in with 
spaces only if necessary. There are no numbers in the picture.

*/

T runLengthDecoding(e) {
    
    e = e.split()
    T s = " " + e[2..-1].join(" ")
    T t = e[1] as int

    (0..<(e[0] as int)).collect{
        s.replaceAll(/ (\d) (\D)| (\d)/){
            it[3] ? " " * (it[3] as int) : it[2] * (it[1] as int)
        }[it*t..<++it*t].replaceAll("\\s+\$", "")
    }join("\n")
    
}





