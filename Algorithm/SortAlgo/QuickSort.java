public class QuickSort {

    // Method to perform QuickSort
    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively apply quickSort to the left and right sub-arrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Method to partition the array into two halves
    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];  // Choose the rightmost element as pivot
        int i = low - 1;  // Pointer for the smaller element

        for (int j = low; j < high; j++) {
            // If the current element is less than or equal to pivot
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                // Swap arr[i] and arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (the pivot element)
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;  // Return the pivot index
    }

    // Method to print the array
    public static <T> void printArray(T[] arr) {
        for (T item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Main method to test QuickSort
    public static void main(String[] args) {
        Integer[] intArray = {33, 10, 55, 71, 21, 89, 15};
        System.out.println("Original Integer Array:");
        printArray(intArray);

        quickSort(intArray, 0, intArray.length - 1);

        System.out.println("Sorted Integer Array:");
        printArray(intArray);

        String[] strArray = {"banana", "apple", "grape", "kiwi", "orange"};
        System.out.println("\nOriginal String Array:");
        printArray(strArray);

        quickSort(strArray, 0, strArray.length - 1);

        System.out.println("Sorted String Array:");
        printArray(strArray);
    }
}

