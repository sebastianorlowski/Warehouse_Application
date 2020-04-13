package entity;

import validators.UserValidator;

import java.util.LinkedList;
import java.util.List;

public class User {

    private Long id;
    private String login;
    private String password;
    private String email;
    private Integer userRoleId;

    public User(Long id, String login, String password, String email, Integer userRoleId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.userRoleId = userRoleId;
    }

    public User(String login, String password, String email, Integer userRoleId) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.userRoleId = userRoleId;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    @Override
    public String toString() {
        return "ID: " + id  +
                "\nLogin: " + login +
                "\nPassword: " + password +
                "\nEmail: " + email +
                "\nRole: " + userRoleId;
    }
}
