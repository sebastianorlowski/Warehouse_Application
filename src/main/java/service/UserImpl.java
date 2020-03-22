package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
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

    public boolean addUser(User user) {
        try {
            if (userValidator.isValidateAddUser(user)) {
                userDao.addUser(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public User removeUserById(Long id) {
        List<User> users = null;
        users = userDao.getAllUsers();
        try {
            if (findUserById(id) != null) {
                for (User user : users) {
                    if (id.equals(user.getId())) {
                        System.out.println("You removed user " + user.getLogin());
                        userDao.removeUserById(id);
                    }
                }
            } else {
                System.out.println("This user is not exist!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User removeUserByLogin(String login) {
        List<User> users = null;
        users = userDao.getAllUsers();
        try {
            if (findUserByLogin(login) != null) {
                for (User user : users) {
                    if (login.equals(user.getLogin())) {
                        System.out.println("You removed user " + user.getLogin());
                        userDao.removeUserByLogin(login);
                    }
                }
            } else {
                System.out.println("This user is not exist!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User updateUserPassword(String login, String password, String newPassword) {
        List<User> users = null;
        users = userDao.getAllUsers();
        try {
            for (User user : users) {
                if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                    if (userValidator.isValidateUpdateUserPassword(newPassword))
                        userDao.updateUserPassword(login, password, newPassword);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public User updateUserEmail(String login, String email, String newEmail) {
        List<User> users = null;
        users = userDao.getAllUsers();
        for (User user : users) {
            if (login.equals(user.getLogin()) && email.equals(user.getPassword())) {
                userDao.updateUserPassword(login, email, newEmail);
            }
        }
        return null;
    }

    public User findUserById(Long id) {
        List<User> users = null;
        users = userDao.getAllUsers();
        for (User user : users) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    public User findUserByLogin(String login) {
        List<User> users = null;
        users = userDao.getAllUsers();
        for (User user : users) {
            if (login.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

    public User findUserByEmail(String email) {
        List<User> users = null;
        users = userDao.getAllUsers();
        for(User user : users) {
            if(email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public boolean isCorrectLoginAndPassword(String login, String password) {
        if (userDao.isCorrectLoginAndPassword(login,password)) {
            System.out.println("You logged in!");
            return true;
        }
        System.out.println("Wrong login or Password!");
        return false;
    }
}
