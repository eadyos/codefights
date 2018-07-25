/*
https://app.codesignal.com/challenge/pcHsPcqKBoiQjJyCx

You're a pretty fast typer - each keystroke takes you 75 milliseconds, but if you're able to use a different hand than the previous key, it only takes you 50.

You use your left hand for the Q, W, E, R, T, A, S, D, F, G, Z, X, C, V, and B keys, and you use your right hand for the Y, U, I, O, P, H, J, K, L, N, and M keys. You can use either hand for the spacebar.

keyboard layout
Note: for the purpose of this challenge, we'll ignore all other keys.

Given a string text, find the shortest time it'll take for you to type it out (in milliseconds). The first keystroke always takes 50ms.

Example

For text = "abc", the output should be alternatingKeys(text) = 200.

The first keystroke always takes 50ms, but since you need to use your left hand again for the b and c keys, each of those keystrokes will take 75ms, for a total of 50 + 75 + 75 = 200.

For text = "land", the output should be alternatingKeys(text) = 200.

Again, the first keystroke will take 50ms, but since each key alternates between your left and right hand, they'll each only take 50ms, for a total of 50 + 50 + 50 + 50 = 200.

*/

int alternatingKeys(text) {
    
    if(!text){
        return 0
    }
    
    def left = "qwertasdfgzxcvb"
    int position = -1
    (0..<text.size()).sum{i->
        int time
        def c = text[i]
        if(c == " "){
            time = 50
            if(position == 0){
                position = 1
            }else if(position == 1){
                position = 0
            }
        }else if(c in left.grep()){
            time = position == 0 ? 75 : 50
            position = 0
        }else{
            time = position == 1 ? 75 : 50
            position = 1
        }
        time = i ? time : 50
    }
    
    
  
}
