package com.gym.management.dao;

import com.gym.management.models.Payment;
import com.gym.management.utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;

public class PaymentDAO {
    
    public boolean addPayment(Payment payment) {
        String sql = "INSERT INTO payments (payment_id, payment_type, amount, payment_date, description, reference_id) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, payment.getPaymentId());
            pstmt.setString(2, payment.getPaymentType());
            pstmt.setDouble(3, payment.getAmount());
            pstmt.setDate(4, new java.sql.Date(payment.getDate().getTime()));
            pstmt.setString(5, payment.getDescription());
            pstmt.setString(6, payment.getReferenceId());
            
            int rows = pstmt.executeUpdate();
            return rows > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Payment> getAllPayments() {
        ArrayList<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payments";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setPaymentId(rs.getString("payment_id"));
                payment.setPaymentType(rs.getString("payment_type"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setDate(rs.getDate("payment_date"));
                payment.setDescription(rs.getString("description"));
                payment.setReferenceId(rs.getString("reference_id"));
                payments.add(payment);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return payments;
    }
    
    public ArrayList<Payment> getPaymentsByType(String paymentType) {
        ArrayList<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payments WHERE payment_type = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, paymentType);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setPaymentId(rs.getString("payment_id"));
                payment.setPaymentType(rs.getString("payment_type"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setDate(rs.getDate("payment_date"));
                payment.setDescription(rs.getString("description"));
                payment.setReferenceId(rs.getString("reference_id"));
                payments.add(payment);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return payments;
    }
    
    public double getTotalRevenue() {
        String sql = "SELECT SUM(amount) as total FROM payments WHERE payment_type = 'MEMBERSHIP_FEE'";
        double total = 0.0;
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                total = rs.getDouble("total");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return total;
    }
}