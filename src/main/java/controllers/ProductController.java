package controllers;

import api.ProductService;
import entity.Product;
import enums.Color;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ProductImpl;

import java.util.ArrayList;
import java.util.List;

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

    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, Float> columnID;
    @FXML
    private TableColumn<Product, String> columnName;
    @FXML
    private TableColumn<Product, Float> columnPrice;
    @FXML
    private TableColumn<Product, Float> columnWeight;
    @FXML
    private TableColumn<Product, Color> columnColor;
    @FXML
    private TableColumn<Product, Integer> columnCount;
    @FXML
    private TableColumn<Product, String> columnSize;
    @FXML
    private TableColumn<Product, String> columnMaterial;

    public ObservableList<Product> getProduct = FXCollections.observableArrayList();

    public void buttonGetAllProducts() {
        getProduct = productService.getAllProducts();

        columnID.setCellValueFactory(new PropertyValueFactory<Product, Float>("ID"));
        columnName.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<Product, Float>("Price"));
        columnWeight.setCellValueFactory(new PropertyValueFactory<Product, Float>("Weight"));
        columnColor.setCellValueFactory(new PropertyValueFactory<Product, Color>("Color"));
        columnCount.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Count"));
        columnSize.setCellValueFactory(new PropertyValueFactory<Product, String>("Size"));
        columnMaterial.setCellValueFactory(new PropertyValueFactory<Product, String>("Material"));

        tableView.setItems(getProduct);

    }

    public void buttonClearList() {

    }
}
