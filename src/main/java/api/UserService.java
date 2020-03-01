package api;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    List<User> users = new ArrayList<User>();

    void addUser(User user);
    void removeUser(User user);
    void updateUser(User user);

}
