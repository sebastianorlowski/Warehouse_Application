package exceptions.user;

public class UserLoginAndPasswordIsCorrect extends Exception {
    public UserLoginAndPasswordIsCorrect() {

    }
    public UserLoginAndPasswordIsCorrect(String message) {
        super(message);
    }
}
