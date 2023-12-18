/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocfinalca_db;

/**
 *
 * @author caroo
 */
public abstract class Users{



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
}