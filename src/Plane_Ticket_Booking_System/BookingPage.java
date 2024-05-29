/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author willi
 */
public class BookingPage {
    
    public BookingPage()
    {
        JFrame frame = new JFrame("Booking Page");
        JLabel label = new JLabel("Book your trip");
        
        label.setBounds(0,0,200,35);
        
        frame.add(label);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
}
