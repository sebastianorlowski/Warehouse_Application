package dao;

import api.UserRoleDao;
import entity.UserRole;
import enums.Role;

import java.sql.*;

public class UserRoleDaoImpl implements UserRoleDao {
    private Connection connection;
    private final String databaseName = "warehouse";
    private final String tableName = "roles";
    private final String user = "root";
    private final String password = "respeck";

    private final static UserRoleDao instance = new UserRoleDaoImpl();
    public static UserRoleDao getInstance() {
        return UserRoleDaoImpl.instance;
    }

    public UserRoleDaoImpl() {
        init();
    }

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getRoleIdByName(String roleName) {
        PreparedStatement statement;

        try {
            String query = "select * from " + tableName + " where role = '" + roleName + "'";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public UserRole getRoleById(Integer id) {
        PreparedStatement statement;

        try {
            String query = "select * from " + tableName + " where id = '" + id + "'";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String role = resultSet.getString("role");
                Role userRole = Role.valueOf(role);

                return new UserRole(id, userRole);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
