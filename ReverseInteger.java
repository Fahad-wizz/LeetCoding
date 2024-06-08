//7. Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

// Example 1:

// Input: x = 123
// Output: 321
// Example 2:

// Input: x = -123
// Output: -321
// Example 3:

// Input: x = 120
// Output: 21
 

// Constraints:

// -231 <= x <= 231 - 1 
    
// We have applied the following approach:
// 1. We will take a variable reverse and initialize it to 0.
// 2. We will take a variable temp and initialize it to 0.
// 3. We will run a while loop until x is not equal to 0.
// 4. Inside the while loop, we will calculate the remainder of x by 10 and store it in temp.
// 5. We will check if the reverse is greater than Integer.MAX_VALUE / 10 or reverse is equal to Integer.MAX_VALUE / 10 and temp is greater than 7 or reverse is less than Integer.MIN_VALUE / 10 or reverse is equal to Integer.MIN_VALUE / 10 and temp is less than -8, then we will return 0.
//
// 6. We will multiply reverse by 10 and add temp to it.
// 7. We will divide x by 10.
// 8. We will check if reverse is greater than Integer.MAX_VALUE or reverse is less than Integer.MIN_VALUE, then we will return 0.
// 9. Finally, we will return reverse.
// 10. The time complexity of the solution is O(log(x)).
// 11. The space complexity of the solution is O(1).


class ReverseInteger {
    public int reverse(int x) {
        int reverse = 0;
        int temp;

        while (x != 0) {
            temp = x % 10;
            if (reverse > Integer.MAX_VALUE / 10 || 
    (reverse == Integer.MAX_VALUE / 10 && temp > 7) || 
    reverse < Integer.MIN_VALUE / 10 || 
    (reverse == Integer.MIN_VALUE / 10 && temp < -8)) {
    return 0;
}

            reverse = reverse * 10 + temp;
            x /= 10;

            if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int)reverse;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
        System.out.println(reverseInteger.reverse(-123));
        System.out.println(reverseInteger.reverse(120));
    }
}