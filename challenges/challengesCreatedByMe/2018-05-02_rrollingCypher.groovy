/*
https://app.codesignal.com/challenge/CJEYEbWS7xd4s5oA2

Reverse Challenge.

See link for inputs.

*/

String rrollingCypher(indexes) {
    def lyrics = """We're no strangers to love
    You know the rules and so do I
    A full commitment's what I'm thinking of
    You wouldn't get this from any other guy
    I just wanna tell you how I'm feeling
    Gotta make you understand
    Never gonna give you up
    Never gonna let you down
    Never gonna run around and desert you
    Never gonna make you cry
    Never gonna say goodbye
    Never gonna tell a lie and hurt you"""
        
    def m = lyrics.split("\n").collect{
        it.trim()
    }

    indexes.sum{
        m[it[0]][it[1]]
    }
}
