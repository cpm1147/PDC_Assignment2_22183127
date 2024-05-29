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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author willi
 */
public class Login extends JFrame implements ActionListener{
    
    JFrame frame;
    JPasswordField password;
    JTextField username;
    JLabel label_password, label_username, message, title;
    JButton loginButton, createAccount;
    JCheckBox showPassword;
    AccountManager manager;
    
    public Login(AccountManager manager)
    {
        this.manager = manager;
        
        frame = new JFrame("Plane Ticket Booking System");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = screenWidth / 2;
        int frameHeight = screenHeight / 2;
        
        frame.setLocation(350, 100);
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        title = new JLabel("Login");
        title.setBounds(200, 10, 100, 40);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        
        label_username = new JLabel("Username");
        label_username.setBounds(200, 50, 100, 40);
        label_username.setFont(new Font("Arial", Font.BOLD, 16));
        label_username.setForeground(Color.BLUE);
        
        label_password = new JLabel("Password");
        label_password.setBounds(200, 100, 100, 40);
        label_password.setFont(new Font("Arial", Font.BOLD, 16));
        label_password.setForeground(Color.BLUE);
        
        message = new JLabel("Message Here");
        message.setBounds(300, 250, 300, 40);
        
        username = new JTextField();
        username.setBounds(300, 50, 300, 40);
        
        password = new JPasswordField();
        password.setBounds(300, 100, 200, 40);
        
        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(300, 150, 200, 40);
        showPassword.addActionListener(this);
        
        loginButton = new JButton("Sign in");
        loginButton.setBounds(300, 220, 150, 20);
        loginButton.addActionListener(this);
        
        createAccount = new JButton("Create account");
        createAccount.setBounds(450, 220, 150, 20);
        createAccount.addActionListener(this);
        
        frame.add(title);
        frame.add(label_username);
        frame.add(username);
        frame.add(message);
        frame.add(label_password);
        frame.add(password);
        frame.add(showPassword);
        frame.add(loginButton);
        frame.add(createAccount);
        
        frame.setLayout(null);
        frame.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==loginButton)
        {
            String usernameText = username.getText();
            String passwordText = new String(password.getPassword());
            
            if(manager.userNameChecker(usernameText) && manager.passwordChecker(usernameText, passwordText))
                    {
                        message.setText("You successfully logged in");
                        message.setForeground(Color.GREEN);
                        frame.dispose();
                        BookingPage bookingPage = new BookingPage();
                    }
            else {
                message.setText("Invalid username or password");
                message.setForeground(Color.RED);
            }
        }
        
        if(e.getSource() == showPassword)
        {
            if(showPassword.isSelected())
            {
                password.setEchoChar((char) 0);
            }
            else {
                password.setEchoChar('*');
            }
        }
        
        if(e.getSource() == createAccount)
        {
            CreateAccountPage createAccount = new CreateAccountPage(manager);
        }
    }
    
}
