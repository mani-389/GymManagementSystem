package com.gym.management.dao;

import com.gym.management.models.Staff;
import com.gym.management.utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;

public class StaffDAO {
    
    public boolean addStaff(Staff staff) {
        String sql = "INSERT INTO staff (staff_id, name, salary, role) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, staff.getStaffId());
            pstmt.setString(2, staff.getName());
            pstmt.setDouble(3, staff.getSalary());
            pstmt.setString(4, staff.getRole());
            
            int rows = pstmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Staff> getAllStaff() {
        ArrayList<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM staff";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffId(rs.getString("staff_id"));
                staff.setName(rs.getString("name"));
                staff.setSalary(rs.getDouble("salary"));
                staff.setRole(rs.getString("role"));
                staffList.add(staff);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return staffList;
    }
    
    public Staff getStaffById(String staffId) {
        String sql = "SELECT * FROM staff WHERE staff_id = ?";
        Staff staff = null;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, staffId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                staff = new Staff();
                staff.setStaffId(rs.getString("staff_id"));
                staff.setName(rs.getString("name"));
                staff.setSalary(rs.getDouble("salary"));
                staff.setRole(rs.getString("role"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return staff;
    }
    
    public boolean updateStaff(Staff staff) {
        String sql = "UPDATE staff SET name = ?, salary = ?, role = ? WHERE staff_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, staff.getName());
            pstmt.setDouble(2, staff.getSalary());
            pstmt.setString(3, staff.getRole());
            pstmt.setString(4, staff.getStaffId());
            
            int rows = pstmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteStaff(String staffId) {
        String sql = "DELETE FROM staff WHERE staff_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, staffId);
            int rows = pstmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Staff> searchStaff(String keyword) {
        ArrayList<Staff> staffList = new ArrayList<>();
        String sql = "SELECT * FROM staff WHERE name LIKE ? OR staff_id LIKE ? OR role LIKE ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            String searchPattern = "%" + keyword + "%";
            pstmt.setString(1, searchPattern);
            pstmt.setString(2, searchPattern);
            pstmt.setString(3, searchPattern);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffId(rs.getString("staff_id"));
                staff.setName(rs.getString("name"));
                staff.setSalary(rs.getDouble("salary"));
                staff.setRole(rs.getString("role"));
                staffList.add(staff);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return staffList;
    }
}