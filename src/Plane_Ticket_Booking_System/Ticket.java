/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

/**
 *
 * @author willi
 */
public class Ticket {
    private String firstName;
    private String flightId;
    private String dateOfFlight;
    private String serviceClass;
    private String seatId;
    private String time;

    public Ticket(String firstName, String flightID, String dateOfFlight, String serviceClass, String seatID, String time) {
        this.firstName = firstName;
        this.flightId = flightID;
        this.dateOfFlight = dateOfFlight;
        this.serviceClass = serviceClass;
        this.seatId = seatID;
        this.time = time;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFlightID() {
        return flightId;
    }

    public void setFlightID(String flightID) {
        this.flightId = flightID;
    }

    public String getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(String dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    public String getSeatID() {
        return seatId;
    }

    public void setSeatID(String seatID) {
        this.seatId = seatID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    @Override
    public String toString()
    {
        return firstName + " " + flightId + " " + dateOfFlight + " " + serviceClass + " " + seatId + " " + time;
    }
    
}
