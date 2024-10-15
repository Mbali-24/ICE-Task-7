/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.icetask7;
import java.util.Scanner;
/**
 *
 * @author macbookpro
 */
public class ICETask7 {

    
    // Method to check if the booking code is valid
    public static boolean checkBookingCode(String code) {
        // Check if the code contains an underscore and does not exceed 12 characters
        return code.contains("_") && code.length() <= 12;
    }

    // Method to check password complexity
    public static boolean checkPasswordComplexity(String password) {
        // Check if the password meets complexity requirements
        if (password.length() < 8) return false;
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpperCase = true;
            if (Character.isDigit(ch)) hasNumber = true;
            if ("!@#$%^&*()_+[]{}|;':\",.<>?`~".indexOf(ch) >= 0) hasSpecialChar = true;
        }
        return hasUpperCase && hasNumber && hasSpecialChar;
    }

    // Method to make a reservation
    public static String makeReservation(String bookingCode, String password) {
        // Validate booking code
        if (!checkBookingCode(bookingCode)) {
            return "Booking code is incorrectly formatted.";
        }
        // Validate password
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet the complexity requirements.";
        }
        // If both are valid, confirm the reservation
        return "Reservation successfully made!";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input booking code and password from user
        System.out.print("Enter booking code: ");
        String bookingCode = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        // Make the reservation and display the result
        String result = makeReservation(bookingCode, password);
        System.out.println(result);
        
        scanner.close();
    }
}
