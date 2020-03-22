package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class registercontroller {

    public void buttonRegister(ActionEvent event) throws Exception {
        Parent validatorPageParent = FXMLLoader.load(getClass().getResource("/validatorpage.fxml"));
        Scene validatorPageScene = new Scene(validatorPageParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(validatorPageScene);
        window.show();
    }
}
