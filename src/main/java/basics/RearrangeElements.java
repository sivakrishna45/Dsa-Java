package basics;


/*

You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
You should return the array of nums such that the array follows the given conditions:
Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
Example 1:
Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class RearrangeElements {

    public static int[] rearrangeElementsBrute(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }

        int i = 0, p = 0, q = 0;

        while (i < n) {
            ans[i++] = pos.get(p++);   // place positive
            ans[i++] = neg.get(q++);   // place negative
        }

        return ans;
    }

    public static int[] rearrangeElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int posIdx = 0;
        int negIdx = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[posIdx] = nums[i];
                posIdx += 2;
            } else {
                ans[negIdx] = nums[i];
                negIdx += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};

        int[] brute = rearrangeElementsBrute(arr.clone());
        int[] optimal = rearrangeElements(arr.clone());

        System.out.println("Brute:   " + Arrays.toString(brute));
        System.out.println("Optimal: " + Arrays.toString(optimal));
    }
}
