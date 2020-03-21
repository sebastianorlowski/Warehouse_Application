package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class logincontroller {

    public void buttonGoToRegister(ActionEvent event) throws Exception{
        Parent registerPageParent = FXMLLoader.load(getClass().getResource("/registerpage.fxml"));
        Scene registerPageScene = new Scene(registerPageParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registerPageScene);
        window.show();


    }

}
