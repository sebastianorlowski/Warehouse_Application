package api;

import entity.Product;
import javafx.collections.ObservableList;

public interface ProductService {
    void addProduct(Product product);
    void removeProductById(Long id);
    void updateProduct(Product product);
    ObservableList<Product> findProductByName(String productName);
    Product findProductById(Long id);
    ObservableList<Product> getAllProducts();
}
