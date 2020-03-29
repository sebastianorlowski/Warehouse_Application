package controllers;

import api.ProductService;
import entity.Product;
import enums.Color;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import service.ProductImpl;

public class ProductController {

    private static ProductService productService = ProductImpl.getInstance();

    @FXML
    TextField fieldName;
    @FXML
    TextField fieldPrice;
    @FXML
    TextField fieldWeight;
    @FXML
    TextField fieldCount;
    @FXML
    TextField fieldSize;
    @FXML
    TextField fieldMaterial;
    @FXML
    ComboBox<Color> comboBoxColor;

    public void initialize() {
        ObservableList<Color> list = FXCollections.observableArrayList(Color.values());
        comboBoxColor.setItems(list);
    }

    public void buttonAddProduct(ActionEvent event) {
        String name = fieldName.getText();
        Float price = Float.valueOf(fieldPrice.getText());
        Float weight = Float.valueOf(fieldWeight.getText());
        Color color =  comboBoxColor.getValue();
        Integer productCount = Integer.valueOf(fieldCount.getText());
        String size = fieldSize.getText();
        String material = fieldMaterial.getText();

        Product product = new Product(1L,name , price, weight, color, productCount, size, material);

        productService.addProduct(product);




    }

    public void comboBoxValue() {
        Color color = comboBoxColor.getValue();
    }


    public void buttonUpdateProduct() {

    }

    public void buttonClearFields() {

    }

    public void buttonRemoveProduct() {

    }

    public void buttonBackToMenu() {

    }

    public void buttonFindName() {

    }

    public void buttonFindID() {

    }

    public void buttonGetAllProducts() {

    }

    public void buttonClearList() {

    }
}
