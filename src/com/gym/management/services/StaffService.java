package com.gym.management.services;

import com.gym.management.dao.StaffDAO;
import com.gym.management.models.Staff;
import java.util.ArrayList;

public class StaffService {
    private StaffDAO staffDAO;
    
    public StaffService() {
        this.staffDAO = new StaffDAO();
    }
    
    public void hireStaff(Staff staff) {
        if (staffDAO.addStaff(staff)) {
            System.out.println("✅ Staff hired successfully!");
        } else {
            System.out.println("❌ Failed to hire staff.");
        }
    }
    
    public void updateStaff(String staffId, Staff staff) {
        staff.setStaffId(staffId);
        if (staffDAO.updateStaff(staff)) {
            System.out.println("✅ Staff updated successfully!");
        } else {
            System.out.println("❌ Failed to update staff.");
        }
    }
    
    public void removeStaff(String staffId) {
        if (staffDAO.deleteStaff(staffId)) {
            System.out.println("✅ Staff removed successfully!");
        } else {
            System.out.println("❌ Failed to remove staff.");
        }
    }
    
    public ArrayList<Staff> getStaffDetails() {
        return staffDAO.getAllStaff();
    }
    
    public ArrayList<Staff> addTrainer() {
        ArrayList<Staff> allStaff = staffDAO.getAllStaff();
        ArrayList<Staff> trainers = new ArrayList<>();
        for (Staff staff : allStaff) {
            if (staff.getRole().equalsIgnoreCase("Trainer")) {
                trainers.add(staff);
            }
        }
        return trainers;
    }
    
    public ArrayList<Staff> searchStaff(String keyword) {
        return staffDAO.searchStaff(keyword);
    }
}