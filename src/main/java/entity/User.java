package entity;

import enums.Role;

public class User {

    private Long id;
    private String login;
    private String password;
    private String email;
    private UserRole userRole;

    private User(Long id, String login, String password, String email, UserRole userRole) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }

    public User(String login, String password, String email, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
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

    public UserRole getUserRole() { return userRole; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "ID: " + id  +
                "\nLogin: " + login +
                "\nPassword: " + password +
                "\nEmail: " + email +
                "\nRole: " + userRole;
    }

    public static class Builder {
        private Long id;
        private String login;
        private String password;
        private String email;
        private UserRole userRole;

        public Builder() {

        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setUserRole(UserRole userRole) {
            this.userRole = userRole;
            return this;
        }

        public User build() {
            return new User(id, login, password, email, userRole);
        }
    }
}
