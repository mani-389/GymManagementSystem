# 🏋️‍♂️ Gym Management System (Java OOP & Swing)

A desktop-based management application built with Java Swing and Object-Oriented Programming (OOP) principles to streamline gym operations, member tracking, staff management, and financial reporting.

---

## ✨ Key Features

* 👤 **Member Management:** Comprehensive tracking of gym members (`MemberManagementFrame.java`, `MemberDAO.java`).
* 📊 **Physical Stats Tracking:** Record and monitor member fitness progress and metrics (`PhysicalStatsFrame.java`).
* 💳 **Finance & Payments:** Track subscription fees, payment records, and revenue streams (`FinanceFrame.java`, `PaymentDAO.java`).
* 💼 **Staff Administration:** Manage gym trainers, staff schedules, and roles (`StaffManagementFrame.java`, `StaffDAO.java`).
* 🔐 **Admin Dashboard:** Centralized control panel providing quick navigation to all subsystem modules (`AdminDashboard.java`).

---

## 🛠️ Tech Stack & Architecture

* **Language:** Java (JDK 8+)
* **UI Framework:** Java Swing & AWT (NetBeans Form Designer)
* **Design Patterns:** 
  * **Data Access Object (DAO):** Decouples business logic from database operations (`MemberDAO`, `PaymentDAO`, `StaffDAO`).
  * **Model-View-Controller (MVC):** GUI frames separated from underlying data models and database layers.

---

## 📁 Directory Structure

```text
GymManagementSystem/
├── src/
│   └── com/
│       └── gym/
│           └── management/
│               ├── gui/         # Swing UI Frames (AdminDashboard, Frames)
│               └── ...          # Core DAO logic, Models, and Utilities
├── build.xml                    # Ant build script
├── manifest.mf                  # JAR manifest configuration
└── README.md                    # Project documentation