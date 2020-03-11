package exceptions.products;

public class ProductCountMinimumException extends Exception {

    public ProductCountMinimumException() {

    }

    public ProductCountMinimumException(String message) {
        super(message);
    }
}
