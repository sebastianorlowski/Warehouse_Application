package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exceptions.user.UserLoginEnoughLengthException;
import exceptions.user.UserLoginIsExistException;
import exceptions.user.UserPasswordEnoughLengthException;
import validators.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserImpl implements UserService {

    private UserValidator userValidator = UserValidator.getInstance();
    private UserDao userDao = UserDaoImpl.getInstance();

    private static UserImpl instance = null;

    public static UserImpl getInstance() {
        if(instance == null) {
            instance = new UserImpl();
        }
        return instance;
    }
    /* Sprawdź długość loginu, hasła, czy użytkownik istnieje, */
    public boolean addUser(User user)  {
        try {
            if(userValidator.isValidateAddUser(user)) {
                userDao.addUser(user);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /* Sprawdź czy istnieje użytk. o tym id, zwróć jego id i login*/
    public void removeUserById(Long id) {
        List<User> users = null;
        users = userDao.getAllUsers();
        try {
        for(User user : users) {
            if (id.equals(user.getId())) {
                System.out.println("You removed user " + user.getLogin());
                userDao.removeUserById(id);
            }
            }
        }
        catch (Exception e) {
            System.out.println("This user is not exist!");
        }
    }

    /* Sprawdź czy istnieje użytk. o tym loginie, zwróć jego id i login */
    public void removeUserByLogin(String login) {

    }

    public void updateUserPassword(String login, String password) {

    }

    public void updateUserEmail(String login, String email) {

    }

    /* Sprawdź czy użytkownik istnieje, czy id zostało poprawnie wpisane(jest liczbą 0-9), zwróć id, login*/
    public User findUserById(Long id) {
        List<User> users = null;
        users = userDao.getAllUsers();
        for(User user : users) {
            if(id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    /* Sprawdź czy użytkownik istnieje, czy login jest poprawnie wpisany(a-z), zwróc id, login */
    public User findUserByLogin(String login) {
        List<User> users = null;
        users = userDao.getAllUsers();
        for(User user : users) {
            if(login.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    /* Sprawdź czy login istnieje, czy poprawne jest hasło do loginu */
  /*  public boolean isCorrectLoginAndPassword(String login, String password) {

    }

   */
}
