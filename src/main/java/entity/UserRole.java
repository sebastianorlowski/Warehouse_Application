package entity;

import enums.Role;

public class UserRole {
    Integer id;
    Role role;


    public UserRole(Integer id, Role role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
