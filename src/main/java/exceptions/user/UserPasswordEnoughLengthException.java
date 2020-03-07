package exceptions.user;

public class UserPasswordEnoughLengthException extends Exception {

    public UserPasswordEnoughLengthException() {

    }

    public UserPasswordEnoughLengthException(String message) {
        super(message);
    }
}
