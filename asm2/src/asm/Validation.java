/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm;

/**
 *
 * @author biennguyen0304
 */
public class Validation {
    public static boolean isValidName(String name) {
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("⚠️ Error: Name must only contain letters and spaces.");
        }
        return true;
    }

    public static boolean isValidMarks(double marks) {
        if (marks < 0 || marks > 10) {
            throw new IllegalArgumentException("⚠️ Error: Marks must be between 0.0 and 10.0.");
        }
        return true;
    }

    public static boolean isValidID(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("⚠️ Error: ID must be a positive integer.");
        }
        return true;
    }
}

