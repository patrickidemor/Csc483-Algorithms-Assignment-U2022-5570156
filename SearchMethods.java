/**
 * Contains all search methods for TechMart products.
 */
public class SearchMethods {

    /**
     * Sequential search - checks every product one by one.
     * Works on unsorted arrays.
     */
    public static Product sequentialSearchById(
            Product[] products, int targetId) {

        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return products[i]; // Found it!
            }
        }
        return null; // Not found
    }

    /**
     * Binary search - fast search on SORTED arrays only.
     */
    public static Product binarySearchById(
            Product[] products, int targetId) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) {
                return products[mid]; // Found it!
            } else if (midId < targetId) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return null; // Not found
    }

    /**
     * Sequential search by name - unsorted so must
     * check one by one.
     */
    public static Product searchByName(
            Product[] products, String targetName) {

        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName()
                    .equalsIgnoreCase(targetName)) {
                return products[i]; // Found it!
            }
        }
        return null; // Not found
    }
}
