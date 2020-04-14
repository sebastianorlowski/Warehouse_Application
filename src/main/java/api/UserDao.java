package api;

import entity.User;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface UserDao {
    List<User> users = new LinkedList<User>();

    void addUser(User user);
    void removeUserByLogin(String login);
    void updateUserPassword(String login, String password, String newPassword);
    void updateUserEmail(String login, String email, String newEmail);
    void updateUserRole(String login, Integer roleId);
    List<User> findUserByLogin(String login);
    List<User> findUserByEmail(String email);
    Integer getUserRole(String login);
    boolean isCorrectLoginAndPassword(String login, String password);
    boolean isCorrectLoginAndEmail(String login, String email);
    ObservableList<User> getAllUsers();

}
