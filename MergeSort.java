/**
 * Merge Sort implementation.
 * Best: O(n log n) | Average: O(n log n) | Worst: O(n log n)
 * Space: O(n) | Stable: Yes | In-Place: No
 */
public class MergeSort {

    public static int comparisons = 0;
    public static int assignments = 0;

    /**
     * Public sort method.
     */
    public static void sort(int[] arr) {
        comparisons = 0;
        assignments = 0;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, 
                                   int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left,
                               int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
            assignments++;
        }

        while (i < n1) { arr[k++] = L[i++]; assignments++; }
        while (j < n2) { arr[k++] = R[j++]; assignments++; }
    }
}
