/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocfinalca_db;

/**
 *
 * @author caroo
 */
public abstract class Users implements UserOptions{



    private int ID;
    private static int currentID = 1;
    
    private String firstName;
    private String lastName;
    private String email;
    private String PPSN;
    private double grossIncome;
    private double taxCredit;
    private double taxOwed;
    private String username;
    private String password;

public Users(int ID, String firstName, String lastName, String email, String PPSN, double grossIncome, double taxCredit, double taxOwed, String username, String password) {
        this.ID = currentID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.PPSN = PPSN;
        this.grossIncome = grossIncome;
        this.taxCredit = taxCredit;
        this.taxOwed = taxOwed;
        this.username = username;
        this.password = password;
    }
public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPPSN(String PPSN) {
        this.PPSN = PPSN;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public void setTaxCredit(double taxCredit) {
        this.taxCredit = taxCredit;
    }

    public void setTaxOwed(double taxOwed) {
        this.taxOwed = taxOwed;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPPSN() {
        return PPSN;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public double getTaxCredit() {
        return taxCredit;
    }

    public double getTaxOwed() {
        return taxOwed;
    }



    public static int getCurrentID() {
        return currentID;
    }

    public int getID() {
        return ID;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public boolean isAdmin() {
        return getUsername().equals("Admin") && getPassword().equals("CCT");
    }
@Override
    public void executeUserOptions() {
       modifyOwnProfile();
       accessUserList();
       removeUser();
       reviewOperations();
    }

    public void modifyOwnProfile() {
     
    }
    
    public void accessUserList() {
      
    }

    public void removeUser() {
    
    }

    public void reviewOperations() {
        
    }


}
