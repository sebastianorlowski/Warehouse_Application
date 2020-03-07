package service;

import api.UserDao;
import api.UserService;
import entity.User;

import java.util.List;

public class UserImpl implements UserService {

    /* Sprawdź długość loginu, hasła, czy użytkownik istnieje, */
    public boolean addUser(User user) {

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
