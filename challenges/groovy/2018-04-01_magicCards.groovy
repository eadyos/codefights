/*
https://app.codesignal.com/challenge/xES3mtZ3s7oTJs7Mf

Yesterday in a bar a wizard performed a card-trick on you:
the wizard has a deck with 27 cards. He shuffles them and asks you for your favourite number between 1 and 27. Then he lets you draw one card and remember it without showing him. He puts it anywhere on the deck and you have to shuffle it. Then he lays down cards from the top of the (face-down) deck in 3 piles of cards(face-up).
He lays the first card on pile 0, the second on pile 1, the third on pile 2, the fourth on pile 0, the fifth on pile 1 and so on until all the cards are distributed. He asks you to show him the pile where your card is in. You notice that he might sort the piles after turning them face-down while putting them back together to one deck (he is just sorting the piles, the order of the cards in the piles remains untouched).
He performs this (piling up 3 equal stacks of face-up cards, letting you show him the pile, turning them face down and rejoining them) 2 more times, and always seems to order the piles in a special way while rejoining the face-down piles.
After the third time he has put the cards together to a deck, he draws cards from the face-down deck until he reaches your favorite number.

There it is, your card at your favorite number. How did he do this? You go home and decide to use your computer and a pack of cards to reveal his foul tricks.

As you watched him you recorded that for fav = 8 the output was [1, 2, 0], meaning that the magician put the pile with your card the first time he rejoined the face-down piles in the middle of the three piles, the second time on the bot and the third time on the top. You tried it at home and it worked! But how is it done?

Example
For fav = 8, the output should be
magicCards(fav) = [1, 2, 0].

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer fav

The favorite number.

Guaranteed constraints:
1 ≤ fav ≤ 27.

[output] array.integer

Return a list containing 3 positions where the magician put the pile your card was in while rejoinung the face down piles in chronological order. 0 stands for the top of the deck, 1 for the middle of the deck and 2 for the bottom of the deck.
*/

T magicCards(f) {
    
    f=f.toString f-1,3
  
    "00$f"[-1..-3]*.toLong()
}
