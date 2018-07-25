/*
https://app.codesignal.com/challenge/L4QW24zJS42QRbvoc

This week the theme of CODs is the Jobs Platform. If you are in the US and would like to learn more about it or try it out for real go to the Jobs Tab.

Every day we receive many new job applications through the Jobs tab and most users who submit the application have very different backgrounds and skills. In order to properly handle all applications, we have a team of Talent Success Managers (TSM), who personally work with each user to help them through the job search process.

Since the number of applications is quite large, we've built an algorithm for filtering and distributing job applications among TSMs. Here is a simplified version of it that you need to implement as part of this challenge.

You are given the number of TSMs, list of jobApplications, list of availableLocations where our partner companies offer a job, and minimum years of experince that is required for each job (assume it's the same for all jobs). Each jobApplication has several fields username, workExperienceInYears, location.

You need to process jobApplications in the given order and if it satisfies the given constraints assign them to the next TSM through a Round Robin process (cyclic order).

Return an array of TSM assignments of the same length as the jobApplications array where each element in the output array is the number of the TSM (1-based) that would be assigned to the application at that same index in the original jobApplications array. In case if a job application was filtered out due to the constraints, the corresponding array element in the output should be a -1.

Example

For
tsmCount = 3,
availableLocations = ["SF", "NY", "Seattle"],
minExperience = 3, and

jobApplications = ["JohnSmith 4 NY",
                   "John 2 NY",
                   "Frank 4 SF", 
                   "Katy 3 SF",
                   "Michael 3 Washington",
                   "Tom 10 SF"]
the output should be
assignJobApplications(tsmCount, availableLocations, minExperience, jobApplications) = [1, -1, 2, 3, -1, 1].

1st application satisfies constraints (4 > 3 and NY is in the available locations) so it will be assigned to 1st TSM.
2nd application will be filtered because 2 years of experience isn't enough, we need at least 3.
3rd application satisfies constraints (4 > 3 and SF is in the available locations) so it will be assigned to 2nd TSM.
4th one will be assigned to 3rd TSM.
5th one will be filtered.
6th application will be assigned to 1st TSM again, because we assign TSM in cycle.
Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer tsmCount

Guaranteed constraints:
1 ≤ tsmCount ≤ 105.

[input] array.string availableLocations

The array of different locations' names consisting of English letters.

Guaranteed constraints:
1 ≤ availableLocations.length ≤ 105,
1 ≤ availableLocations[i].length ≤ 10.

[input] integer minExperience

Guaranteed constraints:
1 ≤ minExperience ≤ 100.

[input] array.string jobApplications

The array of job applications, each in format username experience location. username and location are words consisting of English letters, and experience is an integer between 1 and 100.

Guaranteed constraints:
1 ≤ jobApplications.length ≤ 105,
5 ≤ jobApplications[i].length ≤ 25.

[output] array.integer

*/

T assignJobApplications(t, l, m, a) {
  
    int c
    l = l.groupBy{it}
    a.collect{
        a = it =~ /\w+/
        (a[1] as int) >= m && l[a[2]] ? c++%t+1 : -1
    }
    
}

