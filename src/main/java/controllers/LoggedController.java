package controllers;

import api.UserFacade;
import facade.UserFacadeImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoggedController {

    @FXML
    Label isLogged;

    public void initialize() {
        isLogged.setText("You logged in!");
    }

}
