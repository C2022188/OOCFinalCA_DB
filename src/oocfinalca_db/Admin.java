/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocfinalca_db;

/**
 *
 * @author danie
 */
// created the class admin that is extending to parent class Users
public class Admin extends Users{
    // inherited the constructor from the main class
    public Admin(int ID, String firstName, String lastName, String email, String PPSN, double grossIncome, double taxCredit, double taxOwed, String username, String password) {
        super(ID, firstName, lastName, email, PPSN, grossIncome, taxCredit, taxOwed, username, password);
    }
   
    
    @Override
   public void modifyOwnProfile() {
      
        
   }
    @Override
     public void accessUserList() {
      
    }

    @Override
    public void removeUser() {
    
    }

    @Override
    public void reviewOperations() {
        
    }
}
