package controllers;

import api.UserFacade;
import facade.UserFacadeImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AdminLoginController {
    private static UserFacade userFacade = UserFacadeImpl.getInstance();

    @FXML
    TextField loginField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label labelInfo;

    public boolean isCorrectLoginAndPassword() {
        String login = loginField.getText();
        String password = passwordField.getText();
        return userFacade.loginUser(login, password);
    }

    public void buttonSignIn(ActionEvent event) throws Exception {

        if(isCorrectLoginAndPassword()) {
            Thread.sleep(1000);
            Parent adminPanelPage = FXMLLoader.load(getClass().getResource("/adminaccesspage.fxml"));
            Scene adminPanelScene = new Scene(adminPanelPage);

            Stage window = new Stage();
            window.setResizable(false);
            window.setScene(adminPanelScene);
            window.centerOnScreen();
            window.show();
        }
        else {
        labelInfo.setText("Wrong login or password!");
        }
    }
}
