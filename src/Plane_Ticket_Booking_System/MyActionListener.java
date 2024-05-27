/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author willi
 */
public class MyActionListener implements ActionListener{

    private String name;
    
    public MyActionListener(String name)
    {
        this.name = name; 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(name);
    }
    
}
