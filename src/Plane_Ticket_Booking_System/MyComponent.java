/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author willi
 */


public class MyComponent extends JComponent{
    private Image image;
    
    @Override
    public void paintComponent(Graphics g)
    {
        image = new ImageIcon(".jpg").getImage();
          
        g.drawImage(image, 0, 0, null);
        g.drawString("Flights", 100, 120);
    }
    
    
}
