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
import javafx.stage.Stage;
import service.ProductImpl;
import validators.ProductValidator;

public class ProductController {
    private static ProductService productService = ProductImpl.getInstance();
    private static ProductValidator productValidator = ProductValidator.getInstance();

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

        @FXML
        Label labelInfo;

    public void buttonAddProduct() {
        try {
            String name = fieldName.getText();
            Float price = Float.valueOf(fieldPrice.getText());
            Float weight = Float.valueOf(fieldWeight.getText());
            Color color = comboBoxColor.getValue();
            Integer productCount = Integer.valueOf(fieldCount.getText());
            String size = fieldSize.getText();
            String material = fieldMaterial.getText();

            Product product = new Product.Builder().setId(1L)
                    .setName(name)
                    .setPrice(price)
                    .setWeight(weight)
                    .setColor(color)
                    .setProductCount(productCount)
                    .setSize(size)
                    .setMaterial(material)
                    .build();
            try {
                if (productValidator.isValidateProduct(product)) {
                    productService.addProduct(product);
                    buttonGetAllProducts();
                    labelInfo.setText("You add product!");
                }
            }
            catch (Exception e) {
                labelInfo.setText(e.getMessage());
            }
        }
        catch (NumberFormatException e) {
            labelInfo.setText("SOMETHING WENT WRONG!");
        }
            }

    public void buttonUpdateProduct() {
        try {
            Product selectedItem = tableView.getSelectionModel().getSelectedItem();
            Long id = selectedItem.getId();
            String name = fieldName.getText();
            Float price = Float.valueOf(fieldPrice.getText());
            Float weight = Float.valueOf(fieldWeight.getText());
            Color color = comboBoxColor.getValue();
            Integer productCount = Integer.valueOf(fieldCount.getText());
            String size = fieldSize.getText();
            String material = fieldMaterial.getText();

            Product product = new Product.Builder().setId(id)
                    .setName(name)
                    .setPrice(price)
                    .setWeight(weight)
                    .setColor(color)
                    .setProductCount(productCount)
                    .setSize(size)
                    .setMaterial(material)
                    .build();
            try {
                if (productValidator.isValidateUpdateProduct(product)) {
                    productService.updateProduct(product);
                    buttonGetAllProducts();
                    buttonClearFields();
                    labelInfo.setText("You update product!");
                }
            } catch (Exception e) {
                labelInfo.setText(e.getMessage());
            }
        }
        catch (NumberFormatException e) {
                labelInfo.setText("SOMETHING WENT WRONG!");
            }
        }

    public void buttonClearFields() {
        labelID.setText("ID: -");
        fieldName.clear();
        fieldPrice.clear();
        fieldWeight.clear();
        fieldCount.clear();
        fieldMaterial.clear();
        fieldSize.clear();
        comboBoxColor.getSelectionModel().clearSelection();
    }

    public void buttonRemoveProduct() {
        Product selectedItem = tableView.getSelectionModel().getSelectedItem();
        Long id = selectedItem.getId();
        if(productValidator.productIsAlreadyExistId(id)) {
            productService.removeProductById(id);
            buttonGetAllProducts();
            buttonClearFields();
        }
    }

    public void buttonBackToMenu(ActionEvent event) throws Exception {
        Parent mainPanelPage = FXMLLoader.load(getClass().getResource("/mainpanelpage.fxml"));
        Scene mainPanelScene = new Scene(mainPanelPage);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainPanelScene);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    TextField fieldFindName;

    public void buttonFindName() {
        String findName = fieldFindName.getText();

        ObservableList<Product> products;
        products = productService.findProductByName(findName);

        columnID.setCellValueFactory(new PropertyValueFactory<Product, Long>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));
        columnWeight.setCellValueFactory(new PropertyValueFactory<Product, Float>("weight"));
        columnColor.setCellValueFactory(new PropertyValueFactory<Product, Color>("color"));
        columnCount.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productCount"));
        columnSize.setCellValueFactory(new PropertyValueFactory<Product, String>("size"));
        columnMaterial.setCellValueFactory(new PropertyValueFactory<Product, String>("material"));

        tableView.setItems(products);
    }

    @FXML
    TextField fieldFindID;

    public void buttonFindID() {
        Long id = Long.valueOf(fieldFindID.getText());
        ObservableList<Product> products = FXCollections.observableArrayList();
        Product product = productService.findProductById(id);
        products.add(product);

        columnID.setCellValueFactory(new PropertyValueFactory<Product, Long>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));
        columnWeight.setCellValueFactory(new PropertyValueFactory<Product, Float>("weight"));
        columnColor.setCellValueFactory(new PropertyValueFactory<Product, Color>("color"));
        columnCount.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productCount"));
        columnSize.setCellValueFactory(new PropertyValueFactory<Product, String>("size"));
        columnMaterial.setCellValueFactory(new PropertyValueFactory<Product, String>("material"));

        tableView.setItems(products);
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
    public void mouseGetDataByPress() {
        Product selectedItem = tableView.getSelectionModel().getSelectedItem();
        Long id = selectedItem.getId();
        labelID.setText("ID: " + id);

        String name = selectedItem.getName();
        fieldName.setText(name);

        Float price = selectedItem.getPrice();
        fieldPrice.setText(String.valueOf(price));

        Float weight = selectedItem.getWeight();
        fieldWeight.setText(String.valueOf(weight));

        Color color = selectedItem.getColor();
        comboBoxColor.setValue(color);

        Integer count = selectedItem.getProductCount();
        fieldCount.setText(String.valueOf(count));

        String size = selectedItem.getSize();
        fieldSize.setText(size);

        String material = selectedItem.getMaterial();
        fieldMaterial.setText(material);
    }
}
