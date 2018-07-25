/*
https://app.codesignal.com/challenge/uRQqRdRqdYSYa7Z7N

Hey, you've sent a text on a mobile phone before, right? Well that's technically a text editor, so let's try a challenge based on that!

When typing out a text, you've maybe noticed your keyboard giving suggestions on which word to include next (based on the order you've most frequently typed words in previously).

Sometimes it can be fun to make a total nonsense text by typing in a word, then repeatedly selecting the top next suggestion (and then sending it to your friend with no explanation).

Given a sample of words you've typed in the past, trainingText, and an initial word, firstWord, return an array of length howManyWords, representing the words you'd get by always selecting the top suggestion (beginning with firstWord).

How can you tell which word will be the top suggestion? It's the word that appears after the last one most frequently in trainingText. If there's more than one word that follows the current one most frequently, choose the one that follows it most early on in the text.

If it was the last word of the text, or if it's an unfamiliar word, our predictive text algorithm should suggest the word that appears most frequently overall in the text. If there's no unique most frequent word, choose the one that appears earliest in the text.

Example

For trainingText = "some very repetitive text, very very repetitive text", firstWord = "very", and howManyWords = 10, the output should be predictiveText(trainingText, firstWord, howManyWords) = ["very", "repetitive", "text", "very", "repetitive", "text", "very", "repetitive", "text", "very"].
Input / Output

[execution time limit] 6 seconds (groovy)

[input] string trainingText

A passage of words used to train the predictive text algorithm. The text may contain punctuation, but we'll ignore it (unless it's a word that contains a hyphen or apostrophe). Words are case-sensitive.

Guaranteed constraints:
1 ≤ trainingText.length ≤ 150000

[input] string firstWord

The word we start with before selecting any suggested words. It may be a word that doesn't appear in trainingText, in which case we should suggest the word that appears most frequently in trainingText.

Guaranteed constraints:
1 ≤ firstWord.length ≤ 10

[input] integer howManyWords

How many words to include in the final array

Guaranteed constraints:
1 ≤ howManyWords ≤ 2000

[output] array.string

The nonsense sequence of words that would be produced after selecting every suggested word, beginning with firstWord

*/

def predictiveText(trainingText, firstWord, howManyWords) {

    def text = trainingText =~ /\w(?:[\w-']*\w)?/
    def afterMap = [:]
    def prev
    int position

    def positionMap = [:]
    def wordCounts = [:]
    def countWords = new TreeMap()


    text.each{
        if(positionMap[it] == null){
            positionMap[it] = position++
        }
        def wordCount = wordCounts[it] ?: 0
        if(wordCount){
            def theWords = countWords[wordCount]
            theWords.remove(it)
        }
        wordCount++
        wordCounts[it] = wordCount
        if(!countWords[wordCount]){
            countWords[wordCount] = new HashSet()
        }
        countWords[wordCount] << it

        if(prev){
            def e = afterMap[prev]
            if(!e){
                e = [[:],new TreeMap()]
                afterMap[prev] = e
            }
            def words = e[0]
            def counts = e[1]
            def count = words[it] ?: 0
            if(count){
                counts[count].remove(it)
            }
            count++
            words[it] = count
            if(!counts[count]){
                counts[count] = new HashSet()
            }
            counts[count] << it
        }
        prev = it
    }

    def results = [firstWord]
    howManyWords--
    howManyWords.times{
        def e = afterMap[results.last()]
        def result
        if(e){
            def words = e[0]
            def counts = e[1]
            def candidates = counts.lastEntry().value
            if(candidates.size() == 1){
                result = candidates[0]
            }else{
                result = words.keySet().find{
                    it in candidates
                }
            }
        }else{
            def candidates = countWords.lastEntry().value
            if(candidates.size() == 1){
                result = candidates[0]
            }else{
                result = positionMap.keySet().find{
                    it in candidates
                }
            }
        }
        results << result
    }

    results

}

