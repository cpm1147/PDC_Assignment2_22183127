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
        
        flights.add(new Flight("Auckland", "Singapore", "AKL-SIN-01", "10:00 AM"));
        flights.add(new Flight("Auckland", "Singapore", "AKL-SIN-02", "7:00 PM"));
        flights.add(new Flight("Singapore", "Auckland", "SIN-AKL-01", "2:00 PM"));
        flights.add(new Flight("Singapore", "Auckland", "SIN-AKL-02", "9:00 PM"));
        
        flights.add(new Flight("Auckland", "Tokyo", "AKL-TYO-01", "11:00 AM"));
        flights.add(new Flight("Auckland", "Tokyo", "AKL-TYO-02", "8:00 PM"));
        flights.add(new Flight("Tokyo", "Auckland", "TYO-AKL-01", "3:00 PM"));
        flights.add(new Flight("Tokyo", "Auckland", "TYO-AKL-02", "10:00 PM"));
        
        flights.add(new Flight("Auckland", "Los Angeles", "AKL-LAX-01", "11:00 AM"));
        flights.add(new Flight("Auckland", "Los Angeles", "AKL-LAX-02", "8:00 PM"));
        flights.add(new Flight("Los Angeles", "Auckland", "LAX-AKL-01", "3:00 PM"));
        flights.add(new Flight("Los Angeles", "Auckland", "LAX-AKL-02", "10:00 PM"));
        
        flights.add(new Flight("Auckland", "Hong Kong", "AKL-HKG-01", "1:00 PM"));
        flights.add(new Flight("Auckland", "Hong Kong", "AKL-HKG-02", "10:00 PM"));
        flights.add(new Flight("Hong Kong", "Auckland", "HKG-AKL-01", "5:00 PM"));
        flights.add(new Flight("Hong Kong", "Auckland", "HKG-AKL-02", "12:00 AM"));

        flights.add(new Flight("Auckland", "Bangkok", "AKL-BKK-01", "2:00 PM"));
        flights.add(new Flight("Auckland", "Bangkok", "AKL-BKK-02", "11:00 PM"));
        flights.add(new Flight("Bangkok", "Auckland", "BKK-AKL-01", "6:00 PM"));
        flights.add(new Flight("Bangkok", "Auckland", "BKK-AKL-02", "1:00 AM"));

        flights.add(new Flight("Auckland", "Dubai", "AKL-DXB-01", "3:00 PM"));
        flights.add(new Flight("Auckland", "Dubai", "AKL-DXB-02", "12:00 AM"));
        flights.add(new Flight("Dubai", "Auckland", "DXB-AKL-01", "7:00 PM"));
        flights.add(new Flight("Dubai", "Auckland", "DXB-AKL-02", "2:00 AM"));
        
        flights.add(new Flight("Auckland", "Fiji", "AKL-NAN-01", "8:00 AM"));
        flights.add(new Flight("Auckland", "Fiji", "AKL-NAN-02", "5:00 PM"));
        flights.add(new Flight("Fiji", "Auckland", "NAN-AKL-01", "10:00 AM"));
        flights.add(new Flight("Fiji", "Auckland", "NAN-AKL-02", "6:00 PM"));
    }

    public List<Flight> getAllFlights() {
        return flights;
    }
    
}
