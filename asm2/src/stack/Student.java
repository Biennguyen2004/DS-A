/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 *
 * @author biennguyen0304
 */
public class Student {
    private int studentId;
    private String name;
    private double marks;

    public Student(int studentId, String name, double marks) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Name must only contain letters and spaces.");
        }
        if (marks < 0.0 || marks > 10.0) {
            throw new IllegalArgumentException("Marks must be between 0.0 and 10.0.");
        }
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Name must only contain letters and spaces.");
        }
        this.name = name;
    }

    public void setMarks(double marks) {
        if (marks < 0.0 || marks > 10.0) {
            throw new IllegalArgumentException("Marks must be between 0.0 and 10.0.");
        }
        this.marks = marks;
    }

    public String getRank() {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Marks: " + marks + ", Rank: " + getRank();
    }
}
