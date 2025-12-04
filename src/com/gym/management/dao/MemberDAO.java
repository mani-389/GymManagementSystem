package com.gym.management.dao;

import com.gym.management.models.Member;
import com.gym.management.utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    
    public boolean addMember(Member member) {
        String sql = "INSERT INTO members (member_id, name, contact, medical_status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, member.getMemberId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getContact());
            pstmt.setString(4, member.getMedicalStatus());
            
            int rows = pstmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Member> getAllMembers() {
        ArrayList<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setName(rs.getString("name"));
                member.setContact(rs.getString("contact"));
                member.setMedicalStatus(rs.getString("medical_status"));
                members.add(member);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return members;
    }
    
    public Member getMemberById(String memberId) {
        String sql = "SELECT * FROM members WHERE member_id = ?";
        Member member = null;
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, memberId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setName(rs.getString("name"));
                member.setContact(rs.getString("contact"));
                member.setMedicalStatus(rs.getString("medical_status"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return member;
    }
    
    public boolean updateMember(Member member) {
        String sql = "UPDATE members SET name = ?, contact = ?, medical_status = ? WHERE member_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getContact());
            pstmt.setString(3, member.getMedicalStatus());
            pstmt.setString(4, member.getMemberId());
            
            int rows = pstmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteMember(String memberId) {
        String sql = "DELETE FROM members WHERE member_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, memberId);
            int rows = pstmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Member> searchMembers(String keyword) {
        ArrayList<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members WHERE name LIKE ? OR member_id LIKE ? OR contact LIKE ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            String searchPattern = "%" + keyword + "%";
            pstmt.setString(1, searchPattern);
            pstmt.setString(2, searchPattern);
            pstmt.setString(3, searchPattern);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setName(rs.getString("name"));
                member.setContact(rs.getString("contact"));
                member.setMedicalStatus(rs.getString("medical_status"));
                members.add(member);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return members;
    }
}