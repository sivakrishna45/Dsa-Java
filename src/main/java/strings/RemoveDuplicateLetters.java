package strings;


import java.util.HashSet;
import java.util.LinkedHashSet;

/**
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"*/

public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {

        int[] freq = new int[26];         // frequency of each char
        boolean[] used = new boolean[26]; // char already used?

        // Count occurrences
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int idx = c - 'a';

            // every time we see a char, reduce its remaining count
            freq[idx]--;

            // if it's already used in result, skip it
            if (used[idx]) continue;

            // remove characters that:
            // 1) are lexicographically bigger
            // 2) AND still appear later (freq > 0)
            while (sb.length() > 0 &&
                    sb.charAt(sb.length() - 1) > c &&
                    freq[sb.charAt(sb.length() - 1) - 'a'] > 0) {

                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            // add current char to result
            sb.append(c);
            used[idx] = true;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));      // abc
        System.out.println(removeDuplicateLetters("cbacdcbc"));   // acdb
        System.out.println(removeDuplicateLetters("siasjhv"));    // aijhsv
    }
}
