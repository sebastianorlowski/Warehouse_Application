package entity;

public class User {

    private Long id;
    private String login;
    private String password;
    private String email;
    private UserRole userRole;

    public User(Long id, String login, String password, String email, UserRole userRole) {
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

    public UserRole getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return "ID: " + id  +
                "\nLogin: " + login +
                "\nPassword: " + password +
                "\nEmail: " + email +
                "\nRole: " + userRole;
    }
}
