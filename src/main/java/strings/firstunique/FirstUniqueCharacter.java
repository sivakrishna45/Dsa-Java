package strings.firstunique;


/**
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Example 1:
Input: s = "leetcode"
Output: 0
Explanation:
The character 'l' at index 0 is the first character that does not occur at any other index.
Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
*/

public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        String lowerCase = s.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            int index = lowerCase.charAt(i) - 'a';
            if (index >= 0 && index < 26) {
                freq[index]++;
            }
        }

        for (int i = 0; i < lowerCase.length(); i++) {
            int index = lowerCase.charAt(i) - 'a';
            if (index >= 0 && index < 26 && freq[index] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("sivaaavk"));      // Output: 6
        System.out.println(firstUniqChar("loveleetcode"));  // Output: 2
        System.out.println(firstUniqChar("aabb"));          // Output: -1
    }
}
