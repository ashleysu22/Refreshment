import java.util.ArrayList;
import java.util.Collections;

public class GenericSelectionSort {

    // Generic method to perform selection sort
    public static <T extends Comparable<T>> void selectionSort(ArrayList<T> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            // Swap elements
            Collections.swap(list, i, minIndex);
        }
    }

    // Generic method to print the list
    public static <T> void printList(ArrayList<T> list) {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(29);
        intList.add(10);
        intList.add(14);
        intList.add(37);
        intList.add(13);

        System.out.println("Original Integer List:");
        printList(intList);
        selectionSort(intList);
        System.out.println("Sorted Integer List:");
        printList(intList);

        ArrayList<String> strList = new ArrayList<>();
        strList.add("banana");
        strList.add("apple");
        strList.add("cherry");
        strList.add("date");

        System.out.println("\nOriginal String List:");
        printList(strList);
        selectionSort(strList);
        System.out.println("Sorted String List:");
        printList(strList);
    }
}

//<T extends Comparable<T>>: Restricts the method to types that can be compared (needed for sorting).

//Collections.swap(...): Neat way to swap elements in a list.

//Works for any comparable data type.
