/*
https://codefights.com/challenge/vvoaeAGwQiGmiaQMd

If you're like me (and I suspect a few are) you really like video games. Namely the classics. Well I really like Donkey Kong. Am obsessed actually.
I went as far as to script an enemy randomizer for it in C#. Doing this, I needed the hex codes for all the enemies. Luckily, a dude named Simion32 
uploaded a full list! But this list wasn't QUITE in the format I needed. So I had two options: manual or automated. Stupidly, the first time I did 
this was manually. But as my coding skills developed, it became apparent how I could achieve this.

So now comes the fun part: your task. Your task is to format the list in C# array format, according to the examples.

Example

For
s =
["96D1 = Klaptrap (walking b/f semi-backward)",
 "96E3 = Klaptrap (walking b/f semi-foward)",
 "96F5 = Klaptrap",
 "9703 = Klaptrap"]
the output should be
donkeyKongCountry(s) = "Int32[] klaptrap=new Int32[] {0x96D1,0x96E3,0x96F5,0x9703}".

Key things to note:
-Only the base name matters in the end. No symbols after the name matter. Base names are defined as everything up to first non-alphanumeric other than '-'
-The first 4 characters are the hex code, and are preceded by 0x and separated by commas, enclosed in curly braces.
-"Int32" is part of the syntax and must be included.

For
s =
["97D1 = Purple Klaptrap",
 "97DB = Purple Klaptrap",
 "97F3 = Purple Klaptrap (stationary)"]
the output should be
donkeyKongCountry(s) = "Int32[] klaptrap=new Int32[] {0x97D1,0x97DB,0x97F3}".

Key things to note:
When an enemy consist of two words separated by a space, only the second word matters (in reality, I put a "p" in front of this during the making)

For
s = 
["B86D = Mini-Necky (stationary) (shoot nuts)",
 "B8D5 = Mini-Necky (move upwards) (shoot nuts, very slow)",
 "B8C7 = Mini-Necky (move upwards) (shoot nuts, slow)",
 "B863 = Mini-Necky (move upwards) (shoot nuts)",
 "B88B = Mini-Necky (move upwards) (shoot nuts, slightly faster)",
 "B89F = Mini-Necky (move upwards) (shoot nuts, fast)"]
the output should be
donkeyKongCountry(s) = "Int32[] mini_necky=new Int32[] {0xB86D,0xB8D5,0xB8C7,0xB863,0xB88B,0xB89F}".

Key things to note:

Hyphens are swapped to underscores
Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.string s

An array of enemy objects.

Guaranteed constraints:
2 ≤ s.length < 40.

[output] string

A string of the code to paste in the C# IDE.
*/

T donkeyKongCountry(s) {
    
    "Int32[]${(s =~ /( [\w-]+)+/)[0][1].tr "-Z-A", "_z- "}=new Int32[] {0x${s*.take 4 join ",0x" }}"
}
