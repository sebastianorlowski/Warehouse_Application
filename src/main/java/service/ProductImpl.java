package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import validators.ProductValidator;

import java.util.List;
/*
boolean addProduct(Product product);
    Product removeProductById(Long id);
    Product removeProductByName(String productName);
    Product updateProduct(Product product);
    Product findProductByName(String productName);
    Product findProductById(Long id);
    List<Product> getAllProducts();
 */

public class ProductImpl implements ProductService {
    private ProductValidator productValidator = ProductValidator.getInstance();
    private ProductDao productDao = ProductDaoImpl.getInstance();

    public boolean addProduct(Product product) {
        try {
            if (productValidator.isValidateProduct(product)) {
                productDao.addProduct(product);
            }
        }
        catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return false;
        }



    public Product removeProductById(Long id) {
        try {
            if(productValidator.productIsAlreadyExistId(id)) {
                return
            }
        }
    }


    public Product removeProductByName(String productName) {

    }
    public boolean updateProduct(Product product) {
        List<Product> products = null;
        products = productDao.getAllProducts();
        try {
            if (findProductByName(product.getName()).equals(product)) {
                if(productValidator.isValidateUpdateProduct(product)) {
                    return true;
                }
            }
        }
        catch (Exception e) {
        }
    }

    public Product findProductByName(String productName) {

    }

    public Product findProductById(Long id) {

    }

    public List<Product> getAllProducts() {

    }

}
