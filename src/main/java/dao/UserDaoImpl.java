package dao;

import api.UserDao;
import entity.User;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final static UserDao instance = new UserDaoImpl();

    private Connection connection;
    private final String databaseName = "warehouse";
    private final String tableName = "users";
    private final String user = "root";
    private final String password = "respeck";

    private UserDaoImpl() {
        init();
    }

    public static UserDao getInstance() {
        return UserDaoImpl.instance;
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+databaseName+"?useSSL=false", user, password);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        PreparedStatement statement;
        try {
            String query = "insert into " + tableName + " (login, password, email) values (?, ?, ?)";
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

    public void removeUserById(Long id) {
        PreparedStatement statement;
        try {
            String query = "delete from " + tableName + " where id = ?";
            statement = connection.prepareStatement(query);
            statement.setLong(1, id);

            statement.execute();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserByLogin(String login) {
        PreparedStatement statement;

        try {
            String query = "delete from " + tableName + " where login = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, login);

            statement.execute();
            statement.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserPassword(String login, String password, String newPassword) {
        PreparedStatement statement;

        try {
            String query = "update " + tableName + " set password = ? where login = ? and password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, newPassword);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.executeUpdate();

            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserEmail(String login, String email, String newEmail) {
        PreparedStatement statement;

        try {
            String query = "update " + tableName + " set email = ? where login = ? and email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, newEmail);
            statement.setString(2, login);
            statement.setString(3, email);
            statement.executeUpdate(query);

            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new LinkedList<User>();
        PreparedStatement statement;

        try {
            String query = "select * from " + tableName;
            statement = connection.prepareStatement(query);
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

     public void findUserById(Long id) {
        PreparedStatement statement;

        try {
            String query = "select * from " + tableName + " where id = " + id;
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                id = resultSet.getLong("id");
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
         System.out.println(user);
      }

    public void findUserByLogin(String login) {
        PreparedStatement statement;
        try {
            String query = "select * from " + tableName + " where login = '" + login + "';";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Long id = resultSet.getLong("id");
                login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");

                User user = new User(id, login, password, email);
                System.out.println(user);
            }
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isCorrectLoginAndPassword(String login, String password) {
        PreparedStatement statement;
        try {
            if (login != null && password != null) {
                String query = "select * from " + tableName + " where login = '" + login + "' and password = '" + password + "';";
                statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery(query);
                if(resultSet.next()) {
                    return true;
                }
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

