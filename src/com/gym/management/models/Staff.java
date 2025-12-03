package com.gym.management.models;

public class Staff implements Searchable {
    private String staffId;
    private String name;
    private double salary;
    private String role;
    
    // Constructors
    public Staff() {
    }
    
    public Staff(String staffId, String name, double salary, String role) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
        this.role = role;
    }
    
    // Implement Searchable interface
    @Override
    public boolean search(String keyword) {
        keyword = keyword.toLowerCase();
        return this.name.toLowerCase().contains(keyword) ||
               this.staffId.toLowerCase().contains(keyword) ||
               this.role.toLowerCase().contains(keyword);
    }
    
    // Methods
    public boolean canCheckIn(String keyword) {
        return search(keyword);
    }
    
    // Getters and Setters
    public String getStaffId() {
        return staffId;
    }
    
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        return "Staff ID: " + staffId + ", Name: " + name + ", Role: " + role;
    }
}