=begin
Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of
elements in l, since this is what you'll be asked to do during an interview.

Given a singly linked list of integers, determine whether or not it's a palindrome.

Example

For l = [0, 1, 0], the output should be
isListPalindrome(l) = true;
For l = [1, 2, 2, 3], the output should be
isListPalindrome(l) = false.
Input/Output

[time limit] 4000ms (rb)
[input] linkedlist.integer l

A singly linked list of integers.

Guaranteed constraints:
0 ≤ list size ≤ 5 · 105,
-109 ≤ element value ≤ 109.

[output] boolean

Return true if l is a palindrome, otherwise return false.
=end

# Definition for singly-linked list:
# class ListNode
#   attr_accessor :value, :next
#   def initialize(val)
#     @value = val
#     @next = nil
# end
#
def isListPalindrome(l)


    if(!l || !l.next)
        return true
    end

    #find list center
    fast = l
    slow = l

    while(fast.next && fast.next.next)
        fast = fast.next.next
        slow = slow.next
    end

    secondHead = slow.next
    slow.next = nil

    #reverse second part of the list
    p1 = secondHead
    p2 = p1.next

    while(p1 && p2)
        temp = p2.next
        p2.next = p1
        p1 = p2
        p2 = temp
    end

    secondHead.next = nil

    #compare two sublists now
    p = p2 ? p2 : p1
    q = l
    while(p)
        if(p.value != q.value)
            return false
        end
        p = p.next
        q = q.next
    end

    true

end
