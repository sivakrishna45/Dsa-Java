package strings;

public class ReverseString {

    public static String reverseString(String str){
        StringBuilder ans = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            ans.append(str.charAt(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("SIVA KESVGV"));
    }
}
