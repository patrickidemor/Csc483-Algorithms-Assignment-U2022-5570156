import java.util.Random;

/**
 * Main program - tests and compares search methods.
 */
public class Main {

    static final int DATASET_SIZE = 100000;
    static final int MAX_ID = 200000;

    public static void main(String[] args) {

        // Step 1: Generate 100,000 random products
        System.out.println("Generating " + DATASET_SIZE + 
                           " products...");
        Product[] products = generateProducts(DATASET_SIZE);

        // Step 2: Sort the array by ID (needed for binary search)
        sortById(products);
        System.out.println("Products sorted. Starting tests...\n");

        // Step 3: Pick test IDs
        int bestCaseId = products[0].getProductId();
        int avgCaseId  = products[DATASET_SIZE / 2].getProductId();
        int worstCaseId = -1; // ID that doesn't exist

        // Step 4: Run tests and print results
        System.out.println("================================");
        System.out.println("TECHMART SEARCH PERFORMANCE");
        System.out.println("n = " + DATASET_SIZE + " products");
        System.out.println("================================\n");

        // Sequential Search Tests
        System.out.println("--- SEQUENTIAL SEARCH ---");
        testSequential(products, bestCaseId, "Best Case");
        testSequential(products, avgCaseId, "Average Case");
        testSequential(products, worstCaseId, "Worst Case");

        System.out.println();

        // Binary Search Tests
        System.out.println("--- BINARY SEARCH ---");
        testBinary(products, bestCaseId, "Best Case");
        testBinary(products, avgCaseId, "Average Case");
        testBinary(products, worstCaseId, "Worst Case");

        System.out.println("\n================================");
        System.out.println("TEST COMPLETE");
        System.out.println("================================");
    }

    // Generates an array of random products
    static Product[] generateProducts(int size) {
        Product[] products = new Product[size];
        Random rand = new Random();
        String[] categories = {"Laptop", "Phone", 
                               "Tablet", "Camera", "TV"};

        for (int i = 0; i < size; i++) {
            int id = rand.nextInt(MAX_ID) + 1;
            String name = "Product" + i;
            String cat = categories[rand.nextInt(5)];
            double price = 10 + (rand.nextDouble() * 990);
            int stock = rand.nextInt(100);
            products[i] = new Product(id, name, cat, 
                                      price, stock);
        }
        return products;
    }

    // Simple bubble sort by product ID
    static void sortById(Product[] products) {
        int n = products.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (products[j].getProductId() > 
                    products[j+1].getProductId()) {
                    Product temp = products[j];
                    products[j] = products[j+1];
                    products[j+1] = temp;
                }
            }
        }
    }

    // Tests sequential search and prints time
    static void testSequential(Product[] products, 
                                int id, String label) {
        long start = System.nanoTime();
        Product result = SearchMethods
                         .sequentialSearchById(products, id);
        long end = System.nanoTime();
        double ms = (end - start) / 1000000.0;
        System.out.println(label + ": " + ms + 
                           " ms | Found: " + 
                           (result != null ? "Yes" : "No"));
    }

    // Tests binary search and prints time
    static void testBinary(Product[] products, 
                            int id, String label) {
        long start = System.nanoTime();
        Product result = SearchMethods
                         .binarySearchById(products, id);
        long end = System.nanoTime();
        double ms = (end - start) / 1000000.0;
        System.out.println(label + ": " + ms + 
                           " ms | Found: " + 
                           (result != null ? "Yes" : "No"));
    }
}
