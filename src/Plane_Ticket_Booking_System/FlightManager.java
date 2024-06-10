/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willi
 */
public class FlightManager {
        private List<Flight> flights;

    public FlightManager() {
        flights = new ArrayList<>();
        flightInfo();
    }

    private void flightInfo() {
        
        flights.add(new Flight("Auckland", "Melbourne", "AKL-MEL-01", "9:00 AM"));
        flights.add(new Flight("Auckland", "Melbourne", "AKL-MEL-02", "6:00 PM"));
        flights.add(new Flight("Auckland", "Sydney", "AKL-SYD-01", "9:00 AM"));
        flights.add(new Flight("Auckland", "Sydney", "AKL-SYD-02", "6:00 PM"));
    
        flights.add(new Flight("Melbourne", "Auckland", "MEL-AKL-01", "1:00 PM"));
        flights.add(new Flight("Melbourne", "Auckland", "MEL-AKL-02", "8:00 PM"));
        flights.add(new Flight("Sydney", "Auckland", "SYD-AKL-01", "1:00 PM"));
        flights.add(new Flight("Sydney", "Auckland", "SYD-AKL-02", "8:00 PM"));
    }

    public List<Flight> getAllFlights() {
        return flights;
    }
    
}
