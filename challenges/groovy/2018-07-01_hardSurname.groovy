/*
https://app.codesignal.com/challenge/4PLW8uTndBKB7FghP

World Cup is here! For most people it is one of the greatest events in their lives, but for commentators it is a huge trouble! It is a real challenge for them to pronounce such complicated names that they are dealing with.



Given the surname of a player, determine how hard it is to pronounce. We assume that the difficulty of the surname is the maximum number of consecutive consonants in it.

Example

For surname = "Blaszczykowski", the output should be
hardSurname(surname) = 6;
For surname = "Papastathopoulos", the output should be
hardSurname(surname) = 2.
Input/Output

[execution time limit] 6 seconds (groovy)

[input] string surname

Surname of the player consisting of lowercase Latin letters, starting with an uppercase letter.

Guaranteed constraints:

1 ≤ surname.length ≤ 20.

[output] integer

Difficulty of the surname.

*/

T hardSurname(s) {
    
    (9..0).find{
        s =~ '[^aeiouAU]'*it 
    }
    
}
