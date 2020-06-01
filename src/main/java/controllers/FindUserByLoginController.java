package controllers;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.UserImpl;

public class FindUserByLoginController {
    private final static UserService userService = UserImpl.getInstance();

    @FXML
    TextField fieldGetLogin;
    @FXML
    Label labelGetUserInfo;

    public void buttonGetUserByLogin() {
        String login = fieldGetLogin.getText();
        labelGetUserInfo.setText(String.valueOf(userService.findUserByLogin(login)));
    }
}
