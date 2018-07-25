/*
https://app.codesignal.com/challenge/pFMvFY3BQ683iRvFr

This week the theme of CODs is the Jobs Platform. If you are in the US and would like to learn more about it or try it out for real go to the Jobs Tab.

If you didn't know already, there is a very robust US based job platform on this website. We partner with hundreds of top tier tech companies to help our users get discovered and find their dream job by demonstrating their skills. As part of that, we've built a matching engine that identifies which candidates currently looking for a job are a good match for which jobs from our partner companies. The matching engine takes a lot of attributes into account, but location is one of the trickier ones. Your challenge is to build a highly simplified version of the matching engine limiting the scope to location matching only.

You're given a list of candidate locations in the following form "city, state, country", for example:

San Francisco, California, United States
..., ..., ...
..., ..., ...
Return the number of candidates matching the given job location criteria. The criteria can have one of the following 3 forms:

San Francisco, California, United States - candidates from the given city
California, United States - candidates from the given state
United States - candidates from the given country
Note that there can be multiple cities with the same name in different states, and there can be multiple states with the same name in different countries.

Example

For
locations = ["San Francisco, California, United States",
             "San Mateo, California, United States",
             "Columbia, South Carolina, United States",
             "Columbia, California, United States"]
and criteria = "United States", the output should be jobMatchingScore(locations, criteria) = 4.

All candidate locations match the given criteria (country only).

For
locations = ["San Francisco, California, United States",
             "San Mateo, California, United States",
             "Columbia, South Carolina, United States",
             "Columbia, California, United States"]
and criteria = "Columbia, South Carolina, United States", the output should be jobMatchingScore(locations, criteria) = 1.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.string locations

A list of candidate locations. It is guaranteed that location names doesn't contain commas.

Guaranteed constraints:
1 ≤ locations.length ≤ 104,
7 ≤ locations[i].length ≤ 100.

[input] string criteria

The given job location criteria. It is guaranteed that this criteria follows one of the forms mentioned in the description.

Guaranteed constraints:
1 ≤ criteria.length ≤ 100.

[output] integer

The number of candidate locations that match the given criteria.

*/

T jobMatchingScore(l, c) {

    l.grep ~/(.*, )?$c/ size
    
}
