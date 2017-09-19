=begin
https://codefights.com/challenge/vFup7mXP4Sdfpx6TY

Imagine that you used time machine to travel to some ancient Kingdom. Unfortunately you got lost, and there are no maps to help you. Luckily you stumbled upon a fancy town, and now while you're waiting for the "time-ship" to get back and rescue you, you have to find a job in the town to earn your living. There is no developer position available in the town, so you decided to work as a cashier in a souvenir shop.

You enjoy working in the shop except for one thing: giving exchange.
Here is the problem: the monetary system is not yet well designed, so the coins the folks use have arbitrary values (unlike in the modern world, where the values of money are only the product of 1, 2 an 5). The shop owner wants you to always deliver "the best customer service", so you have to give exchange to customers with the smallest possible number of coins for their convenience. Moreover, in case there are several ways to do this, you should give change that will have the greatest number of high-value coins in it.

The shop’s owner gives you practically unlimited number of coins of each value. You decide to make the first software ever in the Kingdom and write a program that given the coins values and the change will give a combination of coins that should be given in exchange.

Example

For coins = [2, 3, 4] and change = 6, the output should be
bestCoinsExchange(coins, change) = [[4, 1], [2, 1]].

There are several ways to give change:

2, 2, 2;
3, 3;
4, 2.
The first option shouldn't be considered, since it consists of 3 coins, unlike other options that consist of only 2 coins each.
The third option should be chosen instead of the second one since it contains a coin of value 4, and the largest value of a coin in the second option is only 3.

Input/Output

[time limit] 6000ms (groovy)
[input] array.integer coins

Array of distinct coins, sorted in ascending order.

Constraints:
1 ≤ coins.length ≤ 1000,
1 ≤ coins[i] ≤ 1000.

[input] integer change

The change you need to give back to a customer.

Constraints:
1 ≤ change ≤ 5000.

[output] array.array.integer

The output should contain the coins that should be given to the customer. Each coin should be given in the format [<coin_value>, <number_of_coins>].
The output should be sorted by <coin_value>s in descending order.

It is guaranteed that it's always possible to give the change.
=end

#Note:  This is the first time I've worked on a "dynamic programming"
#challenge. So my commented 526 charecter solution is probably
#not the most elegant one, but I'm just happy that I managed to come up
#with a solution.  I could probably add some elegance and sophistication
#but I've already sunk enough time into thinking about this problem :)
#
#Also, I could probably code-golf this thing down 100 characters or so
#but then it would be unreadable and unuseful to others

def bestCoinsExchange(coins, change)

    #sums is in the format [[coin values], depth]
    #the coin values will be either a real coin
    #or the sum of other coins
    #depth is used to determine how deep in the calculation
    #loop we are. if we have a value for 757 that consists of
    #only 2 coins (depth 1), then we will favor that result
    #in our sums hash over some future result that may use more
    #than 2 coins to arrive at 757

    sums = {}
    for c in coins
        sums[c] = [[c],0]
    end

    depth = 1
    #keep looping till we have a combination of coins equaling
    #the total change
    while sums[change] == nil
        prod = coins.product(sums.keys)
        prod.each{|p|
            sum = p[0] + p[1]
            l = sums[sum]
            #when putting the combination of coins as the answer
            #for a collection of summed values, we will favor
            #the shallower depth (fewer coins) and the larger coin
            #if the depths are equal
            if l == nil || (p[0] > l[0][0] && l[1] >= depth)
                #dont bother storing the sum if it is larger
                #than what we are looking for
                sums[sum] = [p,depth] if sum <= change
            end
        }
        depth += 1
    end

    a = sums[change][0]
    counts = {}
    getCounts(coins, sums, a, counts)
    counts.collect{|k,v| [k,v]}.sort_by{|a| a[0]}.reverse
end

#recursive helper method.
#if a sum is a real count, add it, if its a derived sum
#then get the derived values and recurse
def getCounts (coins, sums, array, hash)
    for a in array
        if coins.include? a
            hash[a] == nil ? hash[a] = 1 : hash[a] += 1
        else
            otherCoins = sums[a][0]
            getCounts(coins, sums, otherCoins, hash)
        end
    end
end
