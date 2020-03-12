package api;

import entity.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);
    boolean removeProductById(Long id);
    boolean removeProductByName(String productName);
    boolean updateProduct(Product product);
    Product findProductByName(String productName);
    Product findProductById(Long id);
    List<Product> getAllProducts();
}
