package dao;

import api.UserDao;
import api.UserRoleDao;
import entity.User;
import entity.UserRole;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final static UserDao instance = new UserDaoImpl();
    private static UserRoleDao userRoleDao = UserRoleDaoImpl.getInstance();

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
            Integer roleId = userRoleDao.getRoleIdByName(user.getUserRole().getRole().name());
            String query = "insert into " + tableName + " (login, password, email, user_role_id) values (?, ?, ?, ?)";
            statement = connection.prepareStatement(query);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, roleId);

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
            statement.executeUpdate();

            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<User> getAllUsers() {
        ObservableList<User> users = FXCollections.observableArrayList();
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
                Integer roleId = resultSet.getInt("user_role_id");
                UserRole userRole = userRoleDao.getRoleById(roleId);

                User user = new User(id, login, password, email, userRole);
                users.add(user);
            }
        statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
     }

    public List<User> findUserByLogin(String login) {
        List<User> users = new LinkedList<User>();
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
                Integer roleId = resultSet.getInt("user_role_id");
                UserRole userRole = userRoleDao.getRoleById(roleId);

                User user = new User(id, login, password, email, userRole);
                users.add(user);
            }
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<User> findUserByEmail(String email) {
        List<User> users = new LinkedList<User>();
        PreparedStatement statement;
        try {
            String query = "select * from " + tableName + " where email = '" + email + "';";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                email = resultSet.getString("email");
                Integer roleId = resultSet.getInt("user_role_id");
                UserRole userRole = userRoleDao.getRoleById(roleId);

                User user = new User(id, login, password, email, userRole);
                users.add(user);
            }
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Integer getUserRole(String login) {
        PreparedStatement statement;

        try {
            String query = "select user_role_id from " + tableName + " where login = '" + login + "'";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                Integer roleId = resultSet.getInt("user_role_id");

                return roleId;
            }
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
                statement.close();
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isCorrectLoginAndEmail(String login, String email) {
        PreparedStatement statement;
        try {
            if(login != null && email != null) {
                String query = "select * from " + tableName + " where login = '" + login + "' and email = '" + email +"';";
                statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                return true;
            }
            statement.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

