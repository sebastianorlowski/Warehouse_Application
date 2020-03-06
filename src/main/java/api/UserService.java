package api;

/*
Użytkownik dodawanie, usuwanie po id i loginie, edycja hasła i maila po loginie, znajdz użytkownika po id, loginie, wyswietl wszystkich
uzytkownikow
czy hasło i login się zgadzają,
* */

import entity.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);
    void removeUserById(Long id);
    void removeUserByLogin(String login);
    void updateUserPassword(String login, String password);
    void updateUserEmail(String login, String email);
    User findUserById(Long id);
    User findUserByLogin(String login);
    List<User> getAllUsers();
    boolean isCorrectLoginAndPassword(String login, String password);

}
