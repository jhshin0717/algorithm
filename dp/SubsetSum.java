/*
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum
Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.

*State : 
    isSubSetSum(n, sum)    

*Expression: 
    current subset 
        -> n excluded:  isSubSetSum(n-1, sum)
        -> n included:  isSubSetSum(n, sum-set[n])    
    isSubSetSum(n, sum) = isSubSetSum(n-1, sum) || isSubSetSum(n, sum-set[n])

*Exit recursive
    if n == 0 && sum > 0 false
    if sum < 0
        false
    if sum == 0
        true

*DP
    dp[n][sum] = true/false;

    for(int i = 0; i <=n; i++) {
       
    }
*/