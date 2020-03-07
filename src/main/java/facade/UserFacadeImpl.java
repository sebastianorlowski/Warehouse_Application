package facade;

import api.UserDao;
import api.UserFacade;
import dao.UserDaoImpl;
import entity.User;

public class UserFacadeImpl {
    private UserDao userDao = UserDaoImpl.getInstance();


}