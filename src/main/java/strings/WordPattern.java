package strings;


import java.util.HashMap;
import java.util.Map;

/**
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:
Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.
Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:
The bijection can be established as:
        'a' maps to "dog".
        'b' maps to "cat".
Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
*/

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        String[] words = s.split("\\s+");
        if (pattern.length() != words.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) {
                    return false; // pattern char mapped to different word
                }
            } else {
                charToWord.put(ch, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) {
                    return false;
                }
            } else {
                wordToChar.put(word, ch);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));   // true
        System.out.println(wordPattern("abba", "dog cat cat fish"));  // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));   // false
        System.out.println(wordPattern("abca", "dog cat dog dog"));   // false
    }
}
