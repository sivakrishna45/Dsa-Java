package strings.isomorphic;



/*Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
Examples:
Input : s = "egg" , t = "add"
Output : true
Explanation :
The 'e' in string s can be replaced with 'a' of string t.
The 'g' in string s can be replaced with 'd' of t.
Hence all characters in s can be replaced to get t.*/


import java.util.HashMap;

import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        // Step 1: Lengths must match
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Map to store mappings from s → t
        Map<Character, Character> charMappingMap = new HashMap<>();

        // Step 3: Traverse both strings
        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);      // character from s
            char replacement = t.charAt(i);   // character from t

            // Step 4: If no mapping exists yet
            if (!charMappingMap.containsKey(original)) {
                // If replacement already used for another char — invalid
                if (charMappingMap.containsValue(replacement)) {
                    return false;
                }
                // Otherwise, create new mapping
                charMappingMap.put(original, replacement);
            }
            // Step 5: If mapping exists, verify it’s consistent
            else {
                char mappedCharacter = charMappingMap.get(original);
                if (mappedCharacter != replacement) {
                    return false;
                }
            }
        }

        // Step 6: All checks passed
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));    // true
        System.out.println(isIsomorphic("foo", "bar"));    // false
        System.out.println(isIsomorphic("paper", "title")); // true
        System.out.println(isIsomorphic("badc", "kikp"));   // false
        System.out.println(isIsomorphic("siva", "vcjg"));   // true
    }
}
