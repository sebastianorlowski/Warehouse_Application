package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserPanelController {

    public void buttonBack(ActionEvent event) throws Exception {
        Parent mainPanelPage = FXMLLoader.load(getClass().getResource("/mainpanelpage.fxml"));
        Scene mainPanelScene = new Scene(mainPanelPage);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(mainPanelScene);
        window.centerOnScreen();
        window.show();
    }

    public void buttonUser(ActionEvent event) throws Exception {
        Parent userParentPage = FXMLLoader.load(getClass().getResource("/useraccesspage.fxml"));
        Scene userScenePage = new Scene(userParentPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(userScenePage);
        window.centerOnScreen();
        window.show();
        window.setResizable(false);
    }

    public void buttonAdmin(ActionEvent event) throws Exception {
        Parent adminParentPage = FXMLLoader.load(getClass().getResource("/adminlogin.fxml"));
        Scene adminScenePage = new Scene(adminParentPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.centerOnScreen();
        window.setScene(adminScenePage);
        window.setResizable(false);
        window.show();
    }
}
