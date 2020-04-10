package api;

import entity.Product;
import enums.Color;
import javafx.collections.ObservableList;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);
    Product removeProductById(Long id);
    Product updateProduct(Product product);
    ObservableList<Product> findProductByName(String productName);
    Product findProductById(Long id);
    ObservableList<Product> getAllProducts();
}
