package arrays;



/**
You are given two integers n and t. Return the smallest number greater than or equal to n such that the product of its digits is divisible by t.
Example 1:
Input: n = 10, t = 2
Output: 10
Explanation:
The digit product of 10 is 0, which is divisible by 2, making it the smallest number greater than or equal to 10 that satisfies the condition.
Example 2:
Input: n = 15, t = 3
Output: 16
Explanation:
The digit product of 16 is 6, which is divisible by 3, making it the smallest number greater than or equal to 15 that satisfies the condition.
*/

public class SmallestNumber {

    public static int smallestNumber(int n, int t) {
        int i = n;

        while (true) {
            int productValue = productOfDigits(i);

            if (productValue % t == 0) {
                return i;
            }

            i++;
        }
    }

    public static int productOfDigits(int num) {
        int product = 1;

        while (num > 0) {
            int digit = num % 10;

            if (digit == 0) return 0;

            product *= digit;
            num /= 10;
        }

        return product;
    }

    public static void main(String[] args) {
        System.out.println(smallestNumber(10, 2));
        System.out.println(smallestNumber(15, 3));
    }
}

