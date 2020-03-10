package facade;

import api.UserFacade;
import api.UserService;
import entity.User;
import service.UserImpl;

public class UserFacadeImpl implements UserFacade {
    private static UserService userService = UserImpl.getInstance();

    public boolean registerUser(User user) {
        return userService.addUser(user);
    }

    public boolean loginUser(String login, String password) {
        return userService.isCorrectLoginAndPassword(login, password);
    }
}
