import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for Product search methods.
 */
public class ProductTest {

    Product[] products;

    @BeforeEach
    public void setUp() {
        products = new Product[5];
        products[0] = new Product(1, "Laptop", 
                                  "Electronics", 999.99, 10);
        products[1] = new Product(3, "Phone", 
                                  "Electronics", 499.99, 25);
        products[2] = new Product(5, "Tablet", 
                                  "Electronics", 299.99, 15);
        products[3] = new Product(7, "Camera", 
                                  "Electronics", 799.99, 5);
        products[4] = new Product(9, "TV", 
                                  "Electronics", 1299.99, 8);
    }

    @Test
    public void testSequentialSearchFound() {
        Product result = SearchMethods
                         .sequentialSearchById(products, 5);
        assertNotNull(result);
        assertEquals("Tablet", result.getProductName());
    }

    @Test
    public void testSequentialSearchNotFound() {
        Product result = SearchMethods
                         .sequentialSearchById(products, 99);
        assertNull(result);
    }

    @Test
    public void testBinarySearchFound() {
        Product result = SearchMethods
                         .binarySearchById(products, 7);
        assertNotNull(result);
        assertEquals("Camera", result.getProductName());
    }

    @Test
    public void testBinarySearchNotFound() {
        Product result = SearchMethods
                         .binarySearchById(products, 99);
        assertNull(result);
    }

    @Test
    public void testSearchByName() {
        Product result = SearchMethods
                         .searchByName(products, "laptop");
        assertNotNull(result);
        assertEquals(1, result.getProductId());
    }

    @Test
    public void testEmptyArray() {
        Product[] empty = new Product[0];
        Product result = SearchMethods
                         .sequentialSearchById(empty, 1);
        assertNull(result);
    }

    @Test
    public void testHybridSearchByName() {
        HybridSearch hybrid = new HybridSearch(products, 5);
        Product result = hybrid.searchByName("Phone");
        assertNotNull(result);
        assertEquals(3, result.getProductId());
    }
}
