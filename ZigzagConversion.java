// 6. (ZIGZAG CONVERSION)The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"

// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string s, int numRows);
 

// Example 1:

// Input: s = "PAYPALISHIRING", numRows = 3
// Output: "PAHNAPLSIIGYIR"
// Example 2:

// Input: s = "PAYPALISHIRING", numRows = 4
// Output: "PINALSIGYAHRPI"
// Explanation:
// P     I    N
// A   L S  I G
// Y A   H R
// P     I
// Example 3:

// Input: s = "A", numRows = 1
// Output: "A"
 

// Constraints:

// 1 <= s.length <= 1000
// s consists of English letters (lower-case and upper-case), ',' and '.'.
// 1 <= numRows <= 1000

// We have used a StringBuilder array to store the characters in the zigzag pattern. We have used a boolean variable to keep track of the direction of the movement of the characters. If the boolean variable is true, we are moving downwards, and if it is false, we are moving upwards. We have used a for loop to iterate through the string and append the characters to the respective StringBuilder. We have used another for loop to append the characters from the StringBuilder array to the result StringBuilder. Finally, we have returned the result as a string.
// the approach is as follows:
// 1. Create a StringBuilder array of size numRows.
// 2. Create a boolean variable to keep track of the direction of the movement of the characters.
// 3. If numRows is 1, return the string as it is.
// 4. Iterate through the string and append the characters to the respective StringBuilder.
// 5. Append the characters from the StringBuilder array to the result StringBuilder.
// 6. Return the result as a string.
// The time complexity of this approach is O(n), where n is the length of the string s.

class ZigzagConversion {
    public String convert(String s, int numRows) {
        StringBuilder sb[] = new StringBuilder[numRows];
        boolean b = true;
        if(numRows == 1){
            return s;
        }

        for(int i =0; i< numRows; i++){
            sb[i] = new StringBuilder();
        }

        for(int i =0 , j=0; i < s.length();){
            sb[j].append(s.charAt(i++));
            if (j== numRows -1){
                b = false;
            }
            if (j == 0){
                b = true;
            }
            if (b){
                j++;
            }else{
                j--;
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringbuilder : sb){
            res.append(stringbuilder);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 3));
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 4));
        System.out.println(zigzagConversion.convert("A", 1));
        System.out.println(zigzagConversion.convert("FAHAD", 2));

    }
}