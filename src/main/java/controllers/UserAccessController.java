package controllers;

import api.UserDao;
import dao.UserDaoImpl;
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

public class UserAccessController {

    private static UserDao userDao = UserDaoImpl.getInstance();
    private static UserValidator userValidator = UserValidator.getInstance();

    @FXML
    TextField fieldLogin;
    @FXML
    TextField fieldOldPassword;
    @FXML
    TextField fieldNewPassword;
    @FXML
    Label labelPasswordInfo;

    public void buttonChangePassword() {
       String login = fieldLogin.getText();
       String password = fieldOldPassword.getText();
       String newPassword = fieldNewPassword.getText();
       try {
           if (userDao.isCorrectLoginAndPassword(login, password)) {
                   if (userValidator.isValidateUpdateUserPassword(password, newPassword)) {
                       userDao.updateUserPassword(login, password, newPassword);
                       labelPasswordInfo.setText("You changed password!");
                       clearTextFields();
                   }
               }
           else {
               labelPasswordInfo.setText("Wrong login or password");
           }
       }
       catch (Exception e) {
           labelPasswordInfo.setText(e.getMessage());
       }
    }

    public void clearTextFields() {
        fieldLogin.clear();
        fieldNewPassword.clear();
        fieldOldPassword.clear();
    }

    public void buttonBack(ActionEvent event) throws Exception {
        Parent mainPanelPage = FXMLLoader.load(getClass().getResource("/mainpanelpage.fxml"));
        Scene mainPanelScene = new Scene(mainPanelPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainPanelScene);
        window.setResizable(false);
        window.centerOnScreen();
        window.show();
    }

}
