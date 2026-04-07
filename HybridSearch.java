import java.util.HashMap;

/**
 * Hybrid search using HashMap for fast name lookups.
 */
public class HybridSearch {

    // HashMap index for name-based searching
    private HashMap<String, Product> nameIndex;
    private Product[] products;
    private int size;

    /**
     * Constructor - builds the name index.
     */
    public HybridSearch(Product[] products, int size) {
        this.products = products;
        this.size = size;
        nameIndex = new HashMap<>();
        for (int i = 0; i < size; i++) {
            nameIndex.put(
                products[i].getProductName()
                           .toLowerCase(),
                products[i]
            );
        }
    }

    /**
     * Fast name search using HashMap - O(1) average.
     */
    public Product searchByName(String name) {
        return nameIndex.get(name.toLowerCase());
    }

    /**
     * Adds a product and maintains sorted order.
     * Also updates the name index.
     */
    public void addProduct(Product newProduct) {
        // Add to name index
        nameIndex.put(
            newProduct.getProductName().toLowerCase(),
            newProduct
        );

        // Insert into sorted position
        int i = size - 1;
        while (i >= 0 && products[i].getProductId()
               > newProduct.getProductId()) {
            products[i + 1] = products[i];
            i--;
        }
        products[i + 1] = newProduct;
        size++;
    }

    /**
     * Returns current size of product array.
     */
    public int getSize() {
        return size;
    }
}
