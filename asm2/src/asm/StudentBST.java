/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author biennguyen0304
 */
public class StudentBST {

    private TreeNode root;

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private TreeNode insertRec(TreeNode root, Student student) {
        if (root == null) {
            root = new TreeNode(student);
            return root;
        }

        if (student.studentId < root.student.studentId) {
            root.left = insertRec(root.left, student);
        } else if (student.studentId > root.student.studentId) {
            root.right = insertRec(root.right, student);
        }

        return root;
    }

    public TreeNode search(int studentId) {
        return searchRec(root, studentId);
    }

    private TreeNode searchRec(TreeNode root, int studentId) {
        if (root == null || root.student.studentId == studentId) {
            return root; // Trả về nút nếu tìm thấy hoặc null nếu không
        }

        if (studentId < root.student.studentId) {
            return searchRec(root.left, studentId);
        } else {
            return searchRec(root.right, studentId);
        }
    }

    public void delete(int studentId) {
        if (search(studentId) == null) {
            System.out.println("⚠️ Error: Student with ID " + studentId + " not found.");
            return;
        }

        root = deleteRec(root, studentId);
        System.out.println("✅ Student with ID " + studentId + " deleted successfully.");
    }

    private TreeNode deleteRec(TreeNode root, int studentId) {
        if (root == null) {
            return root;
        }

        if (studentId < root.student.studentId) {
            root.left = deleteRec(root.left, studentId);
        } else if (studentId > root.student.studentId) {
            root.right = deleteRec(root.right, studentId);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.student = minValue(root.right);
            root.right = deleteRec(root.right, root.student.studentId);
        }

        return root;
    }

    private Student minValue(TreeNode root) {
        Student minv = root.student;
        while (root.left != null) {
            minv = root.left.student;
            root = root.left;
        }
        return minv;
    }

    public void updateStudent(int studentId, String newName, double newMarks) {
        TreeNode node = search(studentId);
        if (node == null) {
            System.out.println("⚠️ Error: Student with ID " + studentId + " not found.");
            return;
        }

        if (!Validation.isValidName(newName)) {
            System.out.println("⚠️ Error: Name must only contain letters and spaces.");
            return;
        }
        if (!Validation.isValidMarks(newMarks)) {
            System.out.println("⚠️ Error: Marks must be between 0.0 and 10.0.");
            return;
        }

        node.student.name = newName;
        node.student.marks = newMarks;
        System.out.println("✅ Student information updated successfully: " + node.student);
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.student);
            inorderRec(root.right);
        }
    }

    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.println(root.student);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.student);
        }
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        getAllStudentsRec(root, students);
        return students;
    }

    private void getAllStudentsRec(TreeNode root, ArrayList<Student> students) {
        if (root != null) {
            getAllStudentsRec(root.left, students);
            students.add(root.student);
            getAllStudentsRec(root.right, students);
        }
    }

    // Bubble Sort method to sort by marks
    public void bubbleSortByMarks() {
        ArrayList<Student> students = getAllStudents();
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).marks > students.get(j + 1).marks) {
                    // Swap students[j] and students[j+1]
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        System.out.println("\nStudents sorted by marks:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void bubbleSortByMarks(boolean ascending) {
        ArrayList<Student> students = getAllStudents();
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((ascending && students.get(j).marks > students.get(j + 1).marks)
                        || (!ascending && students.get(j).marks < students.get(j + 1).marks)) {
                    // Swap students[j] and students[j+1]
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }

        System.out.println("\nStudents sorted by marks (" + (ascending ? "Ascending" : "Descending") + "):");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void mergeSortByMarks(boolean ascending) {
        ArrayList<Student> students = getAllStudents();
        students = mergeSort(students, ascending);
        System.out.println("\nStudents sorted by marks (" + (ascending ? "Ascending" : "Descending") + "):");
        for (Student student : students) {
            System.out.println(student);
        }
    }

// Recursive Merge Sort implementation
    private ArrayList<Student> mergeSort(ArrayList<Student> students, boolean ascending) {
        if (students.size() <= 1) {
            return students;
        }

        int mid = students.size() / 2;
        ArrayList<Student> left = new ArrayList<>(students.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(students.subList(mid, students.size()));

        left = mergeSort(left, ascending);
        right = mergeSort(right, ascending);

        return merge(left, right, ascending);
    }

    private ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right, boolean ascending) {
        ArrayList<Student> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if ((ascending && left.get(i).marks <= right.get(j).marks)
                    || (!ascending && left.get(i).marks >= right.get(j).marks)) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            result.add(left.get(i++));
        }

        while (j < right.size()) {
            result.add(right.get(j++));
        }

        return result;
    }

    public Student linearSearchByID(int id) {
        ArrayList<Student> students = getAllStudents();
        for (Student student : students) {
            if (student.studentId == id) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> linearSearchByName(String name) {
        ArrayList<Student> students = getAllStudents();
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.name.equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public void bfsTraversal() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("\nBreadth-First Search (BFS) Traversal:");
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.student);

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public void addNewStudent(int id, String name, double marks) {
        // Kiểm tra ID hợp lệ
        if (!Validation.isValidID(id)) {
            throw new IllegalArgumentException("⚠️ Error: ID must be a positive integer.");
        }
        // Kiểm tra tên hợp lệ
        if (!Validation.isValidName(name)) {
            throw new IllegalArgumentException("⚠️ Error: Name must only contain letters and spaces.");
        }
        // Kiểm tra điểm hợp lệ
        if (!Validation.isValidMarks(marks)) {
            throw new IllegalArgumentException("⚠️ Error: Marks must be between 0.0 and 10.0.");
        }

        // Kiểm tra trùng ID
        TreeNode existingNode = searchRec(root, id);
        if (existingNode != null) {
            throw new IllegalArgumentException("⚠️ Error: A student with ID " + id + " already exists.");
        }

        // Thêm sinh viên mới
        Student newStudent = new Student(id, name, marks);
        insert(newStudent);
        System.out.println("✅ Student added successfully: " + newStudent);
    }

    public Student binarySearchByID(int id) {
        // Get a sorted list of students (in-order traversal ensures sorting)
        ArrayList<Student> students = getAllStudents();
        int left = 0, right = students.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the middle element is the target
            if (students.get(mid).studentId == id) {
                return students.get(mid);
            }

            // If the target is smaller, it must be in the left half
            if (id < students.get(mid).studentId) {
                right = mid - 1;
            } else {
                // Otherwise, it must be in the right half
                left = mid + 1;
            }
        }

        // If the element is not found
        return null;
    }
}
