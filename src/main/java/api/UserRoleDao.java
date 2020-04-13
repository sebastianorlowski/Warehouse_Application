package api;

import entity.UserRole;

public interface UserRoleDao {
    Integer getRoleIdByName(String roleName);
    UserRole getRoleById(Integer id);
}
