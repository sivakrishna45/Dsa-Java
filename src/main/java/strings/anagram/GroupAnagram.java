package strings.anagram;



/*Given an array of strings strs, group the anagrams together. You can return the answer in any order.
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
        Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:
Input: strs = ["a"]
Output: [["a"]]*/


import java.util.*;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (map.containsKey(sorted)) {
                List<String> existingList = map.get(sorted);
                existingList.add(word);
            }
            else{
                List<String> newList = new ArrayList<>();
                newList.add(word);
                map.put(sorted,newList);

            }
        }

        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        GroupAnagram ga = new GroupAnagram();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = ga.groupAnagrams(input);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
