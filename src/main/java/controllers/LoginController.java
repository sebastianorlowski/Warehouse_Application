package controllers;

import api.UserFacade;
import facade.UserFacadeImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    String login, password;
    public boolean showLogged;


    private static UserFacade userFacade = UserFacadeImpl.getInstance();

    public void buttonGoToRegister(ActionEvent event) throws Exception{
        Parent registerPageParent = FXMLLoader.load(getClass().getResource("/registerpage.fxml"));
        Scene registerPageScene = new Scene(registerPageParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registerPageScene);
        window.show();

    }
    @FXML
    TextField loginField;
    @FXML
    TextField passwordField;

    public boolean isCorrectLoginAndPassword() {
        login = loginField.getText();
        password = passwordField.getText();

        if(userFacade.loginUser(login, password)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void buttonSignIn(ActionEvent event) throws Exception {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        if (isCorrectLoginAndPassword()) {
            Parent loggedInPageParent = FXMLLoader.load(getClass().getResource("/loggedinpage.fxml"));
            Scene loggedInPageScene = new Scene(loggedInPageParent);
            window.setTitle("");
            window.setScene(loggedInPageScene);
            window.show();
        }
        else {
            Parent isNotLoggedInPageParent = FXMLLoader.load(getClass().getResource("/isnotloggedinpage.fxml"));
            Scene isNotLoggedInPageScene = new Scene(isNotLoggedInPageParent);
            window.setTitle("");
            window.setScene(isNotLoggedInPageScene);
            window.show();
        }
    }

}
