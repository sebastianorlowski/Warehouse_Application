package facade;

import api.UserDao;
import api.UserFacade;
import dao.UserDaoImpl;
import entity.User;

public class UserFacadeImpl implements UserFacade {
    private UserDao userDao = UserDaoImpl.getInstance();

    boolean registerUser(User user) {

    }

    boolean loginUser(String password, String login) {

    }
}
