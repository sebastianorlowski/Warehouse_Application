package controllers;

import api.ProductService;
import entity.Product;
import enums.Color;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
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

    ObservableList<Color> list = FXCollections.observableArrayList(Color.values());

    public void initialize() {

        comboBoxColor.setItems(list);
        buttonGetAllProducts();
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
        buttonGetAllProducts();
    }

    public void comboBoxValue() {
        Color color = comboBoxColor.getValue();
    }


    public void buttonUpdateProduct() {

    }

    public void buttonClearFields() {
        fieldName.clear();
        fieldPrice.clear();
        fieldWeight.clear();
        fieldCount.clear();
        fieldMaterial.clear();
        fieldSize.clear();
        comboBoxColor.getSelectionModel().clearSelection();
    }

    public void buttonRemoveProduct() {

    }

    public void buttonBackToMenu(ActionEvent event) throws Exception {
        Parent mainPanelPage = FXMLLoader.load(getClass().getResource("/mainpanelpage.fxml"));
        Scene mainPanelScene = new Scene(mainPanelPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainPanelScene);
        window.centerOnScreen();
        window.show();
    }

    public void buttonFindName() {

    }

    public void buttonFindID() {

    }

    @FXML
    private TableView<Product> tableView;
    @FXML
    private TableColumn<Product, Long> columnID;
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

        columnID.setCellValueFactory(new PropertyValueFactory<Product, Long>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));
        columnWeight.setCellValueFactory(new PropertyValueFactory<Product, Float>("weight"));
        columnColor.setCellValueFactory(new PropertyValueFactory<Product, Color>("color"));
        columnCount.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productCount"));
        columnSize.setCellValueFactory(new PropertyValueFactory<Product, String>("size"));
        columnMaterial.setCellValueFactory(new PropertyValueFactory<Product, String>("material"));

        tableView.setItems(getProduct);
    }
    @FXML
    Label labelID;
    public void mouseGetIdByMouseClick() {
        TablePosition pos = tableView.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        Product product = tableView.getItems().get(row);
        TableColumn col = columnID;
        String data = String.valueOf(col.getCellObservableValue(product).getValue());
        labelID.setText(data);

    }
}
