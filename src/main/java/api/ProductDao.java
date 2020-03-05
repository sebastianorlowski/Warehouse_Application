package api;

import entity.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);
    void removeProductById(Long id);
    void removeProductByName(String productName);
    void updateProduct(Product product);
    List<Product> getAllProducts();

}
