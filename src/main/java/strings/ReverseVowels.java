package strings;

import java.util.Set;

/**
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
Example 1:
Input: s = "IceCreAm"
Output: "AceCreIm"
Explanation:
The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
Example 2:
Input: s = "leetcode"
Output: "leotcede"
*/

public class ReverseVowels {

    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of(
                'a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U');

        char[] chars = s.toCharArray();
        int start = 0;
        int last = chars.length - 1;

        while (start < last) {
            if (!vowels.contains(chars[start])) {
                start++;
            } else if (!vowels.contains(chars[last])) {
                last--;
            } else {
                char temp = chars[start];
                chars[start] = chars[last];
                chars[last] = temp;
                start++;
                last--;
            }
        }

        return new String(chars);
    }

   /* private static final String VOWELS = "aeiouAEIOU";

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {

            if (VOWELS.indexOf(arr[left]) == -1) {          // left is not vowel
                left++;
            }
            else if (VOWELS.indexOf(arr[right]) == -1) {    // right is not vowel
                right--;
            }
            else {                                          // both are vowels → swap
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

        }

        return new String(arr);*/

    public static void main(String[] args) {
        ReverseVowels rv = new ReverseVowels();
        System.out.println(rv.reverseVowels("IceCreAm"));
        System.out.println(rv.reverseVowels("leetcode"));
    }
}

