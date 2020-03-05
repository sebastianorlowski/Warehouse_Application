package api;

import entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface UserDao {
    List<User> users = new LinkedList<User>();

    void addUser(User user);
    void removeUserById(Long id);
    void removeUserByLogin(String login);
    void updateUserPassword(String login, String password);
    void updateUserEmail(String login, String email);
    List<User> getAllUsers();

}
