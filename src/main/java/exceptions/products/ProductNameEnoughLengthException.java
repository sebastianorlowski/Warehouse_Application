package exceptions.products;

public class ProductNameEnoughLengthException extends Exception {

    public ProductNameEnoughLengthException() {
    }

    public ProductNameEnoughLengthException(String message) {
        super(message);
    }
}
