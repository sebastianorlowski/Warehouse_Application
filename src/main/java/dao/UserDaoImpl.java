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
            String query = "delete from " + tableName + " where id = ? ";
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
            String query = "delete from " + tableName + " where login = ? ";
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
            String query = "update " + tableName + " set password = ? where login = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, password);
            statement.setString(2, login);
            statement.executeUpdate();

            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserEmail(String login, String email) {
        PreparedStatement statement;

        try {
            String query = "update " + tableName + " set email = ? where login = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, login);
            statement.executeUpdate(query);

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
            String query = "select * from " + tableName;
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
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName + " where id = " + id;
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");

                User user = new User(id, login, password, email);
                users.add(user);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
         System.out.println(user);
      }

    public void findUserByLogin(String login) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from " + tableName + " where login = " + login;
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Long id = resultSet.getLong("id");
                login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");

                User user = new User(id, login, password, email);
                users.add(user);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}

