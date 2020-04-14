package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainPanelController {

    public void goToProductPanel(ActionEvent event) throws Exception {
        Parent productPanelPage = FXMLLoader.load(getClass().getResource("/productpage.fxml"));
        Scene productPanelScene = new Scene(productPanelPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(productPanelScene);
        window.centerOnScreen();
        window.setResizable(false);
        window.show();
    }

    public void goToUserPanel(ActionEvent event) throws Exception {
        Parent userPanelPage = FXMLLoader.load(getClass().getResource("/loginpanelpage.fxml"));
        Scene userPanelScene = new Scene(userPanelPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(userPanelScene);
        window.centerOnScreen();
        window.setResizable(false);
        window.show();
    }

    public void goToLoginPanel(ActionEvent event) throws Exception {
        Parent loginPanelPage = FXMLLoader.load(getClass().getResource("/loginpage.fxml"));
        Scene loginPanelScene = new Scene(loginPanelPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(loginPanelScene);
        window.centerOnScreen();
        window.setResizable(false);
        window.show();
    }
 }
