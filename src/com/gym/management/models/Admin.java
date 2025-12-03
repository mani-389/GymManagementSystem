package com.gym.management.models;

import com.gym.management.services.MemberService;
import com.gym.management.services.StaffService;
import com.gym.management.services.FinanceService;
import java.util.Arrays;
import java.util.List;

public class Admin extends User {
    private MemberService memberService;
    private StaffService staffService;
    private FinanceService financeService;
    protected int adminLevel;
    
    // Constructor
    public Admin() {
        super();
    }
    
    public Admin(String username, String password) {
        super(username, password);
        this.memberService = new MemberService();
        this.staffService = new StaffService();
        this.financeService = new FinanceService();
        this.adminLevel = 1;
    }
    
    // Implement abstract methods from User
    @Override
    public void displayRole() {
        System.out.println("Role: Administrator");
        System.out.println("Admin Level: " + adminLevel);
    }
    
    @Override
    public List<String> getPermissions() {
        return Arrays.asList("CREATE", "READ", "UPDATE", "DELETE", "MANAGE_ALL");
    }
    
    // Admin specific methods
    protected boolean validateAdminAccess() {
        return adminLevel > 0;
    }
    
    // Getters and Setters
    public MemberService getMemberService() {
        return memberService;
    }
    
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
    
    public StaffService getStaffService() {
        return staffService;
    }
    
    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }
    
    public FinanceService getFinanceService() {
        return financeService;
    }
    
    public void setFinanceService(FinanceService financeService) {
        this.financeService = financeService;
    }
    
    public int getAdminLevel() {
        return adminLevel;
    }
    
    public void setAdminLevel(int adminLevel) {
        this.adminLevel = adminLevel;
    }
}