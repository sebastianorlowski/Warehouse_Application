package exceptions.user;

public class UserIdIsExistException extends Exception {

    public UserIdIsExistException() {

    }

    public UserIdIsExistException(String message) {
        super(message);
    }
}
