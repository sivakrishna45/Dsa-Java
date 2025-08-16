package arrays.kthpalindrome;


/**
Given an integer array queries and a positive integer intLength,
return an array answer where answer[i] is either the queries[i]th smallest positive palindrome of length intLength or -1 if no such palindrome exists.
A palindrome is a number that reads the same backwards and forwards. Palindromes cannot have leading zeros.
Example 1:
Input: queries = [1,2,3,4,5,90], intLength = 3
Output: [101,111,121,131,141,999]
Explanation:
The first few palindromes of length 3 are:
101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 202, ...
The 90th palindrome of length 3 is 999.
Example 2:
Input: queries = [2,4,6], intLength = 4
Output: [1111,1331,1551]
Explanation:
The first six palindromes of length 4 are:
1001, 1111, 1221, 1331, 1441, and 1551.
 */


import java.util.Arrays;

public class OptimalKthPalindrome {

    public static long[] kthPalindrome(int[] queries, int intLength) {
        int halfLen = (intLength + 1) / 2;
        long base = (long) Math.pow(10, halfLen - 1);

        long[] result = new long[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long left = base + queries[i] - 1;
            String leftStr = String.valueOf(left);
            StringBuilder right = new StringBuilder(leftStr).reverse();

            if (intLength % 2 == 1) {
                right.deleteCharAt(0);
            }

            String fullPalindrome = leftStr + right;
            if (fullPalindrome.length() != intLength) {
                result[i] = -1;
            } else {
                result[i] = Long.parseLong(fullPalindrome);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] queries1 = {1, 2, 3, 4, 5, 90};
        int intLength1 = 3;
        System.out.println("intLength 3: " + Arrays.toString(kthPalindrome(queries1, intLength1)));

        int[] queries2 = {2, 4, 6};
        int intLength2 = 4;
        System.out.println("intLength 4: " + Arrays.toString(kthPalindrome(queries2, intLength2)));

        int[] queries3 = {1, 2, 3, 10};
        int intLength3 = 2;
        System.out.println("intLength 2: " + Arrays.toString(kthPalindrome(queries3, intLength3)));

        int[] queries4 = {1, 5, 10};
        int intLength4 = 1;
        System.out.println("intLength 1: " + Arrays.toString(kthPalindrome(queries4, intLength4)));
    }
}

