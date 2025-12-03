package com.gym.management.models;

import java.util.Date;

public class Payment {
    private String paymentId;
    private String paymentType;
    private double amount;
    private Date date;
    private String description;
    private String referenceId;
    
    // Constructors
    public Payment() {
    }
    
    public Payment(String paymentId, String paymentType, double amount, Date date) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.amount = amount;
        this.date = date;
    }
    
    // Methods
    public void printTransactionDetails() {
        System.out.println("=== Payment Details ===");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Type: " + paymentType);
        System.out.println("Amount: $" + amount);
        System.out.println("Date: " + date);
        System.out.println("Description: " + description);
        System.out.println("Reference: " + referenceId);
    }
    
    // Getters and Setters
    public String getPaymentId() {
        return paymentId;
    }
    
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    
    public String getPaymentType() {
        return paymentType;
    }
    
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getReferenceId() {
        return referenceId;
    }
    
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}