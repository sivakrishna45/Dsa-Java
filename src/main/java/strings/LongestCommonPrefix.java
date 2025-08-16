package strings;

import java.util.Arrays;


/**
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.*/

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length - 1];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.min(start.length(), end.length()); i++) {
            if (start.charAt(i) == end.charAt(i)) {
                result.append(start.charAt(i));
            } else {
                break;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{}));
    }
}
