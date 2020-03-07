package exceptions.user;

public class UserLoginEnoughLengthException extends Exception{

    public UserLoginEnoughLengthException() {

    }

    public UserLoginEnoughLengthException(String message) {
        super(message);
    }
}
