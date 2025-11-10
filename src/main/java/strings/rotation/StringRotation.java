package strings.rotation;

public class StringRotation {

    // LEFT rotation
    public static String leftRotate(String s, int k) {
        int n = s.length();
        k = k % n;  // handle large k
        return s.substring(k) + s.substring(0, k);
    }

    // RIGHT rotation
    public static String rightRotate(String s, int k) {
        int n = s.length();
        k = k % n;  // handle large k
        return s.substring(n - k) + s.substring(0, n - k);
    }

    public static void main(String[] args) {
        String s = "abcdef";
        int k = 2;

        System.out.println("Left Rotation:  " + leftRotate(s, k));   // cdefab
        System.out.println("Right Rotation: " + rightRotate(s, k));  // efabcd
    }
}
