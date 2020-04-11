package api;

import entity.User;

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
    List<User> findUserByLogin(String login);
    boolean isCorrectLoginAndPassword(String login, String password);
    List<User> getAllUsers();

}
