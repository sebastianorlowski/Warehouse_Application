package exceptions.products;

public class ProductNameCannotBeEmptyException extends Exception {

    public ProductNameCannotBeEmptyException() {

    }

    public ProductNameCannotBeEmptyException(String message) {
        super(message);
    }
}
