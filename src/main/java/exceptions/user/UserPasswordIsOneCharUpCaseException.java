package exceptions.user;

public class UserPasswordIsOneCharUpCaseException extends Exception {

    public UserPasswordIsOneCharUpCaseException() {

    }

    public UserPasswordIsOneCharUpCaseException(String message) {
        super(message);
    }
}
