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

    /* Sprawdź długość loginu, hasła, czy użytkownik istnieje, */
    public boolean addUser(User user)  {
        try {
            if(userValidator.isValidateAddUser(user)) {
                userDao.addUser(user);
                return true;
            }
        }
        catch (Exception e) {
            System.out.println("User cannot be register!");
        }
        return false;
    }

    /* Sprawdź czy istnieje użytk. o tym id, zwróć jego id i login*/
    public void removeUserById(Long id) {

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

    }

    /* Sprawdź czy użytkownik istnieje, czy login jest poprawnie wpisany(a-z), zwróc id, login */
    public User findUserByLogin(String login) {

    }

    public List<User> getAllUsers() {

    }

    /* Sprawdź czy login istnieje, czy poprawne jest hasło do loginu */
    public boolean isCorrectLoginAndPassword(String login, String password) {

    }
}
