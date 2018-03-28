/*
https://codefights.com/challenge/vNtHBZgvByPTjtar4

The city of Berlin used to have a complex pneumatic mail delivery system that transported letters and small packages from one place 
to another through pipes using pressurized air. Your friend, who is a professor of history, dug up a huge pile of drafts that were
never implemented in the actual system. However, for a publication he is working on he needs to know how the endpoints of the system would have been connected. Because the system also had junctions where mail shooting through one pipe would either cross or join into another pipe, compiling this list of coordinates would be too tedious to do manually, so your friend asked you for help.

Given a drawing of the letter shoot system, where an existing piece of pipe is marked with a *, and an empty spot is marked with a .,
 your task is to compile a lexicographically sorted list of index tuples [entry row, entry column, exit row, exit column], where each index is 0-based. Entry and exit points are always on the border of the map. Mail can travel horizontally, vertically and diagonally and will usually maintain its direction, unless it is forced by the pipes to turn into a curve. Only 45 degree turns are possible -- the system is built in such a way that mail capsules will never get stuck.

It is guaranteed that pipes at the entry points have exactly one neighboring pipe, and that that neighbor is not on the same border
as the entry point. It is also guaranteed that mail will eventually reach an exit point.


*/

T airMail(a) {
  
    T s = []
    T l = a.size() - 1
    T w = a[0].size()-1
    for(i in 0..l)
        for(j in 0..w)
            if((i in [0,l] || j in [0,w]) && a[i][j] == "*") s << [i,j]
            
        
    
    s.collect{
        T c = it.clone()
        [it,n(a,c,!c[0] ? 4 : c[0] == l ? 0 : !c[1] ? 2 : 6)].flatten()
    }
}

T n(a,c,d){

    T p = [
        [-1,0], 
        [-1,1], 
        [0,1], 
        [1,1], 
        [1,0], 
        [1,-1], 
        [0,-1], 
        [-1,-1]
    ]
    
    T m = [p[d], p[d-1], p[(d+1)%8]].find{
        T x = c[0]+it[0]
        T y = c[1]+it[1]
        x >=0 && x < a.size() && y >= 0 && y < a[0].size() && a[x][y] == "*"
    }
    if(m){
        c[0] += m[0]
        c[1] += m[1]
        n a,c,p.indexOf(m)
    }else
        c
    
}
