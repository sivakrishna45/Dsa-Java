package strings;


import java.util.HashSet;
import java.util.LinkedHashSet;

/**
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"*/

public class RemoveDuplicateLetters {

    public static  String removeDuplicateLetters(String s) {

        HashSet<Character> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for(Character ch : s.toCharArray()){
            set.add(ch);
        }
        for(Character ch : set){
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("siasjhv"));
    }

}
