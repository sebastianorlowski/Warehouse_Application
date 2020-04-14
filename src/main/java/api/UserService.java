package api;

/*
Użytkownik dodawanie, usuwanie po id i loginie, edycja hasła i maila po loginie, znajdz użytkownika po id, loginie, wyswietl wszystkich
uzytkownikow
czy hasło i login się zgadzają,
* */

import entity.User;
import javafx.collections.ObservableList;

import java.util.List;

public interface UserService {

    boolean addUser(User user);
    boolean removeUserByLogin(String login);
    boolean updateUserPassword(String login, String password, String newPassword);
    boolean updateUserEmail(String login, String email, String newEmail);
    void updateUserRole(String login, Integer roleId);
    List<User> findUserByLogin(String login);
    List<User> findUserByEmail(String email);
    Integer getUserRole(String login);
    ObservableList<User> getAllUsers();
    boolean isCorrectLoginAndPassword(String login, String password);
    boolean isCorrectLoginAndEmail(String login, String email);

}
