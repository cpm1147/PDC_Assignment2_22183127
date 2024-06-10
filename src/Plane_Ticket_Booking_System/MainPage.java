/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author willi
 */
public class MainPage implements ActionListener{

    JFrame frame;
    JLabel bookFlightLabel, fromLabel, toLabel, fromDateLabel, toDateLabel, serviceClassLabel;
    JPanel bookingPanel, menuPanel;
    JComboBox<String> toLocation, fromLocation;
    JComboBox<ServiceClass> serviceClass;    
    JDateChooser fromDate, toDate;
    JButton search, viewBookings, signOut;
    private FlightManager flightManager;
    private Account loggedInAccount;
    private DatabaseManager dbManager;
    
    
    public MainPage(Account loggedInAccount)
    {        
        this.loggedInAccount = loggedInAccount;
        flightManager = new FlightManager();
        dbManager = new DatabaseManager();
        
        frame = new JFrame("Main Page");
               
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.black);  
        menuPanel.setPreferredSize(new Dimension(1281, 30));
        menuPanel.setLayout(null);
        
        viewBookings = new JButton("View Bookings");
        viewBookings.setBounds(10, 5, 130, 20);
        viewBookings.addActionListener(this);
        
        signOut = new JButton("Sign out");
        signOut.setBounds(1173, 5, 100, 20);
        signOut.addActionListener(this);
        
        bookingPanel = new JPanel();
        bookingPanel.setBackground(Color.black);  
        bookingPanel.setPreferredSize(new Dimension(700, 250)); 
        bookingPanel.setLayout(null);
        
        bookFlightLabel = new JLabel("Book Your Flight");
        bookFlightLabel.setBounds(10, 5, 500, 40);
        bookFlightLabel.setFont(new Font("Arial", Font.BOLD, 16));
        bookFlightLabel.setForeground(Color.white);        
                
        String[] origin = {"Auckland"};
        String[] destination = {"Melbourne", "Sydney"};
        
        fromLabel = new JLabel("From");
        fromLabel.setBounds(80, 40, 100, 40);
        fromLabel.setFont(new Font("Arial", Font.BOLD, 12));
        fromLabel.setForeground(Color.white);
        
        fromLocation = new JComboBox<>(origin);
        fromLocation.setBounds(80, 70, 250, 20);
               
        toLabel = new JLabel("To");
        toLabel.setBounds(380, 40, 100, 40);
        toLabel.setFont(new Font("Arial", Font.BOLD, 12));
        toLabel.setForeground(Color.white);
        
        toLocation = new JComboBox<>(destination);
        toLocation.setBounds(380, 70, 250, 20);
        
        fromDateLabel = new JLabel("Leave on");
        fromDateLabel.setBounds(80, 90, 100, 40);
        fromDateLabel.setFont(new Font("Arial", Font.BOLD, 12));
        fromDateLabel.setForeground(Color.white);
       
        fromDate = new JDateChooser();
        fromDate.setBounds(80, 120, 250, 20);
          
        toDateLabel = new JLabel("Return on");
        toDateLabel.setBounds(380, 90, 100, 40);
        toDateLabel.setFont(new Font("Arial", Font.BOLD, 12));
        toDateLabel.setForeground(Color.white);
        
        toDate = new JDateChooser();
        toDate.setBounds(380, 120, 250, 20);
        
        serviceClassLabel = new JLabel("Service Class");
        serviceClassLabel.setBounds(80, 140, 100, 40);
        serviceClassLabel.setFont(new Font("Arial", Font.BOLD, 12));
        serviceClassLabel.setForeground(Color.white);
        
        serviceClass = new JComboBox<>(ServiceClass.values());
        serviceClass.setBounds(80, 170, 250, 20);
        
        search = new JButton("Search");
        search.setBounds(580, 210, 100, 20);
        search.addActionListener(this);
                   
        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = 0;
        grid.gridy = 0;
        grid.weightx = 1.0;
        grid.weighty = 1.0;
        grid.anchor = GridBagConstraints.NORTH;
        grid.fill = GridBagConstraints.NONE;
        
        GridBagConstraints grid2 = new GridBagConstraints();
        grid2.gridx = 0;
        grid2.gridy = 0;
        grid2.weightx = 1.0;
        grid2.weighty = 1.0;
        grid2.anchor = GridBagConstraints.CENTER;
        grid2.fill = GridBagConstraints.NONE;
      
        menuPanel.add(viewBookings);
        menuPanel.add(signOut);
        
        bookingPanel.add(bookFlightLabel);
        bookingPanel.add(fromLocation);
        bookingPanel.add(toLocation);
        bookingPanel.add(fromDate);
        bookingPanel.add(toDate);
        bookingPanel.add(serviceClass);
        bookingPanel.add(fromLabel);
        bookingPanel.add(toLabel);
        bookingPanel.add(fromDateLabel);
        bookingPanel.add(toDateLabel);
        bookingPanel.add(serviceClassLabel);
        bookingPanel.add(search);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setLayout(new GridBagLayout());
        frame.add(menuPanel, grid);
        frame.add(bookingPanel, grid2);
        frame.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == viewBookings)
        {
            SQLTable sqlTable = new SQLTable();
            sqlTable.setVisible(true);
        }
        
        if (e.getSource() == signOut) {
            dbManager.closeConnection(); 
            frame.dispose();
        }
        
        if (e.getSource() == search) {
            String destination = (String) toLocation.getSelectedItem();
            Date departureDate = fromDate.getDate();
            Date returnDate = toDate.getDate();
            ServiceClass selectedClass = (ServiceClass) serviceClass.getSelectedItem();
            Date currentDate = new Date();
            
            if (destination != null && departureDate != null && returnDate != null && selectedClass != null) {
                if (departureDate.before(currentDate) || returnDate.before(currentDate)) {
                    JOptionPane.showMessageDialog(frame, "No fares available for selected dates", "Invalid Date", JOptionPane.ERROR_MESSAGE);
                } else if (returnDate.before(departureDate)) {
                    JOptionPane.showMessageDialog(frame, "Return date cannot be before departure date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
                } 
                else {
                BookingPage page = new BookingPage(flightManager, loggedInAccount, destination, departureDate, returnDate, selectedClass);
                    }
                } else {
                JOptionPane.showMessageDialog(frame, "Please fill all the fields.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
            }
        }
    }    
}
