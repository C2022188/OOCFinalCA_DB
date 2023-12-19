/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocfinalca_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author caroo
 */
public class DatabaseReader extends Database {

    // Method to retrieve all users from the database
    public ArrayList<Users> getAllUsers() {
        ArrayList<Users> usersList =  new ArrayList<>();
        
        try (
            // Establishing a database connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement(); 
            ResultSet results = stmt.executeQuery(String.format(
                    "SELECT * FROM %s;",
                    TABLE_NAME));
        ) {
            // Iterating through the result set and retrieving user data
            while (results.next()) {
                // getting user data from the database
                int ID = results.getInt("ID");
                String firstName = results.getString("firstName");
                String lastName = results.getString("lastName");
                String email = results.getString("email");
                String PPSN = results.getString("PPSN");
                double grossIncome = results.getDouble("grossIncome");
                double taxCredit = results.getDouble("taxCredit");
                double taxOwed = results.getDouble("taxOwed");
                String username = results.getString("username");
                String password = results.getString("Password");
                
                // Creating an Admin and regular user object with the data from the database
               // Admin adm = new Admin(ID, firstName, lastName, email, PPSN, grossIncome, taxCredit, taxOwed, username, password);
                RegularUser regUser = new RegularUser(ID, firstName, lastName, email, PPSN, grossIncome, taxCredit, taxOwed, username, password);
                // Adding the Admin object to the usersList
               // usersList.add(adm);
                usersList.add(regUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return usersList; // Returning the list of users from the database
    }

    // Method to retrieve specific user data by ID
    public Users getUsersData(int UsersID) {
        try (
            // Establishing a database connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ) {
            // retrieve user data by ID
            ResultSet results = stmt.executeQuery(String.format(
                    "SELECT * FROM %s WHERE id=%d;",
                    TABLE_NAME, UsersID));
            results.next(); 

            // Retrieving user data from the database
            int ID = results.getInt("ID");
            String firstName = results.getString("firstName");
            String lastName = results.getString("lastName");
            String email = results.getString("email");
            String PPSN = results.getString("PPSN");
            double grossIncome = results.getDouble("grossIncome");
            double taxCredit = results.getDouble("taxCredit");
            double taxOwed = results.getDouble("taxOwed");
            String username = results.getString("username");
            String password = results.getString("Password");
            
            // Creating an RegularUser object with retrieved data
           // Admin adm = new Admin(ID, firstName, lastName, email, PPSN, grossIncome, taxCredit, taxOwed, username, password);
            RegularUser regUser = new RegularUser(ID, firstName, lastName, email, PPSN, grossIncome, taxCredit, taxOwed, username, password);
            return regUser; // Returning the Admin object
           
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

