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

    private UserValidator userValidator = UserValidator.getInstance();
    private UserDao userDao = UserDaoImpl.getInstance();

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

    public boolean removeUserByLogin(String login) {
        List<User> users;
        users = userDao.getAllUsers();
        try {
            if (findUserByLogin(login) != null) {
                for (User user : users) {
                    if (login.equals(user.getLogin())) {
                        userDao.removeUserByLogin(login);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateUserPassword(String login, String password, String newPassword) {
        try {
            if (isCorrectLoginAndPassword(login, password)) {
                if (userValidator.isValidateUpdateUserPassword(newPassword)) {
                    userDao.updateUserPassword(login, password, newPassword);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateUserEmail(String login, String email, String newEmail) {
        try {
            if (isCorrectLoginAndEmail(login, email)) {
                    userDao.updateUserEmail(login, email, newEmail);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
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

    public Integer getUserRole(String login) {
        return userDao.getUserRole(login);
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
