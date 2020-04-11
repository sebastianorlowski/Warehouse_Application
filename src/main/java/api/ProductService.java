package api;

import entity.Product;
import enums.Color;
import javafx.collections.ObservableList;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);
    void removeProductById(Long id);
    void updateProduct(Product product);
    ObservableList<Product> findProductByName(String productName);
    Product findProductById(Long id);
    ObservableList<Product> getAllProducts();
}
