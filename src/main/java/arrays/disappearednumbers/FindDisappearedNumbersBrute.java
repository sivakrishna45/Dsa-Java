package arrays.disappearednumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 */

public class FindDisappearedNumbersBrute {

    public static  List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{2, 3, 4, 4, 5}));
    }
}
