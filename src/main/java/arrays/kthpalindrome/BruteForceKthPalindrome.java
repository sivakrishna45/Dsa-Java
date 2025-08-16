package arrays.kthpalindrome;


/**
Given an integer array queries and a positive integer intLength,
return an array answer where answer[i] is either the queries[i]th smallest positive palindrome of length intLength or -1 if no such palindrome exists.
A palindrome is a number that reads the same backwards and forwards. Palindromes cannot have leading zeros.
Example 1:

Input: queries = [1,2,3,4,5,90], intLength = 3
Output: [101,111,121,131,141,999]
Explanation:
The first few palindromes of length 3 are:
101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 202, ...
The 90th palindrome of length 3 is 999.
Example 2:

Input: queries = [2,4,6], intLength = 4
Output: [1111,1331,1551]
Explanation:
The first six palindromes of length 4 are:
1001, 1111, 1221, 1331, 1441, and 1551.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//BruteForce
public class BruteForceKthPalindrome {

    public static long[] kthPalindrome(int[] queries, int intLength) {

        List<Integer> palindromList=new ArrayList<>();

        int smallestKthNum = (int) Math.pow(10,intLength-1);
        int largetKthNum = (int) (Math.pow(10,intLength)-1);

        for(int i=smallestKthNum;i<=largetKthNum;i++){
            if(checkPalindrom(i)){
                palindromList.add(i);

            }
        }

        long[] result = new long[queries.length];
        for(int i=0;i<queries.length;i++){
            int k=queries[i];
            if(k<=palindromList.size()){

                result[i] = palindromList.get(k-1);

            }
            else {
                result[i] = -1;
            }
        }

        return result;
    }

    public static boolean checkPalindrom(int num){

        String ansNum= String.valueOf(num);
        int start= 0;
        int end=ansNum.length()-1;

        while(start<end){
            if(ansNum.charAt(start)!=ansNum.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;

    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,4,5,90};
        long[] ans=kthPalindrome(nums1,3);
        System.out.println(Arrays.toString(ans));


    }
}
