package controllers;

import api.UserFacade;
import entity.User;
import entity.UserRole;
import enums.Role;
import facade.UserFacadeImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import validators.UserValidator;

public class RegisterController {
    private final static UserFacade userFacade = UserFacadeImpl.getInstance();
    private final static UserValidator userValidator = UserValidator.getInstance();

    @FXML
    TextField fieldLogin;
    @FXML
    TextField fieldPassword;
    @FXML
    TextField fieldEmail;
    @FXML
    Label labelValidator;

    public void isRegister() {
        String login = fieldLogin.getText();
        String password = fieldPassword.getText();
        String email = fieldEmail.getText();

        String role = "USER";
        User user = new User(login, password, email, new UserRole(Role.valueOf(role)));
        try {
            if (userValidator.isValidateAddUser(user)) {
                userFacade.registerUser(user);
                labelValidator.setText("Registration successfully!");
            }
        } catch (Exception e) {
            labelValidator.setText(e.getMessage());
        }
    }

    public void buttonRegister() {
        isRegister();
    }

    public void buttonBack(ActionEvent event) throws Exception {
        Parent main = FXMLLoader.load(getClass().getResource("/loginpage.fxml"));
        Scene mainScene = new Scene(main);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainScene);
        window.setResizable(false);
        window.centerOnScreen();
        window.show();
    }
}
