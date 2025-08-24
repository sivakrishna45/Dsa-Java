package arrays.productOfArrayExceptIfself;


import java.util.Arrays;

/**
 Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

 The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 You must write an algorithm that runs in O(n) time and without using the division operation.

 Example 1:

 Input: nums = [1,2,3,4]
 Output: [24,12,8,6]
 Example 2:

 Input: nums = [-1,1,0,-3,3]
 Output: [0,0,9,0,0]
 */
public class BruteForceProductOfArray {

    public static int[] productOfArrayExceptItself(int[] arr){
        int[] res = new int[arr.length];

        // count zeros
        int zeroCount = 0;
        for (int num : arr) {
            if (num == 0) zeroCount++;
        }

        if (zeroCount > 1) {
            // more than one zero -> all results are zero
            for (int i = 0; i < arr.length; i++) {
                res[i] = 0;
            }
            return res;
        } else {
            // compute product of NON-zero elements
            int product = 1;
            for (int value : arr) {
                if (value != 0) product *= value;
            }

            // fill result
            for (int i = 0; i < arr.length; i++) {
                if (zeroCount == 0) {
                    // no zeros -> safe to divide
                    res[i] = product / arr[i];
                } else {
                    // exactly one zero -> only that index gets product, others 0
                    res[i] = (arr[i] == 0) ? product : 0;
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        int[] nums  = {1, 2, 3, 4};
        int[] nums1 = {0, 3, 4, 5};
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] nums3 = {0, 2, 0, 4};

        System.out.println(Arrays.toString(productOfArrayExceptItself(nums)));   // [24, 12, 8, 6]
        System.out.println(Arrays.toString(productOfArrayExceptItself(nums1)));  // [60, 0, 0, 0]
        System.out.println(Arrays.toString(productOfArrayExceptItself(nums2)));  // [0, 0, 9, 0, 0]
        System.out.println(Arrays.toString(productOfArrayExceptItself(nums3)));  // [0, 0, 0, 0]
    }
}
