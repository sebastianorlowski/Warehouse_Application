package dao;

import api.UserDao;
import entity.User;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private Connection connection;
    private final String databaseName = "warehouse";
    private final String tableName = "users";
    private final String user = "root";
    private final String password = "respeck";

    private String query;

    public void connectToSql() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false" , user, password);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        PreparedStatement statement;
        try {
            query = "insert into " + tableName + " (login, password, email) values ?, ?, ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());

            statement.execute();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(String login) {
        PreparedStatement statement;

        try {
            query = "delete from " + tableName + " where login = ? ";
            statement = connection.prepareStatement(query);
            statement.setString(1, login);

            statement.execute();
            statement.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserPassword(String login, String password) {
        PreparedStatement statement;

        try {
            query = "update " + tableName + " set password = ? where login = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, password);
            statement.setString(2, login);
            statement.execute();

            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserEmail(String login, String email) {
        PreparedStatement statement;

        try {
            query = "update " + tableName + " set email = ? where login = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, login);
            statement.execute();

            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new LinkedList<User>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");

                User user = new User(id, login, password, email);
                users.add(user);
            }
        statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
     }
}
