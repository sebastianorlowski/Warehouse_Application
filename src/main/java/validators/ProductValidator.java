package validators;


import api.ProductDao;
import dao.ProductDaoImpl;
import entity.Product;
import exceptions.products.*;

import java.util.List;

/* (Long id, String name, Float price, Float weight, Color color,
                   Integer productCount, String size, String material)*/
public class ProductValidator {
    private ProductDao productDao = ProductDaoImpl.getInstance();

    private static ProductValidator instance = null;

    public static ProductValidator getInstance() {
        if(instance == null) {
            instance = new ProductValidator();
        }
        return instance;
    }

    private final int MAX_NAME_LENGTH = 50;
    private final float MIN_PRICE = 0.0f;
    private final float MIN_WEIGHT = 0.0f;
    private final int PRODUCT_COUNT = 0;

    public boolean isValidateProduct(Product product) throws ProductCountMinimumException, ProductNameCannotBeEmptyException,
            ProductNameEnoughLengthException, ProductPriceMinimumException, ProductWeightMinimumException {
        if(productCount(product.getProductCount())) {
            throw new ProductCountMinimumException("Product count cannot be 0 or less!");
        }
        if(productNameEmpty(product.getName())) {
            throw new ProductNameCannotBeEmptyException("Product name cannot be empty!");
        }
        if(productNameEnoughLength(product.getName())) {
            throw new ProductNameEnoughLengthException("Product name is too long! Maximum 50 letters!");
        }
        if(productPriceMinimum(product.getPrice())) {
            throw new ProductPriceMinimumException("Product price cannot be 0 or less!");
        }
        if(productWeightMinimum(product.getWeight())) {
            throw new ProductWeightMinimumException("Product weight cannot be 0 or less!");
        }
        return true;
    }

    public boolean isValidateUpdateProduct(Product product) throws ProductNameCannotBeEmptyException, ProductNameEnoughLengthException,
            ProductPriceMinimumException, ProductWeightMinimumException {
        if (productNameEmpty(product.getName())) {
            throw new ProductNameCannotBeEmptyException("Product name cannot be empty!");
        }
        if (productNameEnoughLength(product.getName())) {
            throw new ProductNameEnoughLengthException("Product name is too long! Maximum 50 letters!");
        }
        if (productPriceMinimum(product.getPrice())) {
            throw new ProductPriceMinimumException("Product price cannot be 0 or less!");
        }
        if (productWeightMinimum(product.getWeight())) {
            throw new ProductWeightMinimumException("Product weight cannot be 0 or less!");
        }
        return true;
    }

    private boolean productCount(Integer productCount) {
        return productCount <= PRODUCT_COUNT;
    }

    private boolean productNameEmpty(String productName) {
        return productName == null || productName.length() == 0;
    }

    private boolean productNameEnoughLength(String productName) {
        return productName.length() >= MAX_NAME_LENGTH;
    }

    private boolean productPriceMinimum(Float price) {
        return price <= MIN_PRICE;
    }

    private boolean productWeightMinimum(Float weight) {
        return weight <= MIN_WEIGHT;
    }

    public boolean productIsAlreadyExistId(Long id) {
        List<Product> products;
        products = productDao.getAllProducts();
        for(Product product : products) {
            if(id.equals(product.getId())) {
                return true;
            }
        }
        return false;
    }
}
