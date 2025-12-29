package arrays.productOfArrayExceptIfself;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productOfArrayExceptSelf(int[] arr) {

        int n = arr.length;

        int[] prefix = new int[n];  // inclusive
        int[] suffix = new int[n];  // inclusive
        int[] res    = new int[n];

        // ---------- Prefix ----------
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i];
        }

        // ---------- Suffix ----------
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i];
        }

        // ---------- Result ----------
        // First element
        res[0] = suffix[1];

        // Middle elements
        for (int i = 1; i < n - 1; i++) {
            res[i] = prefix[i - 1] * suffix[i + 1];
        }

        // Last element
        res[n - 1] = prefix[n - 2];

        return res;
    }

    public static void main(String[] args) {

        int[] nums  = {1, 2, 3, 4};
        int[] nums1 = {0, 3, 4, 5};
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] nums3 = {0, 2, 0, 4};

        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums)));
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums1)));
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums2)));
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums3)));
    }
}
