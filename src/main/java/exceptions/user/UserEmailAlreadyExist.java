package exceptions.user;

public class UserEmailAlreadyExist extends Exception{

    public UserEmailAlreadyExist() {

    }

    public UserEmailAlreadyExist(String message) {
        super(message);
    }
}
