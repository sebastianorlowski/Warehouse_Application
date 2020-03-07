package validators;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserValidator {

    private UserDao userDao = UserDaoImpl.getInstance();

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

    private boolean isUserExist(String login) {
        List<User> users = null;
        users = userDao.getAllUsers();
        for(User user : users) {
            if(user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

}
