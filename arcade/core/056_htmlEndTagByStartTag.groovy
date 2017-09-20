/*
https://codefights.com/arcade/code-arcade/book-market/MX94DWTrwQw2gLrTi

You are implementing your own HTML editor. To make it more comfortable for developers you would like to add an auto-completion feature to it.

Given the starting HTML tag, find the appropriate end tag which your editor should propose.

If you are not familiar with HTML, consult with this note.

Example

For startTag = "<button type='button' disabled>", the output should be
htmlEndTagByStartTag(startTag) = "</button>";
For startTag = "<i>", the output should be
htmlEndTagByStartTag(startTag) = "</i>".
Input/Output

[time limit] 6000ms (groovy)
[input] string startTag

Guaranteed constraints:
3 ≤ startTag.length ≤ 75.

[output] string
 */

String htmlEndTagByStartTag(String startTag) {

    def m = startTag =~ /<(\w+)/
    "</${m[0][1]}>"
}
