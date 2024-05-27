///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
// */
//package Plane_Ticket_Booking_System;
//
//import java.awt.Dimension;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//
///**
// *
// * @author willi
// */
//public class PDC_Project_2 {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        JButton bookingButton = new JButton("Book your trip");
//        JButton manageBookingButton = new JButton("Manage booking");
//        JComboBox<String> destination = new JComboBox();
//        destination.addItem("China");
////        button.addActionListener(new ActionListener(){
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                System.out.println("The button is clicked");
////            }
////            });
//        
//        JFrame frame = new JFrame("Plane Ticket Booking System");
//        Toolkit kit = Toolkit.getDefaultToolkit();
//        Dimension screenSize = kit.getScreenSize();
//        
//        int screenWidth = screenSize.width;
//        int screenHeight = screenSize.height;
//        int frameWidth = screenWidth / 2;
//        int frameHeight = screenHeight / 2;
//        
//        frame.add(bookingButton);
//        frame.setVisible(true);
//        frame.setLocation(350, 100);
//        frame.setSize(frameWidth, frameHeight);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        ActionListener listener = new MyActionListener("NZ to melbourne booked");
//        bookingButton.addActionListener(listener);
//    }
//    
//}
