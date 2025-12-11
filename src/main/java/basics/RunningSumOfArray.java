package basics;

import java.util.Arrays;


/*
Running Sum of 1d Array
Easy
Topics
premium lock icon
Companies
Hint
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.
Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
*/

public class RunningSumOfArray {

    // Brute Force: O(n^2)
    public static int[] bruteForcerunningSum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += arr[j];
            }
            arr[i] = sum;
        }
        return arr;
    }

    // Optimal: O(n) using prefix sum / sliding window
    public static int[] optimalRunningSum(int[] arr) {
        int runningSum = 0;

        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            arr[i] = runningSum;
        }
        return arr;
    }
    public static int[] easyWayRunningSum(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];  // just add previous running sum
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr1 = {6, 13, 5, 25, 24};
        int[] arr2 = {6, 13, 5, 25, 24};
        int[] arr3 = {6, 13, 5, 25, 24};

        System.out.println("Brute Force:  " + Arrays.toString(bruteForcerunningSum(arr1)));
        System.out.println("Optimal:      " + Arrays.toString(optimalRunningSum(arr2)));
        System.out.println("Easy Way:     " + Arrays.toString(easyWayRunningSum(arr3)));
    }
}
