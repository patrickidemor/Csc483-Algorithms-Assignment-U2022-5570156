/**
 * Represents a product in the TechMart store.
 */
public class Product {

    // Fields
    private int productId;
    private String productName;
    private String category;
    private double price;
    private int stockQuantity;

    /**
     * Constructor to create a new Product.
     */
    public Product(int productId, String productName, 
                   String category, double price, 
                   int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getters
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    /**
     * Returns a readable version of the product.
     */
    public String toString() {
        return "ID: " + productId + 
               " | Name: " + productName + 
               " | Category: " + category + 
               " | Price: $" + price + 
               " | Stock: " + stockQuantity;
    }
}
