package com.gym.management.services;

import com.gym.management.dao.MemberDAO;
import com.gym.management.models.Member;
import com.gym.management.models.Staff;
import java.util.ArrayList;

public class MemberService {
    private MemberDAO memberDAO;
    
    public MemberService() {
        this.memberDAO = new MemberDAO();
    }
    
    public void addMember(Member member) {
        if (memberDAO.addMember(member)) {
            System.out.println(" Member added successfully!");
        } else {
            System.out.println(" Failed to add member.");
        }
    }
    
    public void updateMember(String memberId, Member member) {
        member.setMemberId(memberId);
        if (memberDAO.updateMember(member)) {
            System.out.println(" Member updated successfully!");
        } else {
            System.out.println(" Failed to update member.");
        }
    }
    
    public void deleteMember(String memberId) {
        if (memberDAO.deleteMember(memberId)) {
            System.out.println(" Member deleted successfully!");
        } else {
            System.out.println(" Failed to delete member.");
        }
    }
    
    public ArrayList<Member> getMemberDetails() {
        return memberDAO.getAllMembers();
    }
    
    public void assignTrainer(Member member, Staff trainer) {
        member.setAssignedTrainer(trainer);
        memberDAO.updateMember(member);
        System.out.println(" Trainer assigned to member: " + member.getName());
    }
    
    public ArrayList<Member> retrieveMembers(String keyword) {
        return memberDAO.searchMembers(keyword);
    }
}