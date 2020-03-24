package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class IsNotLoggedController {

    @FXML
    Label isNotLogged;

    public void initialize() {
        isNotLogged.setText("Wrong login or password!");
    }

    public void buttonBack(ActionEvent event) throws Exception {
        Parent main = FXMLLoader.load(getClass().getResource("/loginpage.fxml"));
        Scene mainScene = new Scene(main);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainScene);
        window.show();
    }
}
