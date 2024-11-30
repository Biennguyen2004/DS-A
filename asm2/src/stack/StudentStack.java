/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 *
 * @author biennguyen0304
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class StudentStack {

    private Stack<Student> stack;

    public StudentStack() {
        stack = new Stack<>();
    }

    // Add student to the stack
    public void push(Student student) {
        for (Student s : stack) {
            if (s.getStudentId() == student.getStudentId()) {
                throw new IllegalArgumentException("A student with ID " + student.getStudentId() + " already exists.");
            }
        }
        stack.push(student);
        System.out.println("Student added: " + student);
    }

    public Student pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        } else {
            System.out.println("No students to remove.");
            return null;
        }
    }

    public Student peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            System.out.println("No students in the stack.");
            return null;
        }
    }

    public void displayStack() {
        if (stack.isEmpty()) {
            System.out.println("No students in the stack.");
        } else {
            for (Student student : stack) {
                System.out.println(student);
            }
        }
    }

    // Sort by marks in ascending order
    public void sortAscending() {
        ArrayList<Student> list = new ArrayList<>(stack);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).getMarks() > list.get(j + 1).getMarks()) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }

        stack.clear();
        stack.addAll(list);
        System.out.println("List sorted in ascending order by marks.");
    }

    // Sort by marks in descending order
    public void sortDescending() {
        ArrayList<Student> list = new ArrayList<>(stack);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).getMarks() < list.get(j + 1).getMarks()) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }

        stack.clear();
        stack.addAll(list);
        System.out.println("List sorted in descending order by marks.");
    }

    // Update student by ID
   public void updateStudent(int id, String newName, double newMarks) {
        boolean found = false;
        for (Student student : stack) {
            if (student.getStudentId() == id) {
                student.setName(newName);
                student.setMarks(newMarks);
                System.out.println("Student information updated: " + student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
    // Merge Sort Ascending

    public void mergeSortAscending() {
        ArrayList<Student> list = new ArrayList<>(stack);
        mergeSort(list, 0, list.size() - 1, true);
        stack.clear();
        stack.addAll(list);
        System.out.println("Students sorted by marks in ascending order using Merge Sort.");
    }

    // Merge Sort Descending
    public void mergeSortDescending() {
        ArrayList<Student> list = new ArrayList<>(stack);
        mergeSort(list, 0, list.size() - 1, false);
        stack.clear();
        stack.addAll(list);
        System.out.println("Students sorted by marks in descending order using Merge Sort.");
    }

    // Merge Sort Helper Method
    private void mergeSort(ArrayList<Student> list, int left, int right, boolean ascending) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(list, left, mid, ascending);
            mergeSort(list, mid + 1, right, ascending);
            merge(list, left, mid, right, ascending);
        }
    }

    // Merge Method
    private void merge(ArrayList<Student> list, int left, int mid, int right, boolean ascending) {
        ArrayList<Student> temp = new ArrayList<>(list);
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            if ((ascending && temp.get(i).getMarks() <= temp.get(j).getMarks())
                    || (!ascending && temp.get(i).getMarks() >= temp.get(j).getMarks())) {
                list.set(k++, temp.get(i++));
            } else {
                list.set(k++, temp.get(j++));
            }
        }

        while (i <= mid) {
            list.set(k++, temp.get(i++));
        }
        while (j <= right) {
            list.set(k++, temp.get(j++));
        }
    }

    public void linearSearchById(int id) {
        boolean found = false;
        for (Student student : stack) {
            if (student.getStudentId() == id) {
                System.out.println("Student found: " + student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void bfsTraversal() {
        ArrayList<Student> queue = new ArrayList<>(stack);
        for (Student student : queue) {
            System.out.println(student);
        }
    }

    public void addNewStudent(Student student) {
        stack.push(student);
        System.out.println("New student added: " + student);
    }

    public void binarySearchById(int id) {
        ArrayList<Student> list = new ArrayList<>(stack);
        mergeSort(list, 0, list.size() - 1, true); 

        int left = 0, right = list.size() - 1;
        boolean found = false;

        while (left <= right) {
            int mid = left + (right - left) / 2; 

            if (list.get(mid).getStudentId() == id) { // So sánh ID
                System.out.println("Student found: " + list.get(mid));
                found = true;
                break;
            }
            if (list.get(mid).getStudentId() < id) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

}
