import java.util.Arrays;

public class MergeSort {

    // MergeSort function
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        if (arr.length < 2) return;  // Base case: array is already sorted

        int mid = arr.length / 2;
        T[] left = Arrays.copyOfRange(arr, 0, mid);  // Left half
        T[] right = Arrays.copyOfRange(arr, mid, arr.length);  // Right half

        mergeSort(left);  // Recursively sort left half
        mergeSort(right);  // Recursively sort right half

        merge(arr, left, right);  // Merge sorted halves
    }

    // Merge two sorted arrays into one
    private static <T extends Comparable<T>> void merge(T[] arr, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i].compareTo(right[j]) <= 0) ? left[i++] : right[j++];
        }

        while (i < left.length) arr[k++] = left[i++];  // Copy remaining left
        while (j < right.length) arr[k++] = right[j++];  // Copy remaining right
    }

    // Print array
    public static <T> void printArray(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Integer[] arr = {33, 10, 55, 71, 21, 89, 15};
        System.out.println("Original Array: ");
        printArray(arr);
        
        mergeSort(arr);  // Sort array using MergeSort
        
        System.out.println("Sorted Array: ");
        printArray(arr);
    }
}

/***
 *Base Case: We exit early if the array has fewer than 2 elements (already sorted).
  Recursion: Split the array into two halves and recursively sort them.
  Merge: We use a single merge method to combine the sorted sub-arrays back together.
  Printing: Using Arrays.toString() for concise and clean array printing

  Best, Average, and Worst Case: O(n log n) for all cases.
  Space Complexity: O(n) due to the need for additional arrays during merging.
  ***/
