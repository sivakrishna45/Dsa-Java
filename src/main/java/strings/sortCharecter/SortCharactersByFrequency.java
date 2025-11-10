package strings.sortCharecter;

import java.util.*;

public class SortCharactersByFrequency {

/*
    Step	Description	Time	Space
    Count frequencies	= Loop over string =	O(n)	O(k)
    Sort entries	Sorting unique chars	O(k log k)	O(k)
    Build string	Append characters	O(n)	O(n)
    Totat = O(n + k log k)	O(n + k)

    */
    public static void main(String[] args) {
        String s = "tree";
        String result = frequencySort(s);
        System.out.println(result); // eert / eetr
    }

    // Main orchestrator method
    public static String frequencySort(String s) {
        List<Map.Entry<Character, Integer>> sortedEntries = getSortedEntries(s);
        return buildString(sortedEntries);
    }

    // Method 1: Build frequency map and sort entries by frequency (descending)
    private static List<Map.Entry<Character, Integer>> getSortedEntries(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // count frequency
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // convert map → list and sort by frequency desc
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        return list;
    }

    // Method 2: Build final string
    private static String buildString(List<Map.Entry<Character, Integer>> sortedEntries) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedEntries) {
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return sb.toString();
    }

    //Using Stream
   /* public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s)); // eert / eetr
    }

    // Main method orchestrating all steps
    public static String frequencySort(String s) {
        Map<Character, Long> freqMap = buildFrequencyMap(s);
        return buildSortedString(freqMap);
    }

    // Step 1: Count frequency using Streams
    private static Map<Character, Long> buildFrequencyMap(String s) {
        return s.chars()                                    // stream of int chars
                .mapToObj(c -> (char) c)                    // convert to Character
                .collect(Collectors.groupingBy(             // group by character
                        c -> c,                             // key = character
                        Collectors.counting()               // value = frequency (Long)
                ));
    }

    // Step 2: Sort entries and build final string
    private static String buildSortedString(Map<Character, Long> freqMap) {
        return freqMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // sort by freq desc
                .map(entry -> String.valueOf(entry.getKey())
                        .repeat(entry.getValue().intValue()))           // repeat character
                .collect(Collectors.joining());                         // join all parts
    }*/
}

