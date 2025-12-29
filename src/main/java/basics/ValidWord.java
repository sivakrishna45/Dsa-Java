package basics;




/*
A word is considered valid if:
It contains a minimum of 3 characters.
It contains only digits (0-9), and English letters (uppercase and lowercase).
It includes at least one vowel.
It includes at least one consonant.
You are given a string word.
Return true if word is valid, otherwise, return false.
Notes:'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
A consonant is an English letter that is not a vowel.
Example 1:
Input: word = "234Adas"
Output: true
Explanation:
This word satisfies the conditions.
Example 2:
Input: word = "b3"
Output: false
Explanation:
The length of this word is fewer than 3, and does not have a vowel.*/


public class ValidWord {

    public static boolean isValid(String word) {

        if (word == null || word.length() < 3) {
            return false;
        }

        int vowelCount = 0;
        int consonantCount = 0;

        for (char c : word.toCharArray()) {

            if (Character.isAlphabetic(c)) {
                if (isVowel(c)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
            else if (Character.isDigit(c)) {
                // digits allowed, do nothing
            }
            else {
                // special character → invalid
                return false;
            }
        }

        return vowelCount >= 1 && consonantCount >= 1;
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        System.out.println(isValid("234Adas"));   // true
        System.out.println(isValid("b3"));        // false
        System.out.println(isValid("a12"));       // false
        System.out.println(isValid("sivakrish6"));// true
    }
}
