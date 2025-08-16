package strings;

public class Palindrome {

    public boolean palindromeString(String str) {
        String orgString = str.toLowerCase();
        int start = 0;
        int last = orgString.length() - 1;

        while (start < last) {
            if (orgString.charAt(start) != orgString.charAt(last)) {
                return false;
            }
            start++;
            last--;
        }

        return true;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.palindromeString("Madam"));
        System.out.println(p.palindromeString("Racecar"));
        System.out.println(p.palindromeString("Hello"));
    }
}
