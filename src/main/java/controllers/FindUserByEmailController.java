package controllers;

import api.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.UserImpl;

public class FindUserByEmailController {
    private static UserService userService = UserImpl.getInstance();
    @FXML
    TextField fieldGetUserByEmail;
    @FXML
    Label labelEmailInfo;

    public void buttonGetUserByEmail() {
        String email = fieldGetUserByEmail.getText();
        labelEmailInfo.setText(String.valueOf(userService.findUserByEmail(email)));
    }
}
