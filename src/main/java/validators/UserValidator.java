package validators;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exceptions.user.*;
import service.UserImpl;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public boolean isValidateAddUser(User user) throws UserLoginIsExistException, UserLoginEnoughLengthException, UserPasswordEnoughLengthException,
            UserPasswordIsOneCharUpCaseException {
        if(isLoginEnoughLength(user.getLogin())) {
            throw new UserLoginEnoughLengthException("Login must be minimum 5 and maximum 20 letters!");
        }
            if(isPasswordEnoughLength(user.getPassword())) {
                throw new UserPasswordEnoughLengthException("Password must be minimum 8 and maximum 20 letters!");
            }

            if(isPasswordOneCharUpperCase(user.getPassword())) {
                throw new UserPasswordIsOneCharUpCaseException("Password must have one uppercase letter!");
            }

            if (isUserAlreadyExist(user.getLogin())) {
                throw new UserLoginIsExistException("Login is exist!");
            }
        return true;
    }

    public boolean isValidateUpdateUserPassword(String newPassword) throws UserPasswordEnoughLengthException,
            UserPasswordIsOneCharUpCaseException{


        if(isPasswordEnoughLength(newPassword)) {
            throw new UserPasswordEnoughLengthException("Password must be minimum 8 and maximum 20 letters!");
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

    private boolean isUserAlreadyExist(String login) {
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
