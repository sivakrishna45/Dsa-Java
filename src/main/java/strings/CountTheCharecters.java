package strings;

public class CountTheCharecters {

    public static int countCharacters(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countCharacters("siga bhgvwd vugwbw "));
    }
}

