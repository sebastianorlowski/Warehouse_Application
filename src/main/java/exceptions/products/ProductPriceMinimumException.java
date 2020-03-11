package exceptions.products;

public class ProductPriceMinimumException extends Exception {

    public ProductPriceMinimumException() {

    }
    public ProductPriceMinimumException(String message) {
        super(message);
    }
}
