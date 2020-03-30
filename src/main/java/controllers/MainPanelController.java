package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainPanelController {

    public void goToUserPanel() {

    }

    public void goToProductPanel(ActionEvent event) throws Exception {
        Parent productPanelPage = FXMLLoader.load(getClass().getResource("/productpage.fxml"));
        Scene productPanelScene = new Scene(productPanelPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(productPanelScene);
        window.centerOnScreen();
        window.setResizable(false);
        window.show();
    }
}
