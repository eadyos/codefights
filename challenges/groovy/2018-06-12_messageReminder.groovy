/*
https://app.codesignal.com/challenge/doWA8nkGsjCqeBfBm

This week the theme of CODs is the Jobs Platform. If you are in the US and would like to learn more about it or try it out for real go to the Jobs Tab.

To make sure our users and partner companies get properly connected to each other, we've implemented a message reminder system. So when a partner company reaches out to you and you don't respond for a few days, reminder emails will be sent to you letting you know that you have a pending message. Your goal for this challenge is to implement a simplified version of that message reminder system.

More formally you are given 3 arrays sender, receiver, and date, i-th element of the array shows that sender[i] sent a message to receiver[i] at the moment date[i].
date[i] has the following format yyyy-mm-dd hh:mm:ss (e.g. 2018-02-03 21:00:15). For each non-responded message we need to generate a reminder exactly 2 days (48 hours) after the initial message.

You need to return an array of strings, where each element has the form yyyy-mm-dd hh:mm:ss XXX please respond to YYYs message. The array should be sorted in ascending order of reminder dates.

Example

For sender = ["Asana", "Dropbox", "CodeSignal", "Twitter"], receiver = ["Franko01", "Franko01", "Michael", "John"], and
date = ["2018-02-02 12:23:12", "2018-02-03 10:13:00", "2018-04-02 22:22:22", "2018-02-02 14:30:05"], the output should be

messageReminder(sender, receiver, date) = ["2018-02-04 12:23:12. Franko01 please respond to Asana",
                                           "2018-02-04 14:30:05. John please respond to Twitter",
                                           "2018-02-05 10:13:00. Franko01 please respond to Dropbox",
                                           "2018-04-04 22:22:22. Michael please respond to CodeSignal"]
Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.string sender

The names of the senders.

Guaranteed constraints:
1 ≤ sender.length ≤ 100,
1 ≤ sender[i].length ≤ 10.

[input] array.string receiver

The names of the receivers in respective order.

Guaranteed constraints:
receiver.length = sender.length,
1 ≤ receiver[i].length ≤ 10.

[input] array.string date

The dates of emails in respective order. It is guaranteed that all dates are distinct.

Guaranteed constraints:
date.length = sender.length.

[output] array.string

The reminders in the form yyyy-mm-dd hh:mm:ss XXX please respond to YYYs message.

*/

T messageReminder(s, r, t) {
  
    T f = /yyyy-MM-dd HH:mm:ss/
    T a = []
    int i

    r.sum{
        T d = Date.parse f, t[i]
        a << [d+2, r[i], s[i]]
        a=a.grep{x,y,z->
            y+z != s[i]+r[i] | d > x 
        }
        i++
    }
    
    a.sum{x,y,z->
        [x.format(f) + /. $y please respond to $z/]
    } sort()
    

}
