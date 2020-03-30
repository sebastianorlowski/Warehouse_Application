package api;

import entity.Product;
import enums.Color;
import javafx.collections.ObservableList;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);
    Product removeProductById(Long id);
    Product removeProductByName(String productName);
    void updateProduct(Product product);
    Product findProductByName(String productName);
    Product findProductById(Long id);
    ObservableList<Product> getAllProducts();
}
