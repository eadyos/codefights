/*
https://app.codesignal.com/challenge/LfWCaKHdmeCQk6jZP/solutions/RMkzbsHvSxGzuLthf

Reverse challenge.  See link for inputs.

*/

T rowsToCols(r) {
  
    T s = r.size
    T b = r.collect{1.toBinaryString it}
    b = b.collect{it.padLeft s, "0" }
    b = (0..<s).collect{
        1.parseInt b*.getAt(it).join(), 2
    }
    while(b.size < s)
        b.add 0,0
    
    b
    
}
