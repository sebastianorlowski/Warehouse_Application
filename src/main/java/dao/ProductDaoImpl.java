package dao;

import api.ProductDao;
import entity.Product;
import enums.Color;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class ProductDaoImpl implements ProductDao {
    private final static ProductDao instance = new ProductDaoImpl();
    public static ProductDao getInstance() {
        return ProductDaoImpl.instance;
    }

    private Connection connection;
    private final String tableName = "product";
    private String query;

    public ProductDaoImpl() {
        init();
    }

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseName = "warehouse";
            String user = "root";
            String password = "respeck";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product) {
        PreparedStatement statement;
        try {
            query = "insert into " + tableName + " (name, price, weight, color, productcount, size, material) values (?, ?, ?, ?, ?, ?, ?) ";
            statement = connection.prepareStatement(query);
            statement.setString(1, product.getName());
            statement.setFloat(2, product.getPrice());
            statement.setFloat(3, product.getWeight());
            statement.setString(4, product.getColor().name());
            statement.setInt(5, product.getProductCount());
            statement.setString(6, product.getSize());
            statement.setString(7, product.getMaterial());
            statement.execute();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeProductById(Long id) {
        PreparedStatement statement;
        try {
            query = "delete from " + tableName + " where id = ?";
            statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            statement.execute();

            statement.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        PreparedStatement statement;
        try {
            query = "update " + tableName + " set name = ?, price = ?, weight = ?, color = ?, productcount = ?, size = ?," +
                    " material = ? where id = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, product.getName());
            statement.setFloat(2, product.getPrice());
            statement.setFloat(3, product.getWeight());
            statement.setString(4, product.getColor().name());
            statement.setInt(5, product.getProductCount());
            statement.setString(6, product.getSize());
            statement.setString(7, product.getMaterial());
            statement.setLong(8, product.getId());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Product> findProductByName(String productName) {
        ObservableList<Product> products = FXCollections.observableArrayList();
        PreparedStatement statement;

        try {
            query = "select * from " + tableName + " where name = " + "'" + productName + "';";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Float price = resultSet.getFloat("price");
                Float weight = resultSet.getFloat("weight");
                Color color = Color.valueOf(resultSet.getString(("color")));
                Integer productCount = resultSet.getInt("productcount");
                String size = resultSet.getString("size");
                String material = resultSet.getString("material");

                Product product = new Product.Builder().setId(id)
                        .setName(name)
                        .setPrice(price)
                        .setWeight(weight)
                        .setColor(color)
                        .setProductCount(productCount)
                        .setSize(size)
                        .setMaterial(material)
                        .build();

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public ObservableList<Product> getAllProducts(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        PreparedStatement statement;
        try {
            query = "select * from " + tableName;
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Float price = resultSet.getFloat("price");
                Float weight = resultSet.getFloat("weight");
                Color color = Color.valueOf(resultSet.getString(("color")));
                Integer productCount = resultSet.getInt("productcount");
                String size = resultSet.getString("size");
                String material = resultSet.getString("material");

                Product product = new Product.Builder().setId(id)
                        .setName(name)
                        .setPrice(price)
                        .setWeight(weight)
                        .setColor(color)
                        .setProductCount(productCount)
                        .setSize(size)
                        .setMaterial(material)
                        .build();
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
