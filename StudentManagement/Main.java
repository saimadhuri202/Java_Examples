// package StudentManagement;

// import javax.swing.JOptionPane;

// public class Main {
//     public static void main(String[] args) {
        
//         // Keep running until user exits
//         boolean continueProgram = true;
        
//         while (continueProgram) {
//             // Show menu options
//             String[] options = {"Create New Student", "Update Marks", "Display Marks", "Exit"};
//             int choice = JOptionPane.showOptionDialog(
//                 null,
//                 "Student Management System\nWhat would you like to do?",
//                 "Main Menu",
//                 JOptionPane.DEFAULT_OPTION,
//                 JOptionPane.INFORMATION_MESSAGE,
//                 null,
//                 options,
//                 options[0]
//             );

//             // Handle user choice
//             switch (choice) {
//                 case 0:  // Create New Student
//                     createNewStudent();
//                     break;

//                 case 1:  // Update Marks
//                     updateStudentMarks();
//                     break;

//                 case 2:  // Display Marks
//                     displayStudentMarks();
//                     break;

//                 case 3:  // Exit
//                     continueProgram = false;
//                     JOptionPane.showMessageDialog(null, "Thank you for using Student Management System!");
//                     break;

//                 default:  // If user closes dialog
//                     continueProgram = false;
//                     break;
//             }
//         }
//     }

//     // ==================== CREATE NEW STUDENT METHOD ====================
//     private static void createNewStudent() {
//         try {
//             // Get student ID
//             String idInput = JOptionPane.showInputDialog("Enter Student ID:");
//             if (idInput == null) return;  // User cancelled
//             int studentId = Integer.parseInt(idInput);

//             // Get student name
//             String name = JOptionPane.showInputDialog("Enter Student Name:");
//             if (name == null) return;  // User cancelled

//             // Get course
//             String course = JOptionPane.showInputDialog("Enter Course:");
//             if (course == null) return;  // User cancelled

//             // Get section
//             String section = JOptionPane.showInputDialog("Enter Section:");
//             if (section == null) return;  // User cancelled

//             // Call createStudent static method
//             Student student = Student.createStudent(studentId, name, course, section);

//         } catch (NumberFormatException e) {
//             JOptionPane.showMessageDialog(null, "Invalid Student ID! Please enter a number.");
//         } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//         }
//     }

//     // ==================== UPDATE MARKS METHOD ====================
//     private static void updateStudentMarks() {
//         try {
//             // Get student name
//             String name = JOptionPane.showInputDialog("Enter Student Name to update marks:");
//             if (name == null) return;  // User cancelled

//             // Get marks for 4 subjects
//             String mathsInput = JOptionPane.showInputDialog("Enter Maths marks (0-100):");
//             if (mathsInput == null) return;
//             double maths = Double.parseDouble(mathsInput);

//             String physicsInput = JOptionPane.showInputDialog("Enter Physics marks (0-100):");
//             if (physicsInput == null) return;
//             double physics = Double.parseDouble(physicsInput);

//             String chemistryInput = JOptionPane.showInputDialog("Enter Chemistry marks (0-100):");
//             if (chemistryInput == null) return;
//             double chemistry = Double.parseDouble(chemistryInput);

//             String biologyInput = JOptionPane.showInputDialog("Enter Biology marks (0-100):");
//             if (biologyInput == null) return;
//             double biology = Double.parseDouble(biologyInput);

//             // Create a temporary Student object to call updateMarks()
//             Student student = new Student(0, name, "", "");
//             student.updateMarks(name, maths, physics, chemistry, biology);

//         } catch (NumberFormatException e) {
//             JOptionPane.showMessageDialog(null, "Invalid marks! Please enter numbers only.");
//         } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//         }
//     }

//     // ==================== DISPLAY MARKS METHOD ====================
//     private static void displayStudentMarks() {
//         try {
//             // Get student name
//             String name = JOptionPane.showInputDialog("Enter Student Name to view marks:");
//             if (name == null) return;  // User cancelled

//             // Create a temporary Student object to call displayMarks()
//             Student student = new Student(0, name, "", "");
//             student.displayMarks(name);

//         } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//         }
//     }
// }