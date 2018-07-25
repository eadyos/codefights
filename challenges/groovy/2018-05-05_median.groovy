/*
https://app.codesignal.com/challenge/3MMGKPm4MsbDpes95

You're designing a system in which you have to support the following 3 types of operations:

1 new_value: Insert a new value into the list (which starts empty).
2 old_value new_value: Update an existing value. If there are duplicate values, only update one of them.
3: Print out the median of the list.
Given a list of operations in their chronological order, return the print output (the list of medians).

Note
To simplify things, it is guaranteed that:

For update operations, old_value must exist.
For print operations, the current list must have at least one element.
Example

For ops = ["1 5", "1 15", "3", "1 11", "3"], the output should be median(ops) = [10, 11].
"1 5": Add 5 to list: list = [5].
"1 15": Add 15 to list: list = [5, 15].
"3": Print the median, which is (5 + 15) / 2 = 10 since the list length is even.
"1 11": Add 11 to list: list = [5, 15, 11].
"3": Print the median, which is 11.
For ops = ["1 10", "1 10", "1 15", "2 10 20", "3"], the output should be median(ops) = [15].
"1 10": Add 10 to list: list = [10].
"1 10": Add 10 to list: list = [10, 10].
"1 15": Add 15 to list: list = [10, 10, 15].
"2 10 20": Change a 10 to 20: list = [20, 10, 15].
"3": Print the median, which is 15.
Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.string ops

Operation format:

Insert: 1 new_value
Update: 2 old_value new_value
Print: 3
Guaranteed constraints:
0 ≤ ops.length ≤ 105,
-231 < old_value < 231,
-231 < new_value < 231.

[output] array.float

List of medians

*/

class MedianSet{
    def valCount = new TreeMap()
    int count

    def add(n){
        if(valCount[n])
            valCount[n]++
        else
            valCount[n] = 1

        count++
    }

    def contains(n){
        valCount[n] != null
    }

    def last(){
        valCount.lastEntry().key
    }

    def first(){
        valCount.firstEntry().key
    }

    def removeLast(){
        def key = valCount.lastEntry().key
        remove(key)
        key
    }

    def removeFirst(){
        def key = valCount.firstEntry().key
        remove(key)
        key
    }

    def remove(n){
        valCount[n]--
        if(!valCount[n]){
            valCount.remove(n)
        }
        count--
    }
}

def balance(left, right){
    if(left.count - right.count > 1){
        long last = left.removeLast()
        right.add(last)
    }else if(right.count - left.count > 1){
        long first = right.removeFirst()
        left.add(first)        
    }
}

def getMedian(left, right){
    def count = left.count + right.count
    def m
    //Get the new median
    if (count % 2) {
        if (left.count > right.count) {
            m = left.last()
        } else {
            m = right.first()
        }
    } else if(count) {
        m = (left.last() + right.first()) / 2
    }else{
        m = 0
    }
    m
}

def addVal(left, right, v){
    def m = getMedian(left, right)
    if (v < m) {
        left.add(v)
    } else {
        right.add(v)
    }
    balance(left, right)
}

def removeVal(left, right, v){
    if(left.contains(v)){
        left.remove(v)
    }else{
        right.remove(v)
    }
    balance(left, right)
}

List<Double> median(List<String> ops) {

    def left = new MedianSet()
    def right = new MedianSet()
    def r = []
    ops.each{op->
        def a = op.split()
        def v0 = a[0] as long
        if(v0 == 1) {
            def v1 = a[1] as long
            addVal(left, right, v1)
        }
        else if(v0 == 2){
            def oldV = a[1] as long
            def newV = a[2] as long
            removeVal(left, right, oldV)
            addVal(left, right, newV)
        }
        else{
            r << getMedian(left, right)
        }
    }
    r
}
