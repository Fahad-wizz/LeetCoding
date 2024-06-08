// 5. Given a string s, return the longest 
// palindromic
 
// substring
//  in s.

 

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"
 

// Constraints:

// 1 <= s.length <= 1000
// s consist of only digits and English letters.
// we have used a recursive approach to find the longest palindromic substring. We start by iterating through the string and expanding around the center of each character. We expand around the center by checking if the characters to the left and right of the center are equal. If they are equal, we continue expanding. If they are not equal, we return the length of the palindromic substring. We keep track of the start and end indices of the longest palindromic substring found so far. We continue this process for each character in the string and return the longest palindromic substring found.

class LongestPalindromicSubstring {
    int start=0,end=0;

    public String longestPalindrome(String s) {
       char chars[]=s.toCharArray();
       getString(chars,0);
       return s.substring(start,end+1);
    }
    public void getString(char[] chars,int i){
        int left=i;
        int right=i;
        int n=chars.length;
        if(i>=n-1) return;
        while(right<n-1 &&chars[right]==chars[right+1]){
            right++;
        }
        i=right;
        while(left>0 && right<n-1 && chars[left-1]==chars[right+1]){
            left--;
            right++;
        }
        if(right-left >end -start){
            end=right;
            start=left;
        }
        getString(chars,i+1);
        
    }
    public static void main(String[] args) {
        LongestPalindromicSubstring lps=new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("babad"));
    }
}