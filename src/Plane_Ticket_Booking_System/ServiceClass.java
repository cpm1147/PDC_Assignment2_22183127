/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Plane_Ticket_Booking_System;

/**
 *
 * @author willi
 */
public enum ServiceClass {
    ECONOMY("Economy - lowest"),
    PREMIUM_ECONOMY("Premium Economy"),
    BUSINESS_CLASS("Business Class");
    
    private final String display;
    
    private ServiceClass(String display){
        this.display = display;
    }
        
    @Override
    public String toString()
    {
        return this.display;
    }
}
