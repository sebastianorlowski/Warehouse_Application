package controllers;

import api.UserService;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import service.UserImpl;

public class GetAllUsersController {
    private static UserService userService = UserImpl.getInstance();

    @FXML
    ListView<User> listUsers;
    ObservableList<User> getUsers = FXCollections.observableArrayList();

    public void buttonGenerateUsers() {
        getUsers = userService.getAllUsers();
        listUsers.setItems(getUsers);
    }
}
