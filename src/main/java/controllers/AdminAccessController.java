package controllers;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.UserImpl;
import validators.UserValidator;

public class AdminAccessController {
    private static UserService userService = UserImpl.getInstance();
    private static UserValidator userValidator = UserValidator.getInstance();

    @FXML
    TextField fieldLoginPassword;
    @FXML
    TextField fieldOldPassword;
    @FXML
    TextField fieldNewPassword;
    @FXML
    Label labelPasswordInfo;

    public void buttonChangePassword() {
        String login = fieldLoginPassword.getText();
        String password = fieldOldPassword.getText();
        String newPassword = fieldNewPassword.getText();

        try {
            if (userService.isCorrectLoginAndPassword(login, password)) {
                if (userValidator.isValidateUpdateUserPassword(newPassword)) {
                    userService.updateUserPassword(login, password, newPassword);
                    labelPasswordInfo.setText("You changed password!");
                    fieldLoginPassword.clear();
                    fieldOldPassword.clear();
                    fieldNewPassword.clear();
                }
            } else {
                labelPasswordInfo.setText("Wrong login or password");
            }
        } catch (Exception e) {
            labelPasswordInfo.setText(e.getMessage());
        }
    }


    @FXML
    TextField fieldLoginEmail;
    @FXML
    TextField fieldOldEmail;
    @FXML
    TextField fieldNewEmail;
    @FXML
    Label labelEmailInfo;

    public void buttonChangeEmail() {
        String login = fieldLoginEmail.getText();
        String email = fieldOldEmail.getText();
        String newEmail = fieldNewEmail.getText();
        if(userService.isCorrectLoginAndEmail(login,email)) {
            if (userValidator.isEmailAlreadyExist(email)) {
                userService.updateUserEmail(login, email, newEmail);
                labelEmailInfo.setText("You changed email!");
                fieldLoginEmail.clear();
                fieldOldEmail.clear();
                fieldNewEmail.clear();
            }
        }
    }

    public void buttonFindUserByLogin() throws Exception{

        Parent getFindPage = FXMLLoader.load(getClass().getResource("/getuserbyloginpage.fxml"));
        Scene findScene = new Scene(getFindPage);
        Stage findStage = new Stage();
        findStage.initModality(Modality.APPLICATION_MODAL);
        findStage.setScene(findScene);
        findStage.show();
    }

    public void buttonFindUserByEmail() throws Exception{

        Parent getFindPage = FXMLLoader.load(getClass().getResource("/getuserbyemailpage.fxml"));
        Scene findScene = new Scene(getFindPage);
        Stage findStage = new Stage();
        findStage.initModality(Modality.APPLICATION_MODAL);
        findStage.setScene(findScene);
        findStage.show();


    }

    @FXML
    TextField fieldRemoveUser;
    public void buttonRemoveUser() {
        String login = fieldRemoveUser.getText();
        userService.removeUserByLogin(login);
    }

    public void buttonGetAllUsers() throws Exception {
        Parent getAllUserPage = FXMLLoader.load(getClass().getResource("/getalluserspage.fxml"));
        Scene getAllUserScene = new Scene(getAllUserPage);

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(getAllUserScene);
        window.centerOnScreen();
        window.setResizable(false);
        window.show();
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
