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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateAccountPage extends JFrame implements ActionListener {
    
    private JComboBox title;
    private JTextField firstName, lastName, dob, username, email, mobileNumber;
    private JPasswordField password;
    private JLabel label_title, label_firstName, label_lastName, label_dob, label_username, label_password, label_email, label_mobileNumber, createAccountTitle;
    private JButton signupButton;
    private JCheckBox showPassword;
    private AccountManager manager;

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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        createAccountTitle = new JLabel("Create account");
        createAccountTitle.setBounds(150, 10, 200, 40);
        createAccountTitle.setFont(new Font("Arial", Font.BOLD, 20));
        
        label_title = new JLabel("Title");
        label_title.setBounds(150, 50, 100, 40);
        label_title.setFont(new Font("Arial", Font.BOLD, 16));
        label_title.setForeground(Color.BLUE);
        
        label_firstName = new JLabel("First Name");
        label_firstName.setBounds(150, 100, 100, 40);
        label_firstName.setFont(new Font("Arial", Font.BOLD, 16));
        label_firstName.setForeground(Color.BLUE);
        
        label_lastName = new JLabel("Last Name");
        label_lastName.setBounds(150, 150, 100, 40);
        label_lastName.setFont(new Font("Arial", Font.BOLD, 16));
        label_lastName.setForeground(Color.BLUE);
        
        label_dob = new JLabel("DOB (dd/mm/yyyy)");
        label_dob.setBounds(150, 200, 200, 40);
        label_dob.setFont(new Font("Arial", Font.BOLD, 16));
        label_dob.setForeground(Color.BLUE);
        
        label_username = new JLabel("Username");
        label_username.setBounds(150, 250, 100, 40);
        label_username.setFont(new Font("Arial", Font.BOLD, 16));
        label_username.setForeground(Color.BLUE);
        
        label_password = new JLabel("Password");
        label_password.setBounds(150, 300, 100, 40);
        label_password.setFont(new Font("Arial", Font.BOLD, 16));
        label_password.setForeground(Color.BLUE);
        
        label_email = new JLabel("Email");
        label_email.setBounds(150, 350, 100, 40);
        label_email.setFont(new Font("Arial", Font.BOLD, 16));
        label_email.setForeground(Color.BLUE);

        label_mobileNumber = new JLabel("Mobile Number");
        label_mobileNumber.setBounds(150, 400, 150, 40);
        label_mobileNumber.setFont(new Font("Arial", Font.BOLD, 16));
        label_mobileNumber.setForeground(Color.BLUE);
                  
        String[] titles = {"Mr", "Mrs", "Ms", "Miss", "Master"};
        
        title = new JComboBox(titles);
        title.setBounds(300, 50, 300, 40);
        
        firstName = new JTextField();
        firstName.setBounds(300, 100, 300, 40);
        
        lastName = new JTextField();
        lastName.setBounds(300, 150, 300, 40);
        
        dob = new JTextField();
        dob.setBounds(300, 200, 300, 40);
                
        username = new JTextField();
        username.setBounds(300, 250, 300, 40);
        
        password = new JPasswordField();
        password.setBounds(300, 300, 300, 40);
        
        email = new JTextField();
        email.setBounds(300, 350, 300, 40);
        
        mobileNumber = new JTextField();
        mobileNumber.setBounds(300, 400, 300, 40);
        
        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(300, 440, 200, 40);
        showPassword.addActionListener(this);
                
        signupButton = new JButton("Sign up");
        signupButton.setBounds(300, 480, 150, 20);
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
        add(showPassword);
        
        setLayout(null);
        setVisible(true); 
    }

    private boolean isValidDateFormat(String dob) {
    String format = "\\d{2}/\\d{2}/\\d{4}";
    return dob.matches(format);
    }
    
    private boolean isValidEmail(String email) {
    String emailFormat = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z0-9]+$";
    return email.matches(emailFormat);
}
    
    @Override
    public void actionPerformed(ActionEvent e) {
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
        
        if(e.getSource() == signupButton) {
            String t = (String) title.getSelectedItem();
            String first = firstName.getText();
            String last = lastName.getText();
            String birth = dob.getText();
            String user = username.getText();
            String pass = new String(password.getPassword());
            String mail = email.getText();
            String mobileNum = mobileNumber.getText();
            
            if (!isValidDateFormat(birth)) {
            JOptionPane.showMessageDialog(this, "Please enter DOB in dd/mm/yyyy format", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
            }
            
             if (!isValidEmail(mail)) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
            }
            
            try {
                int mobile = Integer.parseInt(mobileNum);
                Account account = new Account(user, pass, t, first, last, birth, mail, mobile);
                manager.addAccount(account);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Not a valid mobile number", "Error", JOptionPane.ERROR_MESSAGE);
            }            
        }
    }
}
