package validators;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;
import exceptions.user.*;
import java.util.List;

public class UserValidator {

    private UserDao userDao = UserDaoImpl.getInstance();

    private static UserValidator instance = null;

    public static UserValidator getInstance() {
        if(instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    private final int LOGIN_MIN_LENGTH = 5;
    private final int LOGIN_MAX_LENGTH = 20;
    private final int PASSWORD_MIN_LENGTH = 8;
    private final int PASSWORD_MAX_LENGTH = 20;

    public boolean isValidateAddUser(User user) throws UserEmailAlreadyExist, UserLoginIsExistException, UserLoginEnoughLengthException,
            UserPasswordEnoughLengthException,
            UserPasswordIsOneCharUpCaseException {
        if(isLoginEnoughLength(user.getLogin())) {
            throw new UserLoginEnoughLengthException("Login must have min 5 and max 20 letters!");
        }
            if(isPasswordEnoughLength(user.getPassword())) {
                throw new UserPasswordEnoughLengthException("Password must have min 8 and max 20 letters!");
            }

            if(isPasswordOneCharUpperCase(user.getPassword())) {
                throw new UserPasswordIsOneCharUpCaseException("Password must have one uppercase letter!");
            }

            if (isUserAlreadyExist(user.getLogin())) {
                throw new UserLoginIsExistException("Login is already exist!");
            }

            if(isEmailAlreadyExist(user.getEmail())) {
                throw new UserEmailAlreadyExist("Email is already exist!");
            }
        return true;
    }

    public boolean isValidateUpdateUserPassword(String newPassword) throws UserPasswordEnoughLengthException,
            UserPasswordIsOneCharUpCaseException {

        if(isPasswordEnoughLength(newPassword)) {
            throw new UserPasswordEnoughLengthException("Password must be min 8 and max 20 letters!");
        }

        if(isPasswordOneCharUpperCase(newPassword)) {
            throw new UserPasswordIsOneCharUpCaseException("Password must have one uppercase letter!");
        }
       return true;
    }

    private boolean isLoginEnoughLength(String login) {
        return login.length() < LOGIN_MIN_LENGTH || login.length() > LOGIN_MAX_LENGTH;
    }

    private boolean isPasswordEnoughLength(String password) {
        return password.length() < PASSWORD_MIN_LENGTH || password.length() > PASSWORD_MAX_LENGTH;
    }

    private boolean isPasswordOneCharUpperCase(String password) {
        for(char checkUpperCase : password.toCharArray()) {
            if(Character.isUpperCase(checkUpperCase)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmailAlreadyExist(String email) {
        List<User> users;
        users = userDao.getAllUsers();
        for(User user : users) {
            if(user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean isUserAlreadyExist(String login) {
        List<User> users;
        users = userDao.getAllUsers();
        for(User user : users) {
            if(user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

}
