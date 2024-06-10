/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author willi
 */
public class BookingPage extends JFrame implements ActionListener{
    
    private JComboBox<Flight> departureFlightComboBox;
    private JComboBox<Seat> departureSeatComboBox;
    private JComboBox<Flight> returnFlightComboBox;
    private JComboBox<Seat> returnSeatComboBox;
    private JButton bookButton;
    private JLabel flightLabel, departureSeatLabel, returnFlightLabel, returnSeatLabel;
    private FlightManager flightManager;
    private String destination;
    private Date departureDate;
    private Date returnDate;
    private Account loggedInAccount;
    private ServiceClass serviceClass;
    private DatabaseManager dbManager;
    
    public BookingPage(FlightManager flight, Account loggedInAccount, String destination, Date departureDate, Date returnDate, ServiceClass serviceClass)
    {
        this.flightManager = flight;
        this.loggedInAccount = loggedInAccount;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.serviceClass = serviceClass;
        this.dbManager = new DatabaseManager();
        
        setTitle("Booking Page");
        setSize(600, 400);
        setLocation(350, 100);
        setLayout(null);

        flightLabel = new JLabel("Select departure flight:");
        flightLabel.setBounds(50, 50, 150, 30);
        add(flightLabel);

        departureFlightComboBox = new JComboBox<>();
        departureFlightComboBox.setBounds(200, 50, 300, 30);
        departureFlightComboBox.addActionListener(this);
        add(departureFlightComboBox);
        
        departureSeatLabel = new JLabel("Select departure seat:");
        departureSeatLabel.setBounds(50, 100, 150, 30);
        add(departureSeatLabel);
        
        departureSeatComboBox = new JComboBox<>();
        departureSeatComboBox.setBounds(200, 100, 300, 30);
        add(departureSeatComboBox);
        
        returnFlightLabel = new JLabel("Select return flight:");
        returnFlightLabel.setBounds(50, 150, 150, 30);
        add(returnFlightLabel);

        returnFlightComboBox = new JComboBox<>();
        returnFlightComboBox.setBounds(200, 150, 300, 30);
        returnFlightComboBox.addActionListener(this);
        add(returnFlightComboBox);
        
        returnSeatLabel = new JLabel("Select return seat:");
        returnSeatLabel.setBounds(50, 200, 150, 30);
        add(returnSeatLabel);  
        
        returnSeatComboBox = new JComboBox<>();
        returnSeatComboBox.setBounds(200, 200, 300, 30);
        add(returnSeatComboBox);

        bookButton = new JButton("Book");
        bookButton.setBounds(200, 250, 100, 30);
        bookButton.addActionListener(this);
        add(bookButton);

        populateDepartureFlights();
        populateReturnFlights();
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void populateDepartureFlights() {
        List<Flight> flights = flightManager.getAllFlights();
        for (Flight flight : flights) {
            if (flight.getDestination().equals(destination)) {
                departureFlightComboBox.addItem(flight);
            }
        }
    }
    
    private void populateReturnFlights() {
        List<Flight> flights = flightManager.getAllFlights();
        for (Flight flight : flights) {
            if (flight.getOrigin().equals(destination)) {
                returnFlightComboBox.addItem(flight);
            }
        }
    }

    private void populateDepartureSeats(Flight flight) {
        departureSeatComboBox.removeAllItems();
        List<Seat> seats = flight.getSeats(departureDate);
        for (Seat seat : seats) {
            departureSeatComboBox.addItem(seat);
        }
    }

    private void populateReturnSeats(Flight flight) {
        returnSeatComboBox.removeAllItems();
        List<Seat> seats = flight.getSeats(returnDate);
        for (Seat seat : seats) {
            returnSeatComboBox.addItem(seat);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == departureFlightComboBox) {
            Flight selectedDepartureFlight = (Flight) departureFlightComboBox.getSelectedItem();
            if (selectedDepartureFlight != null) {
                populateDepartureSeats(selectedDepartureFlight);
            }
        } else if (e.getSource() == returnFlightComboBox) {
            Flight selectedReturnFlight = (Flight) returnFlightComboBox.getSelectedItem();
            if (selectedReturnFlight != null) {
                populateReturnSeats(selectedReturnFlight); 
            } 
            
        } else if (e.getSource() == bookButton) {
        Flight departureFlight = (Flight) departureFlightComboBox.getSelectedItem();
        Flight returnFlight = (Flight) returnFlightComboBox.getSelectedItem();
        Seat selectedDepartureSeat = (Seat) departureSeatComboBox.getSelectedItem();
        Seat selectedReturnSeat = (Seat) returnSeatComboBox.getSelectedItem();

        if (departureFlight != null && returnFlight != null && selectedDepartureSeat != null && selectedReturnSeat != null) {
            if (departureFlight.bookSeat(departureDate, selectedDepartureSeat.getSeatId()) && returnFlight.bookSeat(returnDate, selectedReturnSeat.getSeatId())) {
                Ticket departureTicket = new Ticket(loggedInAccount.getFirstName(), departureFlight.getPlaneId(), departureDate.toString(), serviceClass.toString(), selectedDepartureSeat.getSeatId(), departureFlight.getDepartureTime());
                Ticket returnTicket = new Ticket(loggedInAccount.getFirstName(), returnFlight.getPlaneId(), returnDate.toString(), serviceClass.toString(), selectedReturnSeat.getSeatId(), returnFlight.getDepartureTime());

                System.out.println("Departure Ticket: " + departureTicket.toString());
                System.out.println("Return Ticket: " + returnTicket.toString());

                dbManager.saveTicket(departureTicket);
                dbManager.saveTicket(returnTicket);
                
                JOptionPane.showMessageDialog(this, "Booking Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Seat not available", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}    
