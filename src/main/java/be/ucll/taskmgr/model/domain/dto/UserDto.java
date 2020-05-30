package be.ucll.taskmgr.model.domain.dto;

import be.ucll.taskmgr.model.UserRole;

public class UserDto {
    private int id;
    private String username;
    private UserRole role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
