/*
https://app.codesignal.com/challenge/pTtnKJKAuMoF9kcG7

Robots are attacking!!!

Fortunately, they aren't programmed very well and they are approaching in a single row, standing abreast of one another.

Also, you happen to have a Red Ryder BB gun (don't shoot your eye out).

Each robot has an armor value > 0.

Your BB gun can do 1 damage to any robot.

When a robot's armor drops below 1. It blows up, doing 2 damage to the robots next to it.

It's up to you to stop the invasion, but... BB ammo is expensive.

Given a list of robot armor values robots, return the number representing the fewest amount of shots needed to destroy all of the robots.

Note: robots[n] = 0 indicates that there is no robot in that position.

Example

For robots = [1, 2], the output should be
robotAttack(robots) = 1.
You shoot robots[0] for 1 damage. It blows up taking out the robot next to it for 2 damage.

For robots = [3, 3, 3], the output should be
robotAttack(robots) = 5.
You shoot robots[0] for 1 damage.
robots: [2, 3, 3]
You shoot robots[1] for 1 damage.
robots: [2, 2, 3]
You shoot robots[2] for 1 damage.
robots: [2, 2, 2]
You shoot robots[0] for 1 damage.
robots: [1, 2, 2]
You shoot robots[0] for 1 damage.
It blows up, doing 2 damage to robots[1].
robots[1] blows up doing 2 damage to robots[2].

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.integer robots

The list representing the armor values of the robots.

Guaranteed constraints:
0 < robots.length ≤ 5 · 104,
0 ≤ robots[i] ≤ 200.

[output] integer

The smallest number of shots required to destroy all the robots.

*/

//Algorithm is pretty simple.  Just shoot the robot with the lowest armor value
//until it blows up.  The code is a bit longer than it may need to be because
//it uses some hashmaps and hashsets to speedup lookups.
int robotAttack(List<Integer> robots) {
    def robotCache = new TreeMap()
    (0..<robots.size()).each{i->
        def r = robots[i]
        if(r){
            def set = robotCache[r]
            if(!set){
                set = new HashSet()
                robotCache[r] = set
            }
            set << i
        }
    }

    int shots = 0
    while(!robotCache.isEmpty()){
        def minValues = robotCache.firstEntry()
        def robotIndex = minValues.value[0]
        def armor = robots[robotIndex]
        shots += armor
        shootRobot(robots, robotIndex, robotCache, armor)
    }
    return shots
}

def shootRobot(robots, robotIndex, robotCache, damage=1){
    def armor = robots[robotIndex]
    def set = robotCache[armor]
    if(set){
        set.remove(robotIndex)
        if(set.isEmpty()){
            robotCache.remove(armor)
        }
    }
    robots[robotIndex] -= damage
    if(robots[robotIndex] > 0){
        set = robotCache[robots[robotIndex]]
        if(!set){
            set = new HashSet()
            robotCache[robots[robotIndex]] = set
        }
        set << robotIndex
    }else if(robots[robotIndex] in [0,-1]){
        if(robotIndex > 0){
            shootRobot(robots, robotIndex - 1, robotCache,2)
        }
        if(robotIndex < robots.size() - 1){
            shootRobot(robots, robotIndex + 1, robotCache, 2)
        }
    }
}