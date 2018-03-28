/*
https://codefights.com/challenge/mcCTpivdNPvcMySDe


Help!

Somebody is hacking my computer! I don't quite understand what they are doing!! It looks like they got remote shell 
and they are after something!!! What could they want?! :'-(.

-- Bob

This is a reverse challenge. Find out what the hacker is up to and program the remote shell to respond to it.

There is just one secret test (repeated 9 times because of a system constraint).

[execution time limit] 6 seconds (groovy)

[input] array.string cmds

[output] array.string

Example input. (See link for more)

cmds: ["/bin/login_to_nosebook", 
 "demo", 
 "demo"]
Expected Output:
["Nosebook remote login", 
 "Use demo:demo for demo account", 
 "Enter username", 
 "Enter password for user 'demo'", 
 "Welcome 'demo'"]

*/

T remoteShell(i) {

T j = "password"  
T m = "demo"
    
def (a,b,c,d,e,f,g,h,k,l,o) = "Nosebook@Use $m:$m for $m account@Enter username@Enter $j for user@$j will expire soon!@.nosebook@remote login@cyberbob@Your Latergram@-rw-r--r--@'%Welcome '".split("@")
    
T n = "$a $g%$b%$c%$d"

    [
        466: "$n '$m$o$m'",
        877 :"$n 'bob'%Sorry, wrong $j",
        868 : "drwxr-xr-x alice/%drwxrwxrwx bob/",
        219 :"drwxrwxr-x cat_pictures/%-rw------- $f",
        217 : "$f: Permission denied",
        118 : "$l .mail%$l $f",
        86 : "username=$h",
        947 : "# Do NOT save $j here, it is insecure!",
        142 :"$k $e%Bob, protect your $j! Love, mum%Your $a $e%$a: your new $j 'Pa55w0rd' was accepted%$k $e",
        966 :"$n '$h$o$h'"
    ][i.hashCode().abs() % 1000].split("%")

}
