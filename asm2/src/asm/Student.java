    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package asm;

    /**
     *
     * @author biennguyen0304
     */
    public class Student {
           int studentId;
        String name;
        double marks;

        public Student(int studentId, String name, double marks) {
            this.studentId = studentId;
            this.name = name;
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