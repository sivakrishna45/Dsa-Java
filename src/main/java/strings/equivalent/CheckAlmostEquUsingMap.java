package strings.equivalent;

import java.util.HashMap;

/**
 * Two strings word1 and word2 are considered almost equivalent if the differences between
 * the frequencies of each letter from 'a' to 'z' between word1 and word2 is at most 3.
 *
 * Given two strings word1 and word2, each of length n, return true if word1 and word2
 * are almost equivalent, or false otherwise.
 *
 * Example 1:
 * Input: word1 = "aaaa", word2 = "bccb"
 * Output: false
 * Explanation: There are 4 'a's in "aaaa" but 0 'a's in "bccb". Difference = 4 > 3
 *
 * Example 2:
 * Input: word1 = "abcde", word2 = "bbcde"
 * Output: true
 */
public class CheckAlmostEquUsingMap {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int count1 = map1.getOrDefault(ch, 0);
            int count2 = map2.getOrDefault(ch, 0);
            if (Math.abs(count1 - count2) > 3) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckAlmostEquUsingMap checker = new CheckAlmostEquUsingMap();
        System.out.println("Output: " + checker.checkAlmostEquivalent("aaaa", "bccb"));
        System.out.println("Output: " + checker.checkAlmostEquivalent("abcde", "bbcde"));
        System.out.println("Output: " + checker.checkAlmostEquivalent("sivan", "bdgvd"));
    }
}

