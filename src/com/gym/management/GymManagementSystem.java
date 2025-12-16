package com.gym.management;

import com.gym.management.gui.LoginFrame;
import com.gym.management.utils.DatabaseConnection; // Ensure this is accessible
import javax.swing.SwingUtilities;

/**
 * Main entry point for the Gym Management System application.
 */
public class GymManagementSystem {

    public static void main(String[] args) {
        // 1. Initialize Database (Optional, but good practice to check connection early)
        // Check if the Derby database is accessible before launching the GUI.
        System.out.println("Attempting to initialize application services...");
        DatabaseConnection.getConnection(); 
        
        // 2. Launch the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            System.out.println("Launching Login Frame...");
            
            // NOTE: You will need to create the LoginFrame class in the 
            // 'com.gym.management.gui' package next!
            LoginFrame login = new LoginFrame();
            login.setLocationRelativeTo(null); // Center the frame
            login.setVisible(true);
        });
    }
}