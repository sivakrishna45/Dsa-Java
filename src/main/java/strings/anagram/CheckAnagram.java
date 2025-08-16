package strings.anagram;


import java.util.Arrays;

public class CheckAnagram {

    public static boolean checkAnagram(String s1,String s2){

        if(s1.length()!=s2.length()){
            return false;
        }
        else{
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);

            return Arrays.equals(chars1,chars2);

        }
    }

    public static void main(String[] args) {
        System.out.println(checkAnagram("sivakeb","kebsivj"));
    }
}
