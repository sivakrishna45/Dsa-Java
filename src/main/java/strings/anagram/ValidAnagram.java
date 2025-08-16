package strings.anagram;


/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:
Input: s = "rat", t = "car"
Output: false
*/

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        int[] freq = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int num : freq) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("sivak", "sivas"));
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
