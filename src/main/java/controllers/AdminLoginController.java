package controllers;

import api.UserDao;
import api.UserFacade;
import dao.UserDaoImpl;
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
    private static UserDao userDao = UserDaoImpl.getInstance();
    String login, password;
    Integer role;

    @FXML
    TextField loginField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label labelInfo;

    public boolean isCorrectLoginAndPassword() {
        login = loginField.getText();
        password = passwordField.getText();
        role = userDao.getUserRole(login);
        return userFacade.loginUser(login, password);
    }

    public void buttonSignIn(ActionEvent event) throws Exception {
        if (isCorrectLoginAndPassword()) {
            if (role == 2) {
                Parent adminPanelPage = FXMLLoader.load(getClass().getResource("/adminaccesspage.fxml"));
                Scene adminPanelScene = new Scene(adminPanelPage);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setResizable(false);
                window.setScene(adminPanelScene);
                window.centerOnScreen();
                window.show();
            }
            else {
                labelInfo.setText("You havent access!");
            }
    }
        else {
        labelInfo.setText("Wrong login or password!");
        }
    }

    public void buttonBack(ActionEvent event) throws Exception {
        Parent mainPanelPage = FXMLLoader.load(getClass().getResource("/mainpanelpage.fxml"));
        Scene mainPanelScene = new Scene(mainPanelPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.centerOnScreen();
        window.setScene(mainPanelScene);
        window.setResizable(false);
        window.show();
    }
}
