//10. REGULAR EXPRESSION MATCHING
//  Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

// '.' Matches any single character.​​​​
// '*' Matches zero or more of the preceding element.
// The matching should cover the entire input string (not partial).

 

// Example 1:

// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".
// Example 2:

// Input: s = "aa", p = "a*"
// Output: true
// Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
// Example 3:

// Input: s = "ab", p = ".*"
// Output: true
// Explanation: ".*" means "zero or more (*) of any character (.)".
 

// Constraints:

// 1 <= s.length <= 20
// 1 <= p.length <= 20
// s contains only lowercase English letters.
// p contains only lowercase English letters, '.', and '*'.
// It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.

// THE APPROACH IS TO USE DYNAMIC PROGRAMMING TO SOLVE THE PROBLEM
// THE TIME COMPLEXITY IS O(M*N) WHERE M IS THE LENGTH OF THE STRING AND N IS THE LENGTH OF THE PATTERN
// THE SPACE COMPLEXITY IS O(M*N) WHERE M IS THE LENGTH OF THE STRING AND N IS THE LENGTH OF THE PATTERN
// Approach :- 
// 1. We will create a 2D array of Result type to store the result of the subproblems.
// 2. We will create a helper function dp to solve the problem.
// 3. In the dp function, we will check if the memo[i][j] is not null then we will return the value of the memo[i][j].
// 4. If the j is equal to the length of the pattern then we will check if the i is equal to the length of the text then we will return true else we will return false.
// 5. If the j is not equal to the length of the pattern then we will check if the first_match is true or not.
// 6. If the first_match is true then we will check if the j+1 is less than the length of the pattern and the pattern[j+1] is equal to '*' then we will check if the dp(i, j+2, text, pattern) is true or not.
// 7. If the dp(i, j+2, text, pattern) is true then we will return true else we will check if the first_match is true and dp(i+1, j, text, pattern) is true or not.
// 8. If the first_match is true and dp(i+1, j, text, pattern) is true then we will return true else we will check if the first_match is true and dp(i+1, j+1, text, pattern) is true or not.
// 9. If the first_match is true and dp(i+1, j+1, text, pattern) is true then we will return true else we will return false.
// 10. If the j+1 is not less than the length of the pattern and the pattern[j+1] is not equal to '*' then we will check if the first_match is true or not.
// 11. If the first_match is true then we will check if the dp(i+1, j+1, text, pattern) is true or not.
// 12. If the dp(i+1, j+1, text, pattern) is true then we will return true else we will return false.
// 13. If the first_match is false then we will return false.
// 14. If the j is not equal to the length of the pattern then we will check if the first_match is true or not.
// 15. If the first_match is true then we will check if the dp(i+1, j+1, text, pattern) is true or not.
// 16. If the dp(i+1, j+1, text, pattern) is true then we will return true else we will return false.
// 17. If the first_match is false then we will return false.
// 18. If the j is equal to the length of the pattern then we will check if the i is equal to the length of the text then we will return true else we will return false.
// 19. If the j is not equal to the length of the pattern then we will check if the first_match is true or not.
// 20. If the first_match is true then we will check if the j+1 is less than the length of the pattern and the pattern[j+1] is equal to '*' then we will check if the dp(i, j+2, text, pattern) is true or not.
// 21. If the dp(i, j+2, text, pattern) is true then we will return true else we will check if the first_match is true and dp(i+1, j, text, pattern) is true or not.
// 22. If the first_match is true and dp(i+1, j, text, pattern) is true then we will return true else we will return false.
// 23. If the first_match is false then we will return false.
// 24. If the j+1 is not less than the length of the pattern and the pattern[j+1] is not equal to '*' then we will check if the first_match is true or not.
// 25. If the first_match is true then we will check if the dp(i+1, j+1, text, pattern) is true or not.
// 26. If the dp(i+1, j+1, text, pattern) is true then we will return true else we will return false.
// 27. If the first_match is false then we will return false.
// 28. If the j is equal to the length of the pattern then we will check if the i is equal to the length of the text then we will return true else we will return false.
// 29. If the j is not equal to the length of the pattern then we will check if the first_match is true or not.
// 30. If the first_match is true then we will check if the dp(i+1, j+1, text, pattern) is true or not.
// 31. If the dp(i+1, j+1, text, pattern) is true then we will return true else we will return false.


class RegularExpressionMatching {
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                                   (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                       first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch("aa", "a"));
        System.out.println(regularExpressionMatching.isMatch("bdgdgd", "gdg*"));
    }
}

enum Result {
    TRUE, FALSE
}


// class Solution {
//     public boolean isMatch(String s, String p) {
//         int m = s.length();
//         int n = p.length();

//         boolean[][] dp = new boolean[m + 1][n + 1];
//         dp[0][0] = true;

//         for (int j = 1; j <= n; j++) {
//             if (p.charAt(j - 1) == '*') {
//                 dp[0][j] = dp[0][j - 2];
//             }
//         }

//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 char sChar = s.charAt(i - 1);
//                 char pChar = p.charAt(j - 1);

//                 if (pChar == '.' || pChar == sChar) {
//                     dp[i][j] = dp[i - 1][j - 1];
//                 } else if (pChar == '*') {
//                     dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (sChar == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
//                 }
//             }
//         }

//         return dp[m][n];
//     }
// }