package api;

import entity.User;

public interface UserFacade {
    void registerUser(User user);
    boolean loginUser(String login, String password);
}
