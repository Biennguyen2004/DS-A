/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 *
 * @author biennguyen0304
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            StudentStack stack = new StudentStack();
            stack.push(new Student(1, "John Doe", 7.5));
            System.out.println("✅ Test Case 1 Passed: Added valid student.");
        } catch (Exception e) {
            System.out.println("❌ Test Case 1 Failed: " + e.getMessage());
        }
        try {
            StudentStack stack = new StudentStack();
            stack.push(new Student(-1, "Invalid ID", 8.0));
            System.out.println("❌ Test Case 2 Failed: Accepted invalid student ID.");
        } catch (Exception e) {
            System.out.println("✅ Test Case 2 Passed: " + e.getMessage());
        }
        try {
            StudentStack stack = new StudentStack();
            stack.push(new Student(2, "Invalid123", 8.0));
            System.out.println("❌ Test Case 3 Failed: Accepted invalid student name.");
        } catch (Exception e) {
            System.out.println("✅ Test Case 3 Passed: " + e.getMessage());
        }
        try {
            StudentStack stack = new StudentStack();
            stack.push(new Student(3, "Valid Name", 11.0));
            System.out.println("❌ Test Case 4 Failed: Accepted invalid marks.");
        } catch (Exception e) {
            System.out.println("✅ Test Case 4 Passed: " + e.getMessage());
        }
        try {
            StudentStack stack = new StudentStack();
            stack.pop();
            System.out.println("✅ Test Case 5 Passed: Handled empty stack removal gracefully.");
        } catch (Exception e) {
            System.out.println("❌ Test Case 5 Failed: " + e.getMessage());
        }
        try {
            StudentStack stack = new StudentStack();
            stack.binarySearchById(99);
            System.out.println("✅ Test Case 6 Passed: Handled non-existing student search gracefully.");
        } catch (Exception e) {
            System.out.println("❌ Test Case 6 Failed: " + e.getMessage());
        }
        try {
            StudentStack stack = new StudentStack();
            stack.updateStudent(99, "New Name", 9.0);
            System.out.println("✅ Test Case 7 Passed: Handled non-existing student update gracefully.");
        } catch (Exception e) {
            System.out.println("❌ Test Case 7 Failed: " + e.getMessage());
        }
        try {
            StudentStack stack = new StudentStack();
            stack.push(new Student(1, "Alice", 9.0));
            stack.push(new Student(2, "Bob", 7.0));
            stack.push(new Student(3, "Charlie", 8.0));
            stack.sortAscending();
            stack.displayStack();
            System.out.println("✅ Test Case 8 Passed: Students sorted in ascending order.");
        } catch (Exception e) {
            System.out.println("❌ Test Case 8 Failed: " + e.getMessage());
        }
        try {
            StudentStack stack = new StudentStack();
            stack.push(new Student(1, "John Doe", 8.0));
            stack.push(new Student(1, "Duplicate ID", 7.0));
            System.out.println("❌ Test Case 9 Failed: Accepted duplicate student ID.");
        } catch (Exception e) {
            System.out.println("✅ Test Case 9 Passed: " + e.getMessage());
        }
        try {
            StudentStack stack = new StudentStack();
            stack.displayStack();
            System.out.println("✅ Test Case 10 Passed: Handled empty stack traversal gracefully.");
        } catch (Exception e) {
            System.out.println("❌ Test Case 10 Failed: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        StudentStack studentStack = new StudentStack();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Last Added Student");
            System.out.println("3. View Last Added Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Sort in Ascending Order by Marks");
            System.out.println("6. Sort in Descending Order by Marks");
            System.out.println("7. Update Student by ID");
            System.out.println("8. Exit");
            System.out.println("9. Binary Search by ID");
            System.out.println("10. Sort Students by Marks using Merge Sort (Ascending)");
            System.out.println("11. Sort Students by Marks using Merge Sort (Descending)");
            System.out.println("12. Linear Search by ID");
            System.out.println("13. BFS Traver9sal");
            System.out.println("14. Add a New Student");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();
                    Student student = new Student(id, name, marks);
                    studentStack.push(student);
                    break;
                case 2:
                    Student removedStudent = studentStack.pop();
                    if (removedStudent != null) {
                        System.out.println("Removed: " + removedStudent);
                    }
                    break;
                case 3:
                    Student lastAddedStudent = studentStack.peek();
                    if (lastAddedStudent != null) {
                        System.out.println("Last added student: " + lastAddedStudent);
                    }
                    break;
                case 4:
                    System.out.println("\nAll students in the stack:");
                    studentStack.displayStack();
                    break;
                case 5:
                    studentStack.sortAscending();
                    studentStack.displayStack();
                    break;
                case 6:
                    studentStack.sortDescending();
                    studentStack.displayStack();
                    break;
                case 7:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    double newMarks = scanner.nextDouble();
                    studentStack.updateStudent(updateId, newName, newMarks);
                    break;
                case 8:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                case 9:
                    System.out.print("Enter Student ID to search using Binary Search: ");
                    int binarySearchId = scanner.nextInt();
                    studentStack.binarySearchById(binarySearchId);
                    break;
                case 10:
                    studentStack.mergeSortAscending();
                    studentStack.displayStack();
                    break;
                case 11:
                    studentStack.mergeSortDescending();
                    studentStack.displayStack();
                    break;
                case 12:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    studentStack.linearSearchById(searchId);
                    break;
                case 13:
                    System.out.println("BFS Traversal of Students:");
                    studentStack.bfsTraversal();
                    break;
                case 14:
                    System.out.println("Adding a new student...");
                    System.out.print("Enter Student ID: ");
                    int newStudentId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String newStudentName = scanner.nextLine(); // Renamed variable
                    System.out.print("Enter Student Marks: ");
                    double newStudentMarks = scanner.nextDouble(); // Renamed variable
                    studentStack.addNewStudent(new Student(newStudentId, newStudentName, newStudentMarks));
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }
}
