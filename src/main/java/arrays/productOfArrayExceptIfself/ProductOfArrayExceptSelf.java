package arrays.productOfArrayExceptIfself;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {


    public static int[] productOfArrayExceptSelf(int[] arr){
        int n = arr.length;
        int[] prefix = new int[n];  // inclusive
        int[] suffix = new int[n];  // inclusive
        int[] res    = new int[n];

        // inclusive prefix: product up to i
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i-1] * arr[i];

        // inclusive suffix: product from i to end
        suffix[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) suffix[i] = suffix[i+1] * arr[i];

        // combine (handle edges)
        for (int i = 0; i < n; i++) {
            res[i] = ((i == 0) ? 1 : prefix[i - 1])
                    * ((i == n - 1) ? 1 : suffix[i + 1]);
        }
        return res;
    }



    public static void main(String[] args) {

        int[] nums  = {1, 2, 3, 4};
        int[] nums1 = {0, 3, 4, 5};
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] nums3 = {0, 2, 0, 4};

        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums)));   // [24, 12, 8, 6]
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums1)));  // [60, 0, 0, 0]
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums2)));  // [0, 0, 9, 0, 0]
        System.out.println(Arrays.toString(productOfArrayExceptSelf(nums3)));  // [0, 0, 0, 0]



    }



}
