package strings.equivalent;



/**
Two strings word1 and word2 are considered almost equivalent if the differences between the frequencies of each letter from 'a' to 'z' between word1 and word2 is at most 3.
Given two strings word1 and word2, each of length n, return true if word1 and word2 are almost equivalent, or false otherwise.
The frequency of a letter x is the number of times it occurs in the string.
Example 1:
Input: word1 = "aaaa", word2 = "bccb"
Output: false
Explanation: There are 4 'a's in "aaaa" but 0 'a's in "bccb".
The difference is 4, which is more than the allowed 3.
*/

public class CheckAlmostEquivalent {

    public static boolean checkAlmostEquivalent(String word1, String word2) {

        int[] freqWord1 = new int[26];
        int[] freqWord2 = new int[26];

        for (char ch : word1.toCharArray()) {
            freqWord1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freqWord2[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (Math.abs(freqWord1[i] - freqWord2[i]) > 3) {
                {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkAlmostEquivalent("sivan","bdgvd"));
    }
}
