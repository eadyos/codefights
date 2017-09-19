/*
https://codefights.com/challenge/NwKe2Qmftj56HJH7T

You are building a piano tuner app that can record audio from a piano, and recognize the frequency of each note! The audio recognition part of the app is already done, so all you need to do is take the frequency and map it to a musical note that can be displayed as text in the app's UI.

Example
For freq = 440, the output should be
tuneUp(freq) = "A".

Input/Output

[time limit] 6000ms (groovy)
[input] float freq

The frequency in Hz of one note on the piano.

Guaranteed constraints:
27.5 ≤ freq < 5000.

[output] string

The musical note that the frequency maps to. ('b' for flat, '#' for sharp)
 */

//This solution required looking up information related to note frequency ranges


def tuneUp(f) {

    "A BbB C C#D EbE F F#G "[
            f = 17.3 * Math.log(f/27) % 12 * 2,
            f + 1
            ] - " "
}

