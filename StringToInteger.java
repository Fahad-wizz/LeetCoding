//8. Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

// The algorithm for myAtoi(string s) is as follows:

// Whitespace: Ignore any leading whitespace (" ").
// Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
// Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
// Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
// Return the integer as the final result.

 

// Example 1:

// Input: s = "42"

// Output: 42

// Explanation:

// The underlined characters are what is read in and the caret is the current reader position.
// Step 1: "42" (no characters read because there is no leading whitespace)
//          ^
// Step 2: "42" (no characters read because there is neither a '-' nor '+')
//          ^
// Step 3: "42" ("42" is read in)
//            ^
// Example 2:

// Input: s = " -042"

// Output: -42

// Explanation:

// Step 1: "   -042" (leading whitespace is read and ignored)
//             ^
// Step 2: "   -042" ('-' is read, so the result should be negative)
//              ^
// Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
//                ^
// Example 3:

// Input: s = "1337c0d3"

// Output: 1337

// Explanation:

// Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
//          ^
// Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
//          ^
// Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
//              ^
// Example 4:

// Input: s = "0-1"

// Output: 0

// Explanation:

// Step 1: "0-1" (no characters read because there is no leading whitespace)
//          ^
// Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
//          ^
// Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
//           ^
// Example 5:

// Input: s = "words and 987"

// Output: 0

// Explanation:

// Reading stops at the first non-digit character 'w'.

 

// Constraints:

// 0 <= s.length <= 200
// s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
// We have applied the following approach:
// 1. We will check if the input string is null or empty, then we will return 0.
// 2. We will trim the input string.
// 3. We will check if the input string is empty, then we will return 0.
// 4. We will take a variable index and initialize it to 0.
// 5. We will take a variable sign and initialize it to 1.
// 6. We will take a variable result and initialize it to 0.
// 7. We will take variables maxInt and minInt and initialize them to Integer.MAX_VALUE and Integer.MIN_VALUE respectively.
// 8. We will check if the character at index is '+' or '-', then we will update the sign accordingly and increment the index.
// 9. We will run a while loop until the index is less than the length of the input string.
// 10. Inside the while loop, we will get the character at the index.
// 11. If the character is not a digit, then we will break the loop.
// 12. We will calculate the digit by subtracting the character by '0'.
// 13. We will check if the result is greater than (maxInt - digit) / 10, then we will return maxInt if the sign is 1, otherwise, we will return minInt.
// 14. We will update the result by multiplying it by 10 and adding the digit to it.
// 15. We will increment the index.
// 16. Finally, we will return the result multiplied by the sign.
// 17. The time complexity of the solution is O(n).
// 18. The space complexity of the solution is O(1).

public class StringToInteger {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
            s = s.trim();
    
        if (s.length() == 0) {
            return 0;
        }
    
        int index = 0;
        int sign = 1;
        int result = 0;
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        
        if (s.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }
            
            int digit = c - '0';
            
            if (result > (maxInt - digit) / 10) {
                return (sign == 1) ? maxInt : minInt;
            }
            
            result = result * 10 + digit;
            index++;
        }
        
        return sign * result;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("42"));
        System.out.println(stringToInteger.myAtoi(" -042"));
        System.out.println(stringToInteger.myAtoi("1337c0d3"));
        System.out.println(stringToInteger.myAtoi("0-1"));
        System.out.println(stringToInteger.myAtoi("words and 987"));
    }
}