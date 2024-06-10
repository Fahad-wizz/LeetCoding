//9. Given an integer x, return true if x is a 
// palindrome
// , and false otherwise.

 

// Example 1:

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.
// Example 2:

// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
// Example 3:

// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

// Constraints:

// -231 <= x <= 231 - 1
 

// Follow up: Could you solve it without converting the integer to a string?
// We can solve this problem without converting the integer to a string.
// We can reverse the number and compare it with the original number.
// If the reversed number is equal to the original number, then the number is a palindrome.
// To reverse the number, we can use the following steps:
// Initialize a variable reverseNumber to 0.
// Initialize a variable temp to the original number.
// Iterate until temp becomes 0:
// Get the last digit of temp by taking the remainder of temp when divided by 10.
// Multiply reverseNumber by 10 and add the last digit to it.
// Divide temp by 10.
// After the iteration, reverseNumber will contain the reversed number.
// Finally, compare the original number with the reversed number. If they are equal, return true; otherwise, return false.

class PalindromeInteger {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long reverseNumber = 0;
        long temp = x;

        while (temp != 0) {
            int digit = (int) (temp % 10);
            reverseNumber = reverseNumber * 10 + digit;
            temp /= 10;
        }

        return (reverseNumber == x);
    }

    public static void main(String[] args) {
        PalindromeInteger pi = new PalindromeInteger();
        System.out.println(pi.isPalindrome(121)); // true
        System.out.println(pi.isPalindrome(-121)); // false
        System.out.println(pi.isPalindrome(10)); // false
        System.out.println(pi.isPalindrome(-101)); // false
    }
}