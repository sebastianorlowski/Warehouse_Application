package facade;

import api.UserFacade;
import api.UserService;
import entity.User;
import service.UserImpl;

public class UserFacadeImpl implements UserFacade {
    private final static UserService userService = UserImpl.getInstance();
    private static UserFacadeImpl instance = null;

    public static UserFacadeImpl getInstance() {
        if(instance == null) {
            instance = new UserFacadeImpl();
        }
        return instance;
    }

    public void registerUser(User user) {
        userService.addUser(user);
    }

    public boolean loginUser(String login, String password) {
        return userService.isCorrectLoginAndPassword(login, password);
    }
}
