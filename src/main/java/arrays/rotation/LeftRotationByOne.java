package arrays.rotation;



/*Given an integer array nums, rotate the array to the left by one.
Note: There is no need to return anything, just modify the given array.
Examples:
Input: nums = [1, 2, 3, 4, 5]
Output: [2, 3, 4, 5, 1]
Explanation:
Initially, nums = [1, 2, 3, 4, 5]
Rotating once to left -> nums = [2, 3, 4, 5, 1]
Input: nums = [-1, 0, 3, 6]
Output: [0, 3, 6, -1]
Explanation:
Initially, nums = [-1, 0, 3, 6]
Rotating once to left -> nums = [0, 3, 6, -1]*/


import java.util.Arrays;

public class LeftRotationByOne {

    public static int[] rotateArrayByOne(int[] nums) {
        int n = nums.length;

        // Step 1: store first element
        int first = nums[0];

        // Step 2: shift elements left
        for (int i = 0; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }

        // Step 3: put first element at last
        nums[n - 1] = first;

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 0, 5, 3};
        int[] ans = rotateArrayByOne(arr);

        System.out.println(Arrays.toString(ans));
    }
}
