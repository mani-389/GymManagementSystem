# 🏋️‍♂️ Gym Management System (Java OOP & Swing)

A desktop management application built with Java Swing and Object-Oriented Programming (OOP) principles to streamline gym operations, member tracking, staff administration, and financial reporting.

---

## ✨ Key Features

* **👤 Member Management:** Comprehensive tracking of gym members (`MemberManagementFrame.java`, `MemberDAO.java`).
* **📊 Physical Stats Tracking:** Record and monitor member fitness progress and health metrics (`PhysicalStatsFrame.java`).
* **💳 Finance & Payments:** Track subscription fees, payment histories, and overall revenue streams (`FinanceFrame.java`, `PaymentDAO.java`).
* **💼 Staff Administration:** Manage gym trainers, staff schedules, and operational roles (`StaffManagementFrame.java`, `StaffDAO.java`).
* **🔐 Admin Dashboard:** Centralized control panel providing quick navigation to all subsystem modules (`AdminDashboard.java`).

---

## 🛠️ Tech Stack & Architecture

* **Language:** Java (JDK 8+)
* **UI Framework:** Java Swing & AWT (NetBeans Form Designer)
* **Architecture & Patterns:**
  * **Data Access Object (DAO):** Decouples business logic from database operations (`MemberDAO`, `PaymentDAO`, `StaffDAO`).
  * **Model-View-Controller (MVC):** GUI frames are strictly separated from underlying data models and database operations.

---

## 📁 Project Structure

```text
GymManagementSystem/
├── src/
│   └── com/
│       └── gym/
│           └── management/
│               ├── gui/         # Swing UI Frames (AdminDashboard, Frames)
│               ├── dao/         # Data Access Object implementations
│               ├── model/       # Data entities & domain models
│               └── util/        # Database connectivity & helper utilities
├── build.xml                    # Ant build script
├── manifest.mf                  # JAR manifest configuration
└── README.md                    # Project documentation
