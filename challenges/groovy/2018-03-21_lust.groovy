/*
https://codefights.com/challenge/ZMPrTLx26uwNgwaRB

This is part of a series of reverse challenges, however it is self-contained and you do not need to have seen my 
other reverse challenges to attempt it. For your convenience, the public test cases can be viewed here cleanly.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.string units

Some strings. They each contain 6 space-separated characters.

Guaranteed constraints:
value.length = 11
value[1] = value[3] = value[5] = value[7] = value[9] = " "

[output] string

A string.

(This one was tedious)


*/

//Code could be a lot more DRY and isn't golfed

def rotate(l){
    l.add(0, l.pop())
}

def srotate(l){
    while(l[0] != l.min()){
        rotate(l)
    }
}

String lust(List<String> strings) {

    def results = []

    strings = strings.collect{[it[0], it[2], it[4], it[6], it[8], it[10]]}

    for(def c in strings){
        int crotations = 0
        while(crotations < 6){
            def units = strings.findAll {!(it in [c])}
            def p0candidates = units.findAll {it.contains(c[0])}
            while(p0candidates) {
                def p0 = p0candidates.pop()
                srotate(p0)
                int p0rotations=0
                while(p0rotations < 6){
                    if(p0[3] == c[0]){
                        units = strings.findAll {!(it in [c,p0])}
                        def p1candidates = units.findAll {u->
                            (0..5).any{n->
                                u[n] == c[1] && u[(n+1)%6] == p0[2]
                            }
                        }
                        while(p1candidates){
                            def p1 = p1candidates.pop()
                            srotate(p1)
                            int p1rotations = 0
                            while(p1rotations < 6){
                                if(p1[4] == c[1] && p1[5] == p0[2]){
                                    units = strings.findAll {!(it in [c,p0,p1])}
                                    def p2candidates = units.findAll {u->
                                        (0..5).any{n->
                                            u[n] == c[2] && u[(n+1)%6] == p1[3]
                                        }
                                    }
                                    while(p2candidates){
                                        def p2 = p2candidates.pop()
                                        srotate(p2)
                                        def p2rotations = 0
                                        while(p2rotations < 6){
                                            if(p2[5] == c[2] && p2[0] == p1[3]){
                                                units = strings.findAll {!(it in [c,p0,p1,p2])}
                                                def p3candidates = units.findAll {u->
                                                    (0..5).any{n->
                                                        u[n] == c[3] && u[(n+1)%6] == p2[4]
                                                    }
                                                }
                                                while(p3candidates){
                                                    def p3 = p3candidates.pop()
                                                    srotate(p3)
                                                    def p3rotations = 0
                                                    while(p3rotations < 6){
                                                        if(p3[0] == c[3] && p3[1] == p2[4]){
                                                            units = strings.findAll {!(it in [c,p0,p1,p2,p3])}
                                                            def p4candidates = units.findAll {u->
                                                                (0..5).any{n->
                                                                    u[n] == c[4] && u[(n+1)%6] == p3[5]
                                                                }
                                                            }
                                                            while(p4candidates){
                                                                def p4 = p4candidates.pop()
                                                                srotate(p4)
                                                                def p4rotations = 0
                                                                while(p4rotations < 6){
                                                                    if(p4[1] == c[4] && p4[2] == p3[5]){
                                                                        units = strings.findAll {!(it in [c,p0,p1,p2,p3,p4])}
                                                                        def p5candidates = units.findAll {u->
                                                                            (0..5).any{n->
                                                                                u[n] == c[5] && u[(n+1)%6] == p4[0]
                                                                            }
                                                                        }
                                                                        if(p5candidates){
                                                                            def p5 = p5candidates.pop()
                                                                            srotate(p5)
                                                                            while(p5[2] != c[5] && p5[3] != p4[0]){
                                                                                rotate(p5)
                                                                            }
                                                                            //now I'm here
                                                                            //solved
                                                                            def result =[c.join(), " ",
                                                                                         strings.indexOf(p4), p4[0], " ",
                                                                                         strings.indexOf(p5), p5[0], " ",
                                                                                         strings.indexOf(p3), p3[0], " ",
                                                                                         strings.indexOf(c), c[0], " ",
                                                                                         strings.indexOf(p0), p0[0], " ",
                                                                                         strings.indexOf(p2), p2[0], " ",
                                                                                         strings.indexOf(p1), p1[0]
                                                                            ].join()
                                                                            results << result
                                                                        }

                                                                    }
                                                                    rotate(p4)
                                                                    p4rotations++
                                                                }
                                                            }
                                                        }
                                                        rotate(p3)
                                                        p3rotations++

                                                    }
                                                }
                                            }
                                            rotate(p2)
                                            p2rotations++
                                        }
                                    }
                                }
                                rotate(p1)
                                p1rotations++
                            }
                        }
                    }
                    rotate(p0)
                    p0rotations++
                }
            }
            rotate(c)
            crotations++
        }
    }
    def r = results.sort()[0]
    println results
    return r[7..-1]
    ""
}

