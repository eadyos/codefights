/*
https://codefights.com/challenge/nQLwdrgCmxmDw7PCC

A linked list is given. The goal is to reverse the list, but unfortunately there are elements that shouldn't be 
moved: every k-th element should be kept where it is, and the rest of the nodes should be reversed. Return the 
changed linked list.

While I can't enforce this, try to not create new nodes but only reuse / move existing nodes.

Example
For list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] and k = 2, the output should be
reverseLinkedListExceptEveryK(list) = [9, 2, 7, 4, 5, 6, 3, 8, 1, 10].
As 2, 4, 6, 8, 10 are fixed and 1, 3, 5, 7, 9 are reversed into 9, 7, 5, 3, 1 in place.

[execution time limit] 6 seconds (groovy)

[input] linkedlist.integer list

A linked list of elements. Elements may repeat.

Guaranteed constraints:
list.length < 1000,
0 ≤ list[i] ≤ 1000.

[input] integer k

The interval of elements to keep in place.

Guaranteed constraints:
0 < k ≤ list.length.

[output] linkedlist.integer

The reversed linked list, except every k index which should correspond to the original list.

Remember that the tail should point to undefined and therefore needs to be unset!~
*/

T reverseLinkedListExceptEveryK(l, k) {
    
    T a = []
    for(;l;l=l.next)
        a << l.value
    
    int i
    l = a.grep{
        ++i % k
    }
    
    i=1
    a.collect{
       i++ % k ? l.pop() : it
    }
    
}
