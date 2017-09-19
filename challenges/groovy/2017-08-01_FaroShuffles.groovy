/*
https://codefights.com/challenge/px4JqDBvDPWPAYfdc

A faro shuffle is a method of shuffling playing cards that is often used by gamblers and magicians to manipulate a deck of cards. It works by splitting the deck into equal halves of 26 cards that are then interwoven perfectly.

When 8 faro shuffles are performed consecutively, a deck of 52 cards is always brought back to its original order. Imagine splitting the face-down deck in half, 26 cards in each hand, and slowly interleaving them one after the other in a shuffle, with the bottom card in your right hand hitting the table first and the top card in your left hand on top once the shuffle is complete. Performed 8 times, the deck will return to its original state. Amazingly, this phenomenon works for any even deck size above 8, such that the original order can be restored if enough faro shuffles are done.
For this challenge, you should return the number of faro shuffles required to bring the given deck size back to its original order.

Example
For n = 8, the output should be
faroShuffles(n) = 3.
You have a deck of 8 cards, all of which are face down. Let's call the cards "a", "b", "c", "d", "e", "f", "g", and "h". Take the top half in your left hand and the bottom half in your right. Shuffle such that the new order is: "a", "e", "b", "f", "c", "g", "d", "h". Repeat ("a", "c", "e", "g", "b", "d", "f", "h"), and shuffle a third time to return the deck to its original order.

[time limit] 6000ms (groovy)
[input] integer n

The number of cards in the deck. This is always an even integer.

Guaranteed constraints:
8 ≤ n ≤ 104.

[output] integer

The number of faro shuffles required to return the deck to its original order.
 */


def FaroShuffles={

    int h,a,c
    h = a = it/2
    c = 0
    while(!c++ || a != h){
        a = a < h ? a*2 : 2*(a-h)+1
    }
    c-1
}
