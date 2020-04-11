package controllers;

import api.UserDao;
import api.UserFacade;
import dao.UserDaoImpl;
import facade.UserFacadeImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import validators.UserValidator;

public class AdminAccessController {
    private static UserDao userDao = UserDaoImpl.getInstance();
    private static UserValidator userValidator = UserValidator.getInstance();
    private static UserFacade userFacade = UserFacadeImpl.getInstance();

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
            if (userDao.isCorrectLoginAndPassword(login, password)) {
                if (userValidator.isValidateUpdateUserPassword(newPassword)) {
                    userDao.updateUserPassword(login, password, newPassword);
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
        if(userDao.isCorrectLoginAndEmail(login,email)) {
            if (userValidator.isEmailAlreadyExist(email)) {
                userDao.updateUserEmail(login, email, newEmail);
                labelEmailInfo.setText("You changed email!");
                fieldLoginEmail.clear();
                fieldOldEmail.clear();
                fieldNewEmail.clear();
            }
        }
    }

    @FXML
    TextField fieldFindLogin;
    @FXML
    Label labelFindLogin;

    public void buttonFindUser() {
        String login = fieldFindLogin.getText();

        labelFindLogin.setText(String.valueOf(userDao.findUserByLogin(login)));
    }

    public void buttonRemoveUser() {

    }

    public void buttonGetAllUsers() {

    }



    public void buttonBack() {

    }

}
