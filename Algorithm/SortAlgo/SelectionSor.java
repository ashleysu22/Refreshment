public class SelectionSort {
    // Method to perform selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element in the unsorted part
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method to test selection sort
    public static void main(String[] args) {
        int[] data = {64, 25, 12, 22, 11};
        System.out.println("Original array:");
        printArray(data);

        selectionSort(data);

        System.out.println("Sorted array:");
        printArray(data);
    }
}

//It divides the array into two parts: sorted and unsorted.
//Repeatedly finds the minimum element from the unsorted part and puts it at the beginning.

//Time complexity: O(n²)
