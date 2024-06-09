/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    private JComboBox<Flight> flightComboBox;
    private JComboBox<Seat> seatComboBox;
    private JComboBox<Flight> returnFlightComboBox;
    private JButton bookButton;
    private FlightManager flightManager;
    private String destination;
    
    public BookingPage(FlightManager flight, String destination)
    {
        this.flightManager = flight;
        this.destination = destination;
        
        setTitle("Booking Page");
        setSize(600, 400);
        setLocation(350, 100);
        setLayout(null);

        JLabel flightLabel = new JLabel("Select Flight:");
        flightLabel.setBounds(50, 50, 150, 30);
        add(flightLabel);

        flightComboBox = new JComboBox<>();
        flightComboBox.setBounds(200, 50, 300, 30);
        flightComboBox.addActionListener(this);
        add(flightComboBox);
        
        JLabel returnFlightLabel = new JLabel("Select Return Flight:");
        returnFlightLabel.setBounds(50, 100, 150, 30);
        add(returnFlightLabel);

        returnFlightComboBox = new JComboBox<>();
        returnFlightComboBox.setBounds(200, 100, 300, 30);
        add(returnFlightComboBox);

        JLabel seatLabel = new JLabel("Select Seat:");
        seatLabel.setBounds(50, 150, 150, 30);
        add(seatLabel);

        seatComboBox = new JComboBox<>();
        seatComboBox.setBounds(200, 150, 300, 30);
        add(seatComboBox);

        bookButton = new JButton("Book");
        bookButton.setBounds(200, 200, 100, 30);
        bookButton.addActionListener(this);
        add(bookButton);

        populateFlights();
        populateReturnFlights();
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    private void populateFlights() {
        List<Flight> flights = flightManager.getAllFlights();
        for (Flight flight : flights) {
            if (flight.getDestination().equals(destination)) {
                flightComboBox.addItem(flight);
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

    private void populateSeats(Flight flight) {
        seatComboBox.removeAllItems();
        List<Seat> seats = flight.getSeats();
        for (Seat seat : seats) {
            seatComboBox.addItem(seat);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == flightComboBox) {
            Flight selectedFlight = (Flight) flightComboBox.getSelectedItem();
            if (selectedFlight != null) {
                populateSeats(selectedFlight);
            }
        } else if (e.getSource() == bookButton) {
            Flight selectedFlight = (Flight) flightComboBox.getSelectedItem();
            Seat selectedSeat = (Seat) seatComboBox.getSelectedItem();
            if (selectedFlight != null && selectedSeat != null) {
                if (selectedFlight.bookSeat(selectedSeat.getSeatId())) {
                    JOptionPane.showMessageDialog(this, "Booking Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Seat not available", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
