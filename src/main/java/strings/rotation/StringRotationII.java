package strings.rotation;



/*Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.
For example, if s = "abcde", then it will be "bcdea" after one shift.
Examples:
Input : s = "abcde" , goal = "cdeab"
Output : true
Explanation :
After performing 2 shifts we can achieve the goal string from string s.
After first shift the string s is => bcdea
After second shift the string s is => cdeab.*/


import javax.management.MBeanAttributeInfo;

public class StringRotationII {
     public boolean rotateString(String s, String goal) {
            // 1. Lengths must match
            if (s.length() != goal.length()) {
                return false;
            }

            // 2. Empty strings case (both empty → true)
            if (s.length() == 0) {
                return true;
            }

            // 3. Check if goal is a substring of s + s
            String doubled = s + s;
            return doubled.contains(goal);
        }

    public static void main(String[] args) {
        StringRotationII obj = new StringRotationII();
        System.out.println(obj.rotateString("abcde", "cdeab")); // true
        System.out.println(obj.rotateString("abcde", "abced")); // false
    }

}


