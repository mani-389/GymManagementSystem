package com.gym.management.models;

import java.util.Date;

public class Membership {
    private String membershipId;
    private Date startDate;
    private Date endDate;
    private double fee;
    private String membershipType;
    
    // Constructors
    public Membership() {
    }
    
    public Membership(String membershipId, String membershipType, double fee) {
        this.membershipId = membershipId;
        this.membershipType = membershipType;
        this.fee = fee;
        this.startDate = new Date();
    }
    
    // Methods
    public boolean checkIsActive() {
        Date today = new Date();
        return today.after(startDate) && today.before(endDate);
    }
    
    // Getters and Setters
    public String getMembershipId() {
        return membershipId;
    }
    
    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public double getFee() {
        return fee;
    }
    
    public void setFee(double fee) {
        this.fee = fee;
    }
    
    public String getMembershipType() {
        return membershipType;
    }
    
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
    
    @Override
    public String toString() {
        return "Membership ID: " + membershipId + ", Type: " + membershipType + 
               ", Fee: $" + fee + ", Active: " + checkIsActive();
    }
}