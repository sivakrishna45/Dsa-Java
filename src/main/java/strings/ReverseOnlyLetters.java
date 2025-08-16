package strings;


/**Given a string s, reverse the string according to the following rules:
All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.
        Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"*/


public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        int left = 0, right = ch.length - 1;

        while (left < right) {
            // Skip non-letters
            if (!Character.isLetter(ch[left])) {
                left++;
            } else if (!Character.isLetter(ch[right])) {
                right--;
            } else {
                // Swap letters
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;

                left++;
                right--;
            }
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));               // dc-ba
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));       // j-Ih-gfE-dCba
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));// Qedo1ct-eeLg=ntse-T!
        System.out.println(reverseOnlyLetters("siva-hs-gdbdh-siva"));  // avsi-hd-hdbdg-ahis
    }
}
