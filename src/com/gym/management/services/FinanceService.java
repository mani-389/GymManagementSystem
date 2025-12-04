package com.gym.management.services;

import com.gym.management.dao.PaymentDAO;
import com.gym.management.models.Payment;
import com.gym.management.models.Staff;
import java.util.ArrayList;
import java.util.Date;

public class FinanceService {
    private PaymentDAO paymentDAO;
    
    public FinanceService() {
        this.paymentDAO = new PaymentDAO();
    }
    
    public void recordPayment(Payment payment) {
        if (paymentDAO.addPayment(payment)) {
            System.out.println("✅ Payment recorded successfully!");
        } else {
            System.out.println("❌ Failed to record payment.");
        }
    }
    
    public void processSalary(Staff staff, double amount) {
        Payment salaryPayment = new Payment();
        salaryPayment.setPaymentId("PAY" + System.currentTimeMillis());
        salaryPayment.setPaymentType("SALARY");
        salaryPayment.setAmount(amount);
        salaryPayment.setDate(new Date());
        salaryPayment.setDescription("Salary for " + staff.getName());
        salaryPayment.setReferenceId(staff.getStaffId());
        
        recordPayment(salaryPayment);
    }
    
    public ArrayList<Payment> getPaymentDetails() {
        return paymentDAO.getAllPayments();
    }
    
    public double getTotalRevenue() {
        return paymentDAO.getTotalRevenue();
    }
    
    public double getTotalOutcome() {
        double total = 0.0;
        ArrayList<Payment> salaries = paymentDAO.getPaymentsByType("SALARY");
        for (Payment payment : salaries) {
            total += payment.getAmount();
        }
        return total;
    }
}