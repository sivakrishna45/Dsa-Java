package arrays;


/**
Leetcode:
        Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2:
        answer[0] contains distinct integers from nums1 not present in nums2.
        answer[1] contains distinct integers from nums2 not present in nums1.
        Note: The integers in the lists may be returned in any order.

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1
and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4
and nums2[2] = 6 are not present in nums1. Therefore, answer[1] = [4,6].
 */


import java.util.*;

public class FindDifference {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }
        for(int n:set1){
            if(!set2.contains(n)){
                list1.add(n);

            }

        }
        for(int n: set2){
            if(!set1.contains(n)){
                list2.add(n);

            }

        }

        return Arrays.asList(list1,list2);

    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};

        List<List<Integer>> ans = findDifference(nums1,nums2);
        System.out.println(ans.toString());



    }


}
