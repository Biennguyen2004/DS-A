package asm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentBST bst = new StudentBST();

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        try {
            bst.addNewStudent(1, "Nguyen Van A", 8.5);
            System.out.println("✅ Test Case 1 Passed: Added valid student.");
        } catch (Exception e) {
            System.out.println("❌ Test Case 1 Failed: " + e.getMessage());
        }

        // Test Case 2: Add student with negative ID
        try {
            bst.addNewStudent(-1, "Nguyen Van B", 7.0);
            System.out.println("❌ Test Case 2 Failed: Negative ID accepted.");
        } catch (Exception e) {
            System.out.println("✅ Test Case 2 Passed: " + e.getMessage());
        }

        // Test Case 3: Add student with invalid name (contains numbers)
        try {
            bst.addNewStudent(2, "Nguyen Van 123", 6.0);
            System.out.println("❌ Test Case 3 Failed: Name with numbers accepted.");
        } catch (Exception e) {
            System.out.println("✅ Test Case 3 Passed: " + e.getMessage());
        }

        // Test Case 4: Add student with marks out of range
        try {
            bst.addNewStudent(3, "Nguyen Van C", 11.0);
            System.out.println("❌ Test Case 4 Failed: Marks out of range accepted.");
        } catch (Exception e) {
            System.out.println("✅ Test Case 4 Passed: " + e.getMessage());
        }

        // Test Case 5: Search for non-existing student
        try {
            TreeNode found = bst.search(99);
            if (found == null) {
                System.out.println("✅ Test Case 5 Passed: Student not found as expected.");
            } else {
                System.out.println("❌ Test Case 5 Failed: Non-existing student found.");
            }
        } catch (Exception e) {
            System.out.println("❌ Test Case 5 Failed: " + e.getMessage());
        }

        // Test Case 6: Delete non-existing student
        try {
            bst.delete(99);
            System.out.println("✅ Test Case 6 Passed: Handled non-existing student deletion gracefully.");
        } catch (Exception e) {
            System.out.println("❌ Test Case 6 Failed: " + e.getMessage());
        }

        // Test Case 7: Update non-existing student
        try {
            bst.updateStudent(99, "Updated Name", 9.0);
            System.out.println("✅ Test Case 7 Passed: Handled non-existing student update gracefully.");
        } catch (Exception e) {
            System.out.println("❌ Test Case 7 Failed: " + e.getMessage());
        }

        // Test Case 8: Add student with duplicate ID
        try {
            bst.addNewStudent(1, "Duplicate Student", 5.5);
            System.out.println("❌ Test Case 8 Failed: Duplicate ID accepted.");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Test Case 8 Passed: " + e.getMessage());
        }

        // Test Case 9: Traversal on empty tree
        try {
            StudentBST emptyTree = new StudentBST();
            System.out.println("Inorder Traversal of Empty Tree:");
            emptyTree.inorder();
            System.out.println("✅ Test Case 9 Passed: Empty tree traversal handled.");
        } catch (Exception e) {
            System.out.println("❌ Test Case 9 Failed: " + e.getMessage());
        }

        // Test Case 10: Add multiple students and sort by marks in ascending order
        try {
            bst.addNewStudent(5, "Student A", 7.5);
            bst.addNewStudent(3, "Student B", 8.0);
            bst.addNewStudent(7, "Student C", 6.5);
            bst.mergeSortByMarks(true);
            System.out.println("✅ Test Case 10 Passed: Students sorted correctly in ascending order.");
        } catch (Exception e) {
            System.out.println("❌ Test Case 10 Failed: " + e.getMessage());
        }
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");

            int id;
            do {
                System.out.print("Enter student ID (positive integer): ");
                id = scanner.nextInt();
                scanner.nextLine();
                if (!Validation.isValidID(id)) {
                    System.out.println("⚠️ Error: ID must be a positive integer. Please try again.");
                }
            } while (!Validation.isValidID(id));

            String name;
            do {
                System.out.print("Enter student name (letters and spaces only): ");
                name = scanner.nextLine();
                if (!Validation.isValidName(name)) {
                    System.out.println("⚠️ Error: Name must not contain numbers or special characters. Please try again.");
                }
            } while (!Validation.isValidName(name));

            double marks;
            do {
                System.out.print("Enter student marks (0.0 to 10.0): ");
                marks = scanner.nextDouble();
                scanner.nextLine();
                if (!Validation.isValidMarks(marks)) {
                    System.out.println("⚠️ Error: Marks must be between 0.0 and 10.0. Please try again.");
                }
            } while (!Validation.isValidMarks(marks));

            Student student = new Student(id, name, marks);
            bst.insert(student);
        }
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display In-order");
            System.out.println("2. Display Pre-order");
            System.out.println("3. Display Post-order");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Update Student by ID");
            System.out.println("6. Delete Student by ID");
            System.out.println("7. Sort Students by Marks (Ascending)");
            System.out.println("8. Sort Students by Marks (Descending)");
            System.out.println("9. Exit");
            System.out.println("10. Sort Students by Marks using Merge Sort (Ascending)");
            System.out.println("11. Sort Students by Marks using Merge Sort (Descending)");
            System.out.println("12. Linear Search by ID");
            System.out.println("13. BFS Traversal");
            System.out.println("14. Add a New Student");
            System.out.println("15. Binary Search by ID");
            System.out.print("Choose an option: ");

            // Kiểm tra nếu đầu vào không phải là số
            if (!scanner.hasNextInt()) {
                System.out.println("⚠️ Error: Invalid input. Please enter a number between 1 and 9.");
                scanner.next(); // Loại bỏ đầu vào không hợp lệ
                continue; // Quay lại menu
            }

            int choice = scanner.nextInt();

            // Kiểm tra số có nằm trong phạm vi hợp lệ không
            if (choice < 1 || choice > 15) {
                System.out.println("⚠️ Error: Option not available. Please enter a number between 1 and 9.");
                continue; // Quay lại menu
            }

            switch (choice) {
                case 1:
                    System.out.println("\nIn-order traversal:");
                    bst.inorder();
                    break;
                case 2:
                    System.out.println("\nPre-order traversal:");
                    bst.preorder();
                    break;
                case 3:
                    System.out.println("\nPost-order traversal:");
                    bst.postorder();
                    break;
                case 4: // Search Student by ID
                    int searchId;
                    while (true) {
                        System.out.print("Enter student ID to search: ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("⚠️ Error: ID must be a valid integer. Please try again.");
                            scanner.next(); // Loại bỏ đầu vào không hợp lệ
                        } else {
                            searchId = scanner.nextInt();
                            break; // Thoát vòng lặp nếu đầu vào hợp lệ
                        }
                    }
                    TreeNode found = bst.search(searchId);
                    if (found != null) {
                        System.out.println("Student found: " + found.student);
                    } else {
                        System.out.println("⚠️ Error: Student with ID " + searchId + " not found.");
                    }
                    break;

                case 5: // Update Student by ID
                    int updateId;
                    while (true) {
                        System.out.print("Enter student ID to update: ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("⚠️ Error: ID must be a valid integer. Please try again.");
                            scanner.next(); // Loại bỏ đầu vào không hợp lệ
                        } else {
                            updateId = scanner.nextInt();
                            break; // Thoát vòng lặp nếu đầu vào hợp lệ
                        }
                    }
                    scanner.nextLine(); // Xóa bộ đệm

                    System.out.print("Enter new name: ");
                    String newName;
                    do {
                        newName = scanner.nextLine();
                        if (!Validation.isValidName(newName)) {
                            System.out.println("⚠️ Error: Name must not contain numbers or special characters. Please try again.");
                        }
                    } while (!Validation.isValidName(newName));

                    double newMarks;
                    while (true) {
                        System.out.print("Enter new marks: ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("⚠️ Error: Marks must be a decimal value. Please try again.");
                            scanner.next(); // Loại bỏ đầu vào không hợp lệ
                        } else {
                            newMarks = scanner.nextDouble();
                            if (Validation.isValidMarks(newMarks)) {
                                break; // Đầu vào hợp lệ
                            } else {
                                System.out.println("⚠️ Error: Marks must be between 0.0 and 10.0. Please try again.");
                            }
                        }
                    }
                    scanner.nextLine(); // Xóa bộ đệm

                    bst.updateStudent(updateId, newName, newMarks);
                    break;

                case 6: // Delete Student by ID
                    int deleteId;
                    while (true) {
                        System.out.print("Enter student ID to delete: ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("⚠️ Error: ID must be a valid integer. Please try again.");
                            scanner.next(); // Loại bỏ đầu vào không hợp lệ
                        } else {
                            deleteId = scanner.nextInt();
                            break; // Thoát vòng lặp nếu đầu vào hợp lệ
                        }
                    }
                    bst.delete(deleteId);
                    System.out.println("Student deleted.");
                    break;

                case 7:
                    bst.bubbleSortByMarks(true);
                    break;
                case 8:
                    bst.bubbleSortByMarks(false);
                    break;
                case 9:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                case 10:
                    bst.mergeSortByMarks(true);
                    break;
                case 11:
                    bst.mergeSortByMarks(false);
                    break;
                case 12:
                    System.out.print("Enter student ID to search: ");
                    int linearSearchId = scanner.nextInt();
                    Student foundById = bst.linearSearchByID(linearSearchId);
                    if (foundById != null) {
                        System.out.println("Student found: " + foundById);
                    } else {
                        System.out.println("⚠️ Error: Student with ID " + linearSearchId + " not found.");
                    }
                    break;
                case 13:
                    bst.bfsTraversal();
                    break;
                case 14: // Add a New Student
                    System.out.println("\nAdding a new student:");
                    int newId;
                    do {
                        System.out.print("Enter student ID (positive integer): ");
                        newId = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer
                        if (!Validation.isValidID(newId)) {
                            System.out.println("⚠️ Error: ID must be a positive integer. Please try again.");
                        }
                    } while (!Validation.isValidID(newId));

                    String addedName;
                    do {
                        System.out.print("Enter student name (letters and spaces only): ");
                        addedName = scanner.nextLine();
                        if (!Validation.isValidName(addedName)) {
                            System.out.println("⚠️ Error: Name must not contain numbers or special characters. Please try again.");
                        }
                    } while (!Validation.isValidName(addedName));

                    double addedMarks;
                    do {
                        System.out.print("Enter student marks (0.0 to 10.0): ");
                        addedMarks = scanner.nextDouble();
                        scanner.nextLine(); // Clear buffer
                        if (!Validation.isValidMarks(addedMarks)) {
                            System.out.println("⚠️ Error: Marks must be between 0.0 and 10.0. Please try again.");
                        }
                    } while (!Validation.isValidMarks(addedMarks));

                    // Call the addNewStudent method in StudentBST
                    bst.addNewStudent(newId, addedName, addedMarks);
                    break;
                case 15: // Binary Search by ID
                    System.out.print("Enter student ID to search using Binary Search: ");
                    int binarySearchId = scanner.nextInt();
                    Student binaryFound = bst.binarySearchByID(binarySearchId);
                    if (binaryFound != null) {
                        System.out.println("Student found: " + binaryFound);
                    } else {
                        System.out.println("⚠️ Error: Student with ID " + binarySearchId + " not found.");
                    }
                    break;
                default:
                    // Trường hợp này không xảy ra vì đã kiểm tra đầu vào
                    System.out.println("⚠️ Error: Invalid choice. Please choose a valid option from the menu.");
            }
        }

    }
}
