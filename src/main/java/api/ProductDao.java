package api;

import entity.Product;
import javafx.collections.ObservableList;

public interface ProductDao {
    void addProduct(Product product);
    void removeProductById(Long id);
    void updateProduct(Product product);
    ObservableList<Product> findProductByName(String productName);
    ObservableList<Product> getAllProducts();
}
