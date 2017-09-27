/*
https://codefights.com/challenge/Pzr34sXxeFD8QduNb

Given a packet, network and routing rules, determine the final router this packet will be sent to, or -1 if the packet enters an infinite routing loop.

Route selection process

Only consider routing rules which belong to this router
Of those, only consider rules which would transmit using an interface which is actually connected to another interface AND (in order)
The packet destination IP falls within the rule's IP range
if more than one rule matches, select one(s) with highest weight
If more than one rule matches, select one(s) with longest subnet (more precise match)
if more than one rule matches, select the one with the lowest interface ID
(a remaining tie after this point means the rules are duplicates of each other so any one will do)
Once the appropriate routing rule has been identified the packet is sent through the interface designated by this rule and is received by the router on the other end, where the process repeats.

If a router cannot find a routing rule to match the packet, it is considered the packet's final destination, return this router's ID#.

Example of matching an IP to a rule’s IP/Subnet

Packet IP: 192.168.1.5
Rule 1: 192.170.9.0,24
Rule 2: 192.168.1.0,24
Rule 3: 0.0.0.0,0
Step 1: convert each octet from decimal into binary by converting each octet into 8 bits, maintaining leading zeroes.

192 = 11000000
168 = 10101000
1   = 00000001
5   = 00000101
Obtain this IP’s binary value by concatenating these binary numbers:

11000000101010000000000100000101
Similarly convert the rules’ IP:

Rule 1: 11000000101010100000100100000000, 24
Rule 2: 11000000101010000000000100000000, 24
Rule 3: 00000000000000000000000000000000, 0
Now compare the IP to each rule’s IP starting from the most significant bit (leftmost bit), but only up to the number of bits indicated by the subnet mask.
Rule 1 has a subnet mask of 24, the 24 most significant bits of rule 1 are: 110000001010101000001001.
The packet’s IP 24 most significant bits are 110000001010100000000001.
These are different so the rule does not match.

By the same process we find that rule 2 does have the same 24 most significant bits as the packet’s IP, so rule 2 is a match.

Rule 3 is also defined as a match, although there are zero bits to compare it is considered to match by definition. In this scenario you will need to use the specified tie breaking procedure to pick between rules 2 and 3.

A counterpart to rule 3 would be 192.168.1.5,32 which is an exact match for the packet’s IP on all 32 bits.

Example
For
interfaces = [0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5],
network = [4, 20, -1, -1, 0, 9, 21, -1, 12, 5, 22, -1, 8, 17, 23, -1, 24, 13, -1, -1, 1, 6, 10, 14, 16],

routingTable =
["0,192.168.2.0,24,20,1",
 "0,192.168.0.0,16,10,0",
 "0,192.168.3.0,24,20,1",
 "1,192.168.1.0,24,10,6",
 "1,192.168.1.0,24,20,5",
 "1,192.168.1.0,24,15,6",
 "2,192.168.1.0,24,5,10",
 "2,192.168.1.0,26,5,10",
 "2,192.168.1.5,32,5,8",
 "2,192.168.0.0,16,5,10",
 "2,192.168.1.0,29,5,10",
 "3,192.168.1.0,24,10,14",
 "3,192.168.1.0,24,10,13",
 "3,192.168.1.0,24,10,14",
 "4,192.168.1.4,32,10,16",
 "4,192.168.1.8,29,10,16"]
and packet = "0,192.168.1.5",
the output should be
spaghettiNetwork(interfaces, network, routingTable, packet) = 4.
This is what test #1 looks like

[begin] Packet with destination IP 192.168.1.5 starts at router 0
[at router 0] Rule 0, 192.168.0.0, 16, 10, 0 is the only one which matches the packet's IP. Send the packet through interface 0 to interface 4 which is in router 1
[at router 1] All the rules match, but rule 1, 192.168.1.0, 24, 20, 5 wins based on weight. Send the packet through interface 5 to interface 9 which is in router 2
[at router 2] All the rules march, but rule 2, 192.168.1.5, 32, 5, 8 wins based on longest subnet mask (actually this is a precise match for the IP since the subnet is 32). Send the packet through interface 8 to interface 12 which is in router 3
[at router 3] All the rules match, but rule 3, 192.168.1.0, 24, 10, 13 wins based on lowest destination interface. Send the packet through interface 13 to interface 17 which is in router 4
[at router 4] No rule matches, this is the final hop for this packet.
Input/Output

[time limit] 6000ms (groovy)
[input] array.integer interfaces

Interface i belongs to router interfaces[i].

Guaranteed constraints:
6 ≤ interfaces.length ≤ 150,
0 ≤ interfaces[i] < 30.

[input] array.integer network

Interface i is connected to interface network[i], or is not connected if network[i] is -1.

Guaranteed constraints:
network.length = interfaces.length,
-1 ≤ network[i] < interfaces.length.

[input] array.string routingTable

Array of strings representing a list of routing table rules. Each rule is a comma separated list in the format Router#,StartIP,Subnet mask, weight, interface#

Example: 0,192.168.1.0,24,10,1
This represents an entry belonging to router #0, matching IP subnet 192.168.1.0/24 with weight of 10 and output interface #1.

Guaranteed constraints:
3 ≤ routingTable < 200.

[input] string packet

The initial packet being transmitted in the format Router#,DestinationIP
For example 0,192.168.1.5 represents a packet originating from router #0 with the destination of 192.168.1.5.

Guaranteed constraints:
10 < packet.length ≤ 15.

[output] integer

The router ID number of the last router to accept the packet, or -1 if the packet enters an infinite routing loop.
 */

class Rule implements Comparable{
    def router, ip, mask, weight, iface

    int compareTo(Object other) {
        other.weight <=> weight  ?:
                other.mask <=> mask ?:
                        iface <=> other.iface
    }
}

int spaghettiNetwork(interfaces, network, routingTable, packet) {

    packet = packet.split(",")
    def router = packet[0] as int
    def ip = getBinStringFromIp(packet[1])

    def routerRules = routingTable.collect{
        def parts = it.split(",")
        new Rule(router: parts[0] as int,
                ip: getBinStringFromIp(parts[1]),
                mask: parts[2] as int,
                weight: parts[3] as int,
                iface: parts[4] as int)
    }.groupBy{
        it.router
    }

    def visitedRouters = []

    while(true){

        if(router in visitedRouters){
            router = -1
            break
        }
        visitedRouters << router

        def rule = routerRules[router].findAll{
            ip.take(it.mask) == it.ip.take(it.mask) && network[it.iface] >= 0
        }.sort()[0]

        if(!rule){
            break
        }

        router = interfaces[network[rule.iface]]
    }

    router as int
}



def getBinStringFromIp(ip){
    ip.split("\\.").collect{
        Integer.toBinaryString(it as int).padLeft(8,"0")
    }.join()
}
