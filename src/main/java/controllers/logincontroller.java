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

public class logincontroller {
    String login, password;

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
    public void buttonSignIn(ActionEvent event) throws Exception {
        Parent validatorPageParent = FXMLLoader.load(getClass().getResource("/validatorpage.fxml"));
        Scene validatorPageScene = new Scene(validatorPageParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        login = loginField.getText();
        password = passwordField.getText();

        if(userFacade.loginUser(login, password)) {
            window.setScene(validatorPageScene);
            window.show();
        }
    }

}
