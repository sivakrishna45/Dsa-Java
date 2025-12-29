package basics;
import java.util.Arrays;

/*Given an integer n, return any array containing n unique integers such that they add up to 0.



Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
*/


public class NUniqueIntegersSumUp {

    public int[] sumZero(int n) {
        int[] result = new int[n];
        int num = 1;
        int index = 0;

        if (n % 2 == 1) {
            result[0] = 0;
            index++;
        }

        while (index < n) {
            result[index] = num;
            result[index + 1] = -num;
            index += 2;
            num++;
        }

        return result;
    }

    public static void main(String[] args) {

        NUniqueIntegersSumUp solution = new NUniqueIntegersSumUp();

        int[] result1 = solution.sumZero(5);
        System.out.println("n = 5: " + Arrays.toString(result1));
        System.out.println("Sum: " + Arrays.stream(result1).sum());

        int[] result3 = solution.sumZero(4);
        System.out.println("n = 4: " + Arrays.toString(result3));
        System.out.println("Sum: " + Arrays.stream(result3).sum());
    }
}