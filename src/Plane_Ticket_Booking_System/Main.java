/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

/**
 *
 * @author willi
 */
public class Main {
    public static void main(String[] args) {
        
        AccountManager accountManager = new AccountManager();
        Login login = new Login(accountManager);

    }
}
