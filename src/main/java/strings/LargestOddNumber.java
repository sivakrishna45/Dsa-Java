package strings;

/*Given a string s, representing a large integer, the task is to return the largest-valued odd integer (as a string) that is a substring of the given string s.
The number returned should not have leading zero's. But the given input string may have leading zero. (If no odd number is found, then return empty string.)
Examples:
Input : s = "5347"
Output : "5347"
Explanation :
The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347.
So the largest among all the possible odd numbers for given string is 5347.*/

public class LargestOddNumber {

    public static String largestOddNumber(String num) {
        // Traverse from the end to find the rightmost odd digit
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(num.charAt(i));
            if (digit % 2 != 0) {
                // Take substring till that odd digit
                String result = num.substring(0, i + 1);
                // Remove leading zeros (Java 8 safe)
                return result.replaceFirst("^0+", "");
            }
        }
        // No odd digit found
        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("35420"));     // 354
        System.out.println(largestOddNumber("4206"));      // ""
        System.out.println(largestOddNumber("123456789")); // 123456789
        System.out.println(largestOddNumber("13579"));     // 13579
        System.out.println(largestOddNumber("024689"));    // ""
        System.out.println(largestOddNumber("0003570"));   // 357
    }
}
