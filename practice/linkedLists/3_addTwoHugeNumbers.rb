=begin
You're given 2 huge integers represented by linked lists. Each linked list element is a number
from 0 to 9999 that represents a number with exactly 4 digits. The represented number might have
leading zeros. Your task is to add up these huge integers and return the result in the same
format.

Example

For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
addTwoHugeNumbers(a, b) = [9876, 5434, 0].

Explanation: 987654321999 + 18001 = 987654340000.

For a = [123, 4, 5] and b = [100, 100, 100], the output should be
addTwoHugeNumbers(a, b) = [223, 104, 105].

Explanation: 12300040005 + 10001000100 = 22301040105.

Input/Output

[time limit] 4000ms (rb)
[input] linkedlist.integer a

The first number, without its leading zeros.

Guaranteed constraints:
0 ≤ a size ≤ 104,
0 ≤ element value ≤ 9999.

[input] linkedlist.integer b

The second number, without its leading zeros.

Guaranteed constraints:
0 ≤ b size ≤ 104,
0 ≤ element value ≤ 9999.

[output] linkedlist.integer

The result of adding a and b together, returned without leading zeros in the same format.
=end

# Definition for singly-linked list:
# class ListNode
#   attr_accessor :value, :next
#   def initialize(val)
#     @value = val
#     @next = nil
# end
#
def addTwoHugeNumbers(a, b)

   node = nil
   nodeStart = nil
   a = reverse(a)
   b = reverse(b)
   carryover = 0
   while a || b || carryover > 0
      if(node)
         node.next = ListNode.new(0)
         node = node.next
      else
         node = ListNode.new(0)
         nodeStart = node
      end
      sum = a ? a.value : 0
      sum += b ? b.value : 0
      sum += carryover
      result = sum % 10000
      carryover = sum / 10000
      node.value = result
      a = a ? a.next : nil
      b = b ? b.next : nil
   end

   if(nodeStart)
      return reverse(nodeStart)
   else
      return nil
   end
end

def reverse(a)
   n1 = a
   n2 = a.next
   n1.next = nil
   while n1 && n2
      temp = n2.next
      n2.next = n1
      n1 = n2
      n2 = temp
   end
   return n2 ? n2 : n1
end