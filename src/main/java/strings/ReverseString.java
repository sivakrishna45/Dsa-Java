package strings;

public class ReverseString {

    // 1️⃣ Using StringBuilder reverse() – easiest and fastest
    public static String reverseUsingStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // 2️⃣ Using manual loop and concatenation
    public static String reverseUsingLoop(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);  // not efficient for large strings
        }
        return reversed;
    }

    // 3️⃣ Using StringBuilder append (manual loop)
    public static String reverseUsingStringBuilderLoop(String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            ans.append(str.charAt(i));
        }
        return ans.toString();
    }

    // 4️⃣ Using character array (in-place swap)
    public static String reverseUsingCharArray(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    // 5️⃣ Using recursion
    public static String reverseUsingRecursion(String str) {
        if (str == null || str.length() <= 1)
            return str;
        return reverseUsingRecursion(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String input = "SIVA KESVGV";

        System.out.println("Original String: " + input);
        System.out.println("--------------------------------");
        System.out.println("1. Using StringBuilder.reverse(): " + reverseUsingStringBuilder(input));
        System.out.println("2. Using simple loop: " + reverseUsingLoop(input));
        System.out.println("3. Using StringBuilder append loop: " + reverseUsingStringBuilderLoop(input));
        System.out.println("4. Using char array swap: " + reverseUsingCharArray(input));
        System.out.println("5. Using recursion: " + reverseUsingRecursion(input));
    }
}
