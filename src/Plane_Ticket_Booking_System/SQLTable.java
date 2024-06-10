/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

/**
 *
 * @author willi
 */
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.List;

public class SQLTable extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;
    private DatabaseManager dbManager;

    public SQLTable() {
        dbManager = new DatabaseManager();
        setTitle("Bookings");
        setSize(800, 400);

        List<Ticket> tickets = dbManager.getTickets(); 

        String[] columnNames = {"First Name", "Flight ID", "Date of Flight", "Service Class", "Seat ID", "Time"};
        Object[][] data = new Object[tickets.size()][6];
        
        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            data[i][0] = ticket.getFirstName();
            data[i][1] = ticket.getFlightID();
            data[i][2] = ticket.getDateOfFlight();
            data[i][3] = ticket.getServiceClass();
            data[i][4] = ticket.getSeatID();
            data[i][5] = ticket.getTime();
        }

        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        add(scrollPane);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
