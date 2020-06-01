package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import javafx.collections.ObservableList;

import java.util.List;

public class ProductImpl implements ProductService {
    private final ProductDao productDao = ProductDaoImpl.getInstance();

    private final static ProductService instance = new ProductImpl();
    public static ProductService getInstance() {
        return ProductImpl.instance;
    }

    public void addProduct(Product product) {
        try {
            productDao.addProduct(product);
        } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    public void removeProductById(Long id) {
        try {
            productDao.removeProductById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateProduct(Product product) {
        try {
            productDao.updateProduct(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
                    }
    }

    public ObservableList<Product> findProductByName(String productName) {
        return productDao.findProductByName(productName);
    }

    public Product findProductById(Long id) {
        List<Product> products;
        products = productDao.getAllProducts();
        for (Product product : products) {
            if (id.equals(product.getId())) {
                return product;
            }
        }
        return null;
    }

    public ObservableList<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}
