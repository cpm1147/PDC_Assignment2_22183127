/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Plane_Ticket_Booking_System;

import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class AccountManager {
    private ArrayList<Account> accounts;

    public AccountManager() {
        accounts = new ArrayList<>();
    }
    
    public void addAccount(Account account) {
        accounts.add(account);
    }

    public boolean userNameChecker(String input) {
        for(Account account : accounts) {
            if(account.getUsername().equals(input)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean passwordChecker(String username, String password) {
        for(Account account : accounts) {
            if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
