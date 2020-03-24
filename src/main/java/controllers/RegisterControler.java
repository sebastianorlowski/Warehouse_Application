package controllers;

import api.UserFacade;
import entity.User;
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

import javax.swing.*;

public class RegisterControler {
    String login, password, email;
    private static UserFacade userFacade = UserFacadeImpl.getInstance();

    @FXML
    TextField fieldLogin;
    @FXML
    TextField fieldPassword;
    @FXML
    TextField fieldEmail;
    @FXML
    Label labelValidator;

    public boolean isRegister() {
        login = fieldLogin.getText();
        password = fieldPassword.getText();
        email = fieldEmail.getText();

        User user = new User(login, password, email);


        if(userFacade.registerUser(user)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void buttonRegister(ActionEvent event) throws Exception {
        Parent validatorPageParent = FXMLLoader.load(getClass().getResource("/validatorpage.fxml"));
        Scene validatorPageScene = new Scene(validatorPageParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(validatorPageScene);
        window.show();
    }

    public void buttonBack(ActionEvent event) throws Exception {
        Parent main = FXMLLoader.load(getClass().getResource("/loginpage.fxml"));
        Scene mainScene = new Scene(main);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainScene);
        window.show();
    }
}
