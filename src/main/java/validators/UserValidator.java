package validators;

/*
login - min 5, max 20,
password - min 8, max 20, musi zawierać liczby
 */
public class UserValidator {

    private final int LOGIN_MIN_LENGTH = 5;
    private final int LOGIN_MAX_LENGTH = 20;
    private final int PASSWORD_MIN_LENGTH = 8;
    private final int PASSWORD_MAX_LENGTH = 20;

    private boolean isLoginEnoughLength(String login) {
        return login.length() >= LOGIN_MIN_LENGTH && login.length() <= LOGIN_MAX_LENGTH;
    }

    private boolean isPasswordEnoughLength(String password) {
        return password.length() >= PASSWORD_MIN_LENGTH && password.length() <= PASSWORD_MAX_LENGTH;
    }

    private boolean isPasswordOneCharUpperCase(String password) {
        for(char checkUpperCase : password.toCharArray()) {
            if(Character.isUpperCase(checkUpperCase)) {
                return true;
            }
        }
        return false;
    }

}
