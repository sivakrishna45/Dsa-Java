package strings.sortCharecter;

import java.util.*;

public class SortCharactersByFrequencyByTreemap {

/*
    Time Complexity
    Operation	Complexity
    Counting (HashMap)	O(n)
    Grouping (TreeMap insertion)	O(k log k)
    Building string	O(n)
    Total O(n + k log k)
    n = total chars, k = unique chars

 */
    public static void main(String[] args) {
        SortCharactersByFrequencyByTreemap sorter = new SortCharactersByFrequencyByTreemap();
        String result = sorter.sortCharacters("tree");
        System.out.println(result); // eert / eetr
    }

    // Method 1: Build TreeMap (frequency → list of characters)
    private TreeMap<Integer, List<Character>> buildFrequencyTreeMap(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Group by frequency in descending order
        TreeMap<Integer, List<Character>> treeMap = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            treeMap.putIfAbsent(freq, new ArrayList<>());
            treeMap.get(freq).add(entry.getKey());
        }

        return treeMap;
    }

    // Method 2: Build final sorted string using TreeMap
    public String sortCharacters(String s) {
        TreeMap<Integer, List<Character>> freqTree = buildFrequencyTreeMap(s);
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, List<Character>> entry : freqTree.entrySet()) {
            int freq = entry.getKey();
            for (char c : entry.getValue()) {
                sb.append(String.valueOf(c).repeat(freq));
            }
        }

        return sb.toString();
    }
}
