=begin
https://codefights.com/arcade/code-arcade/spring-of-integration/Hb9Cppx4pCY4d8J5P

Some people run along a straight line in the same direction. They start simultaneously at pairwise
distinct positions and run with constant speed (which may differ from person to person).

If two or more people are at the same point at some moment we call that a meeting. The number
of people gathered at the same point is called meeting cardinality.

For the given starting positions and speeds of runners find the maximum meeting cardinality
assuming that people run infinitely long. If there will be no meetings, return -1 instead.

Example

For startPosition = [1, 4, 2] and speed = [27, 18, 24], the output should be
runnersMeetings(startPosition, speed) = 3.

In 20 seconds after the runners start running, they end up at the same point. Check out the
gif below for better understanding:



Input/Output

[time limit] 4000ms (rb)
[input] array.integer startPosition

A non-empty array of integers representing starting positions of runners (in meters).

Guaranteed constraints:
2 ≤ startPosition.length ≤ 10,
-1000 ≤ startPosition[i] ≤ 1000.

[input] array.integer speed

Array of positive integers of the same length as startPosition representing speeds of the
runners (in meters per minute).

Guaranteed constraints:
speed.length = startPosition.length,
1 ≤ speed[i] ≤ 30.

[output] integer

The maximum meeting cardinality or -1 if there will be no meetings.
=end

def runnersMeetings(startPosition, speed)

    maxCardinality = -1
    count = 1
    while hasMoreMeetings(startPosition, speed)

        (0...startPosition.size).each{|runner|
            metersPerSecond = speed[runner] / 60.0
            startPosition[runner] += metersPerSecond
        }

        cardinality = startPosition.size - 
            startPosition.map{|p| p.round(2)}.uniq.size

        cardinality += cardinality == 0 ? 0 : 1
        if(cardinality > maxCardinality)
            maxCardinality = cardinality
        end
    end
    maxCardinality

end

def hasMoreMeetings(positions, speeds)

    positionOrder = positions.sort.map{|position|
        positions.find_index(position)
    }
    (0...positionOrder.size-1).any?{|index|
        position = positionOrder[index]
        nextPosition = positionOrder[index+1]
        speeds[position] > speeds[nextPosition]
    }

end
