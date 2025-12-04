package arrays;

/*
Given an array of integers and an integer x,
return the index of the first occurrence of x.
If x does not exist, return -1.
*/

public class LinearSearch {

    public static int linearSearch(int[] arr, int x) {

        int n = arr.length;

        // Traverse array from 0 to n-1
        for (int i = 0; i < n; i++) {

            // Check if current element matches x
            if (arr[i] == x) {
                return i;   // return index immediately
            }
        }

        // If not found, return -1
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {4, 6, 0, 1, 6, 8, 1};

        int result = linearSearch(arr, 6);

        System.out.println("Index: " + result);
    }
}
