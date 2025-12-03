package com.gym.management.models;

import java.util.Date;
import java.util.List;

public abstract class User {
    private String username;
    private String password;
    protected Date lastLoginTime;
    
    // Constructor
    public User() {
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    // Concrete methods
    public boolean login() {
        // Login logic here
        this.lastLoginTime = new Date();
        return true;
    }
    
    public void logout() {
        System.out.println("User logged out");
    }
    
    // Getters and Setters
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    // Abstract methods 
    public abstract void displayRole();
    public abstract List<String> getPermissions();
}