package exceptions.user;

public class UserPasswordThisSame extends Exception {

    public UserPasswordThisSame() {

    }

    public UserPasswordThisSame(String message) {
        super(message);
    }
}
