/**
 * Insertion Sort implementation.
 * Best: O(n) | Average: O(n^2) | Worst: O(n^2)
 * Space: O(1) | Stable: Yes | In-Place: Yes
 */
public class InsertionSort {

    public static int comparisons = 0;
    public static int swaps = 0;

    /**
     * Sorts array in ascending order.
     */
    public static void sort(int[] arr) {
        comparisons = 0;
        swaps = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                swaps++;
                j--;
            }
            comparisons++;
            arr[j + 1] = key;
        }
    }
}
