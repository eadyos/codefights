/*
https://app.codesignal.com/challenge/kjXSxYfm4ZfvdzAs4/solutions/Cj5TgXn4SMszv8S5F

Rick decided to play cards. He had a set of n cards with numbers a1, a2, ... an.

The card sequence is good if there are no 2 neighboring even numbers, there are no 2 neighboring odd numbers. So, the sequence of the numbers should be, for example, like this: odd, even, odd, even, etc. Also the number at the previous card should be strictly less than the number at the next.

Rick carefully shuffled the cards and set to work. We wanted to find the longest sequence of cards that met the conditions. You task is to return the length of such longest sequence.

Example

For cards = [3, 2, 8, 1, 4, 3], the output should be maxCardSequence(cards) = 4.

As the sequence [1, 2, 3, 8] is a good sequence of cards.
Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer cards

The numbers of the cards.

Guaranteed constraints:
1 ≤ cards.length ≤ 105,
1 ≤ cards[i] ≤ 109.

[output] integer

The length of the longest good sequence of cards.

*/

int maxCardSequence(List<Integer> cards) {
    
    cards = cards.sort()
    def odd = cards[0]%2 == 1
    def prevCard = cards[0]
    (0..<cards.size()).count{i->
        if(cards[i] > prevCard){
            def countit = false
            if(odd){
                if(cards[i]%2 == 0){
                    prevCard = cards[i]
                    odd = false
                    countit = true
                }
            }else{
                if(cards[i]%2 == 1){
                    prevCard = cards[i]
                    odd = true
                    countit = true
                }
            }
            countit
        }
    } + 1
  
}
