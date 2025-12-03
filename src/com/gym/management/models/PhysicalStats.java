package com.gym.management.models;

public class PhysicalStats {
    private double weight;
    private double height;
    private String description;
    
    // Constructors
    public PhysicalStats() {
    }
    
    public PhysicalStats(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }
    
    // Methods
    public double calculateBMI() {
        if (height > 0) {
            return weight / (height * height);
        }
        return 0.0;
    }
    
    public void updateStats(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }
    
    // Getters and Setters
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Weight: " + weight + "kg, Height: " + height + "m, BMI: " + 
               String.format("%.2f", calculateBMI());
    }
}