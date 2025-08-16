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

    public static void main(String[] args) {
        ReverseVowels rv = new ReverseVowels();
        System.out.println(rv.reverseVowels("IceCreAm"));
        System.out.println(rv.reverseVowels("leetcode"));
    }
}

