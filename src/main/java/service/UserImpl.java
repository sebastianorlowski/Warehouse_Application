package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exceptions.user.UserLoginIsExistException;
import javafx.collections.ObservableList;
import validators.UserValidator;

import java.util.List;

public class UserImpl implements UserService {

    private final UserValidator userValidator = UserValidator.getInstance();
    private final UserDao userDao = UserDaoImpl.getInstance();

    private static UserImpl instance = null;

    public static UserImpl getInstance() {
        if (instance == null) {
            instance = new UserImpl();
        }
        return instance;
    }

    public void addUser(User user) {
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUserByLogin(String login) {
        try {
            userDao.removeUserByLogin(login);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateUserPassword(String login, String password, String newPassword) {
        try {
            userDao.updateUserPassword(login, password, newPassword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateUserEmail(String login, String email, String newEmail) {
        try {
            userDao.updateUserEmail(login, email, newEmail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateUserRole(String login, Integer roleId) {
        userDao.updateUserRole(login, roleId);
    }

    public List<User> findUserByLogin(String login) {
        return userDao.findUserByLogin(login);
    }

    public List<User> findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    public ObservableList<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public boolean isCorrectLoginAndPassword(String login, String password) {
        return userDao.isCorrectLoginAndPassword(login, password);
    }

    public boolean isCorrectLoginAndEmail(String login, String email) {
        return userDao.isCorrectLoginAndEmail(login, email);
    }
}
