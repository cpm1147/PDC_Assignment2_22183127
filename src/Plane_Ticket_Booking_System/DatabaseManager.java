/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author willi
 */
   public class DatabaseManager {
    private static final String URL = "jdbc:derby:PlaneBookingDB;create=true"; 
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    private Connection conn;

    public DatabaseManager() {
        establishConnection();
        createSchemaAndTable();
    }

    public Connection getConnection() {
        return this.conn;
    }

    private void establishConnection() {
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println(URL + "Connected Successfully....");
        } catch (SQLException ex) {
            System.out.println("Error connecting " + ex.getMessage());
        }
    }

    private void createSchemaAndTable() {
        try (Statement stmt = conn.createStatement()) {
            ResultSet schemaCheck = stmt.executeQuery("SELECT * FROM SYS.SYSSCHEMAS WHERE SCHEMANAME = 'PDC'");
            if (!schemaCheck.next()) {
                stmt.executeUpdate("CREATE SCHEMA PDC"); 
                System.out.println("Schema 'PDC' created.");
            } else {
                System.out.println("Schema 'PDC' already exists.");
            }

            ResultSet tableCheck = stmt.executeQuery("SELECT * FROM SYS.SYSTABLES WHERE TABLENAME = 'TICKETS' AND SCHEMAID = (SELECT SCHEMAID FROM SYS.SYSSCHEMAS WHERE SCHEMANAME = 'PDC')");
            if (!tableCheck.next()) {
                String createTableSQL = "CREATE TABLE PDC.Tickets (" +
                                        "firstName VARCHAR(255), " +
                                        "flightId VARCHAR(255), " +
                                        "dateOfFlight VARCHAR(255), " +
                                        "serviceClass VARCHAR(255), " +
                                        "seatId VARCHAR(255), " +
                                        "time VARCHAR(255))";
                stmt.executeUpdate(createTableSQL); 
                System.out.println("Table 'PDC.Tickets' created.");
            } else {
                System.out.println("Table 'PDC.Tickets' already exists.");
            }
        } catch (SQLException ex) {
            System.out.println("Error creating schema: " + ex.getMessage());
        }
    }

    public List<Ticket> getTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String query = "SELECT * FROM Tickets";

        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {
                String firstName = result.getString("firstName");
                String flightId = result.getString("flightId");
                String dateOfFlight = result.getString("dateOfFlight");
                String serviceClass = result.getString("serviceClass");
                String seatId = result.getString("seatId");
                String time = result.getString("time");

                Ticket ticket = new Ticket(firstName, flightId, dateOfFlight, serviceClass, seatId, time);
                tickets.add(ticket);
            }
        } catch (SQLException ex) {
            System.out.println("Error getting tickets: " + ex.getMessage());
        }
        return tickets;
    }

    public boolean saveTicket(Ticket ticket) {
        String insertSQL = "INSERT INTO PDC.Tickets (firstName, flightId, dateOfFlight, serviceClass, seatId, time) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(insertSQL)) {
            statement.setString(1, ticket.getFirstName());
            statement.setString(2, ticket.getFlightID());
            statement.setString(3, ticket.getDateOfFlight());
            statement.setString(4, ticket.getServiceClass());
            statement.setString(5, ticket.getSeatID());
            statement.setString(6, ticket.getTime());
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error saving ticket to database: " + ex.getMessage());
            return false;
        }
    }
   
    public void clearTableData() {
        try (Statement stmt = conn.createStatement()) {
            String clearTableSQL = "DELETE FROM PDC.Tickets"; 
            stmt.executeUpdate(clearTableSQL);
            System.out.println("Table 'PDC.Tickets' cleared.");
        } catch (SQLException ex) {
            System.out.println("Error clearing table: " + ex.getMessage());
        }
    }
    
    public void closeConnection() {
        if (conn != null) {
            try {
                clearTableData();
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException ex) {
                System.out.println("Error closing "+ ex.getMessage());
            }
        }
    }
}