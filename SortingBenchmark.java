import java.util.Random;

/**
 * Benchmarks all three sorting algorithms
 * across different dataset types and sizes.
 */
public class SortingBenchmark {

    static final int[] SIZES = {100, 1000, 10000};
    static final int RUNS = 5;

    public static void main(String[] args) {

        System.out.println("==============================");
        System.out.println("SORTING ALGORITHMS BENCHMARK");
        System.out.println("==============================\n");

        for (int size : SIZES) {
            System.out.println("--- Input Size: " 
                               + size + " ---");
            runTests(size);
            System.out.println();
        }

        System.out.println("==========
                           , "sorted");
        testAlgorithm("Merge",     size, "sorted");
        testAlgorithm("Quick",     size, "sorted");
        System.out.println();
        testAlgorithm("Insertion", size, "reverse");
        testAlgorithm("Merge",     size, "reverse");
        testAlgorithm("Quick",     size, "reverse");
    }

    static void testAlgorithm(String name,
                               int size, String type) {
        double totalTime = 0;
        int comparisons = 0;
        int swaps = 0;

        for (int run = 0; run < RUNS; run++) {
            int[] arr = generateData(size, type);
            long start = System.nanoTime();

            if (name.equals("Insertion")) {
                InsertionSort.sort(arr);
                comparisons = InsertionSort.comparisons;
                swaps = InsertionSort.swaps;
            } else if (name.equals("Merge")) {
                MergeSort.sort(arr);
                comparisons = MergeSort.comparisons;
                swaps = MergeSort.assignments;
            } else {
                QuickSort.sort(arr);
                comparisons = QuickSort.comparisons;
                swaps = QuickSort.swaps;
            }

            long end = System.nanoTime();
            totalTime += (end - start) / 1000000.0;
        }

        double avgTime = totalTime / RUNS;
        System.out.println(type.toUpperCase() + 
            " | " + name + 
            " | Time: " + String.format("%.3f", avgTime) +
            " ms | Comparisons: " + comparisons +
            " | Swaps: " + swaps);
    }

    static int[] generateData(int size, String type) {
        int[] arr = new int[size];
        Random rand = new Random();

        if (type.equals("random")) {
            for (int i = 0; i < size; i++)
                arr[i] = rand.nextInt(size * 10);

        } else if (type.equals("sorted")) {
            for (int i = 0; i < size; i++)
                arr[i] = i;

        } else if (type.equals("reverse")) {
            for (int i = 0; i < size; i++)
                arr[i] = size - i;
        }
        return arr;
    }
                           }
