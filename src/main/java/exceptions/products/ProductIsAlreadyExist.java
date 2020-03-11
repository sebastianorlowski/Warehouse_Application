package exceptions.products;

public class ProductIsAlreadyExist extends Exception {

    public ProductIsAlreadyExist() {

    }

    public ProductIsAlreadyExist(String message) {
        super(message);
    }
}
