package strings;

/*
Given a string that contains both letters and numbers, write Java code to extract all numbers from the string and return their total sum.
Input:  "abc12def3gh45"
Output: 60
Explanation:
Numbers = [12, 3, 45] → 12 + 3 + 45 = 60
*/


public class SumOfNumbersInString {

    public static int sumNumbersInString(String input) {
        int sum = 0;
        String num = "";

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                num += c; // build the number digit by digit
            } else {
                if (!num.isEmpty()) {
                    sum += Integer.parseInt(num);
                    num = ""; // reset after adding
                }
            }
        }

        // Add the last number if string ends with digit
        if (!num.isEmpty()) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }

    public static void main(String[] args) {
        String input = "abc12def3gh45";
        System.out.println("Sum of numbers: " + sumNumbersInString(input)); // Output: 60
    }
}
