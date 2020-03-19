package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import enums.Color;
import validators.ProductValidator;

import java.util.List;

public class ProductImpl implements ProductService {
    private ProductValidator productValidator = ProductValidator.getInstance();
    private ProductDao productDao = ProductDaoImpl.getInstance();

    private static ProductService instance = new ProductImpl();
    public static ProductService getInstance() {
        return ProductImpl.instance;
    }

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
                productDao.removeProductById(id);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public Product removeProductByName(String productName) {
        try {
            if(productValidator.productIsAlreadyExist(productName)) {
                productDao.removeProductByName(productName);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public void updateProduct(Product product) {
        try {
        if(findProductById(product.getId()) != null) {
            if (productValidator.isValidateUpdateProduct(product)) {
                productDao.updateProduct(product);
            }
        }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
                    }
    }

    public Product findProductByName(String productName) {
        List<Product> products = null;
        products = productDao.getAllProducts();
        for(Product product : products) {
            if(productName.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }

    public Product findProductById(Long id) {
        List<Product> products = null;
        products = productDao.getAllProducts();
        for(Product product : products) {
            if(id.equals(product.getId())) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}
