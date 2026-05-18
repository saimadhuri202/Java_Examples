package StudentManagement;

//import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Student {
    // Properties
    private int studentId;
    private String name;
    private String course;
    private String section;
    private double maths;
    private double physics;
    private double chemistry;
    private double biology;

    // Constructor
    public Student(int studentId, String name, String course, String section) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.section = section;
        this.maths = 0.0;
        this.physics = 0.0;
        this.chemistry = 0.0;
        this.biology = 0.0;
    }

    // ==================== CREATE STUDENT METHOD ====================
    public static Student createStudent(int studentId, String name, String course, String section) {
        try {
            Connection conn = DBConnection.getConnection();
            
            // Check if student already exists
            String checkQuery = "SELECT * FROM STUDENT_MGMT WHERE NAME = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, name);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Student already exists
                showPopup("Student " + name + " already exists!");
                checkStmt.close();
                conn.close();
                return null;
            } else {
                // Student doesn't exist, create new one
                Student student = new Student(studentId, name, course, section);
                insertStudentIntoDB(student, conn);
                showPopup("New student " + name + " created successfully!");
                checkStmt.close();
                conn.close();
                return student;
            }

        } catch (SQLException e) {
            showPopup("Error creating student: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // ==================== UPDATE MARKS METHOD ====================
    public void updateMarks(String name, double maths, double physics, double chemistry, double biology) {
        try {
            Connection conn = DBConnection.getConnection();
            
            // Step 1: Check if student exists
            String checkQuery = "SELECT * FROM STUDENT_MGMT WHERE NAME = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, name);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Student exists, proceed to update marks
                String updateQuery = "UPDATE STUDENT_MGMT SET MATHS = ?, PHYSICS = ?, CHEMISTRY = ?, BIOLOGY = ? WHERE NAME = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setDouble(1, maths);
                updateStmt.setDouble(2, physics);
                updateStmt.setDouble(3, chemistry);
                updateStmt.setDouble(4, biology);
                updateStmt.setString(5, name);

                updateStmt.executeUpdate();
                showPopup("Marks updated successfully for " + name + "!");
                updateStmt.close();
            } else {
                // Student doesn't exist
                showPopup("No student " + name + " found!");
            }

            checkStmt.close();
            conn.close();

        } catch (Exception e) {
            showPopup("Error updating marks: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ==================== DISPLAY MARKS METHOD ====================
    public void displayMarks(String name) {
        try {
            Connection conn = DBConnection.getConnection();
            
            String query = "SELECT MATHS, PHYSICS, CHEMISTRY, BIOLOGY FROM STUDENT_MGMT WHERE NAME = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                double maths = rs.getDouble("MATHS");
                double physics = rs.getDouble("PHYSICS");
                double chemistry = rs.getDouble("CHEMISTRY");
                double biology = rs.getDouble("BIOLOGY");

                String displayMessage = "Marks for " + name + ":\n" +
                        "Maths: " + maths + "\n" +
                        "Physics: " + physics + "\n" +
                        "Chemistry: " + chemistry + "\n" +
                        "Biology: " + biology;
                
                showPopup(displayMessage);
            } else {
                showPopup("No student " + name + " found!");
            }

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            showPopup("Error displaying marks: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ==================== HELPER METHOD: INSERT STUDENT INTO DB ====================
    private static void insertStudentIntoDB(Student s, Connection conn) {
        try {
            String insertQuery = "INSERT INTO STUDENT_MGMT (STUDENT_ID, NAME, COURSE, SECTION) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, s.getStudentId());
            pstmt.setString(2, s.getName());
            pstmt.setString(3, s.getCourse());
            pstmt.setString(4, s.getSection());
            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            showPopup("Error inserting student: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ==================== HELPER METHOD: SHOW POPUP ====================
    private static void showPopup(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    // ==================== GETTERS ====================
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getSection() {
        return section;
    }

    public double getMaths() {
        return maths;
    }

    public double getPhysics() {
        return physics;
    }

    public double getChemistry() {
        return chemistry;
    }

    public double getBiology() {
        return biology;
    }

    // ==================== SETTERS ====================
    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setMaths(double maths) {
        this.maths = maths;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public void setBiology(double biology) {
        this.biology = biology;
    }
}