=begin
https://codefights.com/challenge/dGd57tGyHDa6dK5AF

Given array input_array, your task is to find the longest increasing subsequence in it. The output should contain this subsequence.

If there are several possible answers, return lexicographically smallest one.

Example

For input_array = [24, 12, 15, 15, 19], the output should be
longest_increasing_subsequence(input_array) = [12, 15, 19].

Input/Output

[time limit] 6000ms (groovy)
[input] array.integer input_array

Constraints:
1 ≤ input_array.length ≤ 8000,
1 ≤ input_array[i] ≤ 104.

[output] array.integer
=end

# Node = Struct.new(:val, :back)

def longest_increasing_subsequence n

  pileTops = []
  # sort into piles
  for x in n
    # binary search]
    low, high = 0, pileTops.size-1
    while low <= high
      mid = low + (high - low) / 2
      if pileTops[mid][:val] >= x
        high = mid - 1
      else
        low = mid + 1
      end
    end
    i = low
    node = {:val => x} #Node.new(x)
    node[:back] = pileTops[i-1]  if i > 0
    pileTops[i] = node
  end

  result = []
  node = pileTops.last
  while node
    result.unshift(node)
    node = node[:back]
  end
  result.collect{|r| r[:val]}

end
