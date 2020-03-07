package exceptions.user;

public class UserLoginIsExistException extends Exception {
    public UserLoginIsExistException() {

    }

    public UserLoginIsExistException(String message) {
        super(message);
    }
}
