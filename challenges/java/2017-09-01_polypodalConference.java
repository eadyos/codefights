/*
https://codefights.com/challenge/fwfwd5fp68qmPoy8h

An international conference of polypodal creatures is organized on the top of the Glass Mountain. The numbers of legs of the 
participants, a1, ... ,an, all are positive even numbers. The side of the Glass Mountain is slippery. Each of the creatures 
gathering at the base of the mountain can only get to the top if they wear special climbing shoes on at least half their feet. 
At least how many shoes are needed altogether to get all participants up to the top if a shoe must always be worn on a foot 
when it travels up or down the mountain?

Example
For legs = [6, 8, 10], the output should be
polypodalConference(legs) = 7.
Let's call these three creatures A, B, C, respectively. A and B can climb up using 3 + 4 = 7 shoes. Then, say, B can carry down all
the shoes (in a few rounds). C can now climb up. A can take the shoes from C and go up and down until all shoes are on the ground again.
Now A and B can both climb up.

Input/Output

[time limit] 6000ms (groovy)
[input] array.integer legs

The array containing the number of legs of the participants.

Guaranteed constraints:
1 ≤ legs.length ≤ 100,
2 ≤ legs[i] ≤ 50,
legs[i] % 2 = 0.

[output] integer

The minimum number of shoes necessary for the ascent.

 */

int PolypodalConference(int[] a) {

        List j = Arrays.asList(a);
        Arrays.sort(a);
        int c=a.length;
        a[0]+= c > 1 ? a[1] : 0;
        Arrays.sort(a);
        return a[c-1]/2;

        }


