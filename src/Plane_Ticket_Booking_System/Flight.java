/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class Flight {
    String origin;
    String destination;
    String planeId;
    String departureTime;
    private List<Seat> seats;
    
    public Flight(String origin, String destination, String planeId, String departureTime) {
        this.origin = origin;
        this.destination = destination;
        this.planeId = planeId;
        this.departureTime = departureTime;
        this.seats = initializeSeats();
    }

    private List<Seat> initializeSeats() {
        List<Seat> seats = new ArrayList<>();
        String[] rows = {"1", "2", "3", "4", "5"};
        String[] columns = {"A", "B", "C", "D"};
        
        for (String row : rows) {
            for (String col : columns) {
                seats.add(new Seat(row + col));
            }
        }
        return seats;
    }

    public String getOrigin() {
        return origin;
    }

    
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }
    
    
    
    public List<Seat> getSeats() {
        return seats;
    }

    public Seat getSeatById(String seatId) {
        for (Seat seat : seats) {
            if (seat.getSeatId().equals(seatId)) {
                return seat;
            }
        }
        return null; 
    }

    public boolean bookSeat(String seatId) {
        Seat seat = getSeatById(seatId);
        if (seat != null && seat.isAvailable()) {
            seat.setAvailability(false);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return planeId + " " + departureTime;
    }
            
}
