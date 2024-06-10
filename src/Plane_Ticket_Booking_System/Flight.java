/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author willi
 */
public class Flight {
    String origin;
    String destination;
    String planeId;
    String departureTime;
    private Map<Date, List<Seat>> seatAvailability;
    private Map<Date, List<String>> bookedSeatsByDate;
    
    public Flight(String origin, String destination, String planeId, String departureTime) {
        this.origin = origin;
        this.destination = destination;
        this.planeId = planeId;
        this.departureTime = departureTime;
        this.seatAvailability = new HashMap<>();
        this.bookedSeatsByDate = new HashMap<>();
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

    public String getPlaneId() {
        return planeId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public List<Seat> getSeats(Date date) {
        return seatAvailability.computeIfAbsent(date, k -> initializeSeats());
    }

    public Seat getSeatById(Date date, String seatId) {
        List<Seat> seats = getSeats(date);
        for (Seat seat : seats) {
            if (seat.getSeatId().equals(seatId)) {
                return seat;
            }
        }
        return null;
    }
    
    public boolean bookSeat(Date date, String seatId) {
    List<Seat> seats = seatAvailability.computeIfAbsent(date, k -> initializeSeats());
    for (Seat seat : seats) {
        if (seat.getSeatId().equals(seatId) && seat.isAvailable()) {
            seat.setAvailability(false);
            return true;
        }
    }
    return false;
}

    @Override
    public String toString(){
        return planeId + " " + departureTime;
    }
            
}
