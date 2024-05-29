/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateAccountPage extends JFrame implements ActionListener {
    
    JTextField title, firstName, lastName, dob, username, password, email, mobileNumber;
    JLabel label_title, label_firstName, label_lastName, label_dob, label_username, label_password, label_email, label_mobileNumber, createAccountTitle;
    JButton signupButton;
    AccountManager manager;

    public CreateAccountPage(AccountManager manager) {
        this.manager = manager;

        setTitle("Create Account");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2;
        int frameHeight = screenHeight / 2;
        
        setLocation(350, 100);
        setSize(frameWidth, frameHeight + 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createAccountTitle = new JLabel("Create account");
        createAccountTitle.setBounds(200, 10, 200, 40);
        createAccountTitle.setFont(new Font("Arial", Font.BOLD, 20));
        
        label_title = new JLabel("Title");
        label_title.setBounds(200, 50, 100, 40);
        label_title.setFont(new Font("Arial", Font.BOLD, 16));
        label_title.setForeground(Color.BLUE);
        
        label_firstName = new JLabel("First Name");
        label_firstName.setBounds(200, 100, 100, 40);
        label_firstName.setFont(new Font("Arial", Font.BOLD, 16));
        label_firstName.setForeground(Color.BLUE);
        
        label_lastName = new JLabel("Last Name");
        label_lastName.setBounds(200, 150, 100, 40);
        label_lastName.setFont(new Font("Arial", Font.BOLD, 16));
        label_lastName.setForeground(Color.BLUE);
        
        label_dob = new JLabel("DOB");
        label_dob.setBounds(200, 200, 100, 40);
        label_dob.setFont(new Font("Arial", Font.BOLD, 16));
        label_dob.setForeground(Color.BLUE);
        
        label_username = new JLabel("Username");
        label_username.setBounds(200, 250, 100, 40);
        label_username.setFont(new Font("Arial", Font.BOLD, 16));
        label_username.setForeground(Color.BLUE);
        
        label_password = new JLabel("Password");
        label_password.setBounds(200, 300, 100, 40);
        label_password.setFont(new Font("Arial", Font.BOLD, 16));
        label_password.setForeground(Color.BLUE);
        
        label_email = new JLabel("Email");
        label_email.setBounds(200, 350, 100, 40);
        label_email.setFont(new Font("Arial", Font.BOLD, 16));
        label_email.setForeground(Color.BLUE);

        label_mobileNumber = new JLabel("Mobile Number");
        label_mobileNumber.setBounds(150, 400, 150, 40);
        label_mobileNumber.setFont(new Font("Arial", Font.BOLD, 16));
        label_mobileNumber.setForeground(Color.BLUE);
                    
        title = new JTextField();
        title.setBounds(300, 50, 300, 40);
        
        firstName = new JTextField();
        firstName.setBounds(300, 100, 300, 40);
        
        lastName = new JTextField();
        lastName.setBounds(300, 150, 300, 40);
        
        dob = new JTextField();
        dob.setBounds(300, 200, 300, 40);
                
        username = new JTextField();
        username.setBounds(300, 250, 300, 40);
        
        password = new JTextField();
        password.setBounds(300, 300, 300, 40);
        
        email = new JTextField();
        email.setBounds(300, 350, 300, 40);
        
        mobileNumber = new JTextField();
        mobileNumber.setBounds(300, 400, 300, 40);
                
        signupButton = new JButton("Sign up");
        signupButton.setBounds(300, 450, 150, 20);
        signupButton.addActionListener(this);
        
        add(createAccountTitle);
        add(title);
        add(label_title);
        add(firstName);
        add(label_firstName);
        add(lastName);
        add(label_lastName);
        add(dob);
        add(label_dob);
        add(username);
        add(label_username);
        add(password);
        add(label_password);
        add(email);
        add(label_email);
        add(mobileNumber);
        add(label_mobileNumber);
        add(signupButton);
        
        setLayout(null);
        setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signupButton) {
            String t = title.getText();
            String first = firstName.getText();
            String last = lastName.getText();
            String birth = dob.getText();
            String user = username.getText();
            String pass = password.getText();
            String mail = email.getText();
            String mobileNum = mobileNumber.getText();
            
            try {
                int mobile = Integer.parseInt(mobileNum);
                Account account = new Account(user, pass, t, first, last, birth, mail, mobile);
                manager.addAccount(account);
                dispose();
            } catch (NumberFormatException ex) {
                // Handle invalid mobile number format
                System.out.println("Invalid mobile number");
            }
            
        }
    }
}
