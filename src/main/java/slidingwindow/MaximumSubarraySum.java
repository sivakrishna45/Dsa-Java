package slidingwindow;


public class MaximumSubarraySum {

    public static long maximumSubArray(int[] arr, int k) {
        if (arr.length < k) return 0;

        int n = arr.length;
        long windowSum = 0;
        int l = 0;
        int r = 0;
        while (r < k) {
            windowSum += arr[r];
            r++;
        }

        long maxSum = windowSum;
        while (r < n-1) {
            windowSum -= arr[l];
            l++;
            r++;
            windowSum += arr[r];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }


    public static void main(String[] args) {
        System.out.println(maximumSubArray(new int[]{2, 45, 56, 6, 4, 2}, 3));

    }
}
