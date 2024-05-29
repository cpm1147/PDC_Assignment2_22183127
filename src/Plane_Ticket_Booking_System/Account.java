/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

/**
 *
 * @author willi
 */
public class Account extends Passenger{
    private String username;
    private String password;

    public Account(String username, String password, String title, String firstName, String lastName, String dob, String email, int mobileNumber) {
        super(title, firstName, lastName, dob, email, mobileNumber);
        this.username = username;
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
}
