package sorting;


import java.util.Arrays;


import java.util.Arrays;

/*

Given an array arr, use quick sort to sort arr[] in increasing order.

Quick Sort is a divide-and-conquer algorithm that works by selecting a 'pivot' element
and partitioning the array around it, such that elements smaller than the pivot come before
it and elements greater than the pivot come after it. This process is recursively applied
to the sub-arrays.

Examples :

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: Pick 4 as pivot. Partition array into [1, 3] 4 [9, 7].
Recursively sort left: [1, 3] stays [1, 3].
Recursively sort right: Pick 9 as pivot, partition into [7] 9, result [7, 9].
Final array: [1, 3, 4, 7, 9].

Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Input: arr[] = [38, 31, 20, 14, 30]
Output: [14, 20, 30, 31, 38]
Explanation: Pick 38 as pivot. Partition into [31, 20, 14, 30] 38.
Recursively sort left partition and continue until fully sorted.

*/

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= pivot) {
                i++;
            }
            while (j >= low && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);
        return j;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {4, 6, 1, 2, 8, 2};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
