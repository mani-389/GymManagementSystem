package com.gym.management.models;

public class Member implements Searchable {
    private String memberId;
    private String name;
    private String contact;
    private String medicalStatus;
    private Membership membership;
    private Staff assignedTrainer;
    private PhysicalStats physicalStats;  // Composition
    
    // Constructors
    public Member() {
        this.physicalStats = new PhysicalStats();  // Created with Member
    }
    
    public Member(String name, String contact) {
        this.name = name;
        this.contact = contact;
        this.physicalStats = new PhysicalStats();  // Composition - created together
    }
    
    // Implement Searchable interface
    @Override
    public boolean search(String keyword) {
        keyword = keyword.toLowerCase();
        return this.name.toLowerCase().contains(keyword) ||
               this.memberId.toLowerCase().contains(keyword) ||
               this.contact.contains(keyword);
    }
    
    // Getters and Setters
    public String getMemberId() {
        return memberId;
    }
    
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getContact() {
        return contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public String getMedicalStatus() {
        return medicalStatus;
    }
    
    public void setMedicalStatus(String medicalStatus) {
        this.medicalStatus = medicalStatus;
    }
    
    public Membership getMembership() {
        return membership;
    }
    
    public void setMembership(Membership membership) {
        this.membership = membership;
    }
    
    public Staff getAssignedTrainer() {
        return assignedTrainer;
    }
    
    public void setAssignedTrainer(Staff assignedTrainer) {
        this.assignedTrainer = assignedTrainer;
    }
    
    public PhysicalStats getPhysicalStats() {
        return physicalStats;
    }
    
    public void setPhysicalStats(PhysicalStats physicalStats) {
        this.physicalStats = physicalStats;
    }
    
    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name + ", Contact: " + contact;
    }
}