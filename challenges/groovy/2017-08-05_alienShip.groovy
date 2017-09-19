/*
https://codefights.com/challenge/HopZBCrp2d4y4rPSK

Immortal aliens from another galaxy invented new spaceship. This spaceship can travel nearly same of speed of light but never exceed it. Some of them travel in that spaceship to find another planet for them.
When they return to home planet, they aged y years.
Suppose they left home planet in 2017, your goal is to find out in which year they will return to home planet.
Speed of spaceship is some fraction of speed of light (v).
Use precision of 10 digits after decimal.

Example
For v = 0.2 and y = 10, the output should be
alienShip(v, y) = 2027.
Aliens travel for 10 years in spaceship with 20% speed of light hence, so they will return to home planet in year 2027.

Input/Output

[time limit] 6000ms (groovy)
[input] float v

v · <speed of light> is velocity of the spaceship.

Guaranteed constraints:
0.01 ≤ v < 1.

[input] integer y

Alien aged when they reach home planet.

Guaranteed constraints:
1 ≤ y ≤ 100.

[output] integer

Year when they return to home planet.
 */

int alienShip(v,y) {

    2017 + y / Math.sqrt(1 - v ** 2).round(10)

}

