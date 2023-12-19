/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oocfinalca_db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author caroo
 */


//GitHub link: https://github.com/C2022188/OOCFinalCA_DB.git
//Member 1: Carlos Daniel Amnbrosio 2022171
// Member 2: Caroline Ferreira 2022188


public class OOCFinalCA_DB {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
         
   
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
     
        Scanner system = new Scanner(System.in);
        // Display the main menu options to the user.
        System.out.println("\"WELCOME TO YOUR REVENUE TAX CALCULATION!\n" +
                               "CHOOSE AN OPTION:\n" +
                               "1: LOGIN\n" +
                               "2: SIGN UP");

        // Get the user's choice.
        int optionNum = system.nextInt();

        switch (optionNum) {
        case 1:
            Users User = login(); // Attempt to log in the user.
            if (User != null){
            System.out.println("Welcome " + User.getUsername() + "!");
            User.executeUserOptions();
                
            if (User.isAdmin()) { // Display additional options if the user is an admin.
                   
            System.out.println("Admin Menu:");
            System.out.println("1: Modify Your Profile");
            System.out.println("2: Access User List");
            System.out.println("3: Remove Users");
            System.out.println("4: Review Operations");
            System.out.println("0: Logout");

                }else { // Display regular user options.
            System.out.println("Regular Menu:");
            System.out.println("1: Modify Your Profile");
            System.out.println("2: Access User List");
            System.out.println("3: Other Admin Option"); // Adicione outras opções, se necessário
            System.out.println("0: Logout");     
                }
            }
                break;
                
        case 2:
            if (!userExists()) {
                if (newUser() == 0){
                    } else {
                    System.out.println("Error creating user.");
                    }
                    } else {
                    System.out.println("User already exists in the database. Please choose a different username.");
                }
                break;
                
                default:
                    System.out.println("Error!.");
                break;
                    }
            }

    // This method is in charge of logging in the user. It asks for a username and password, compares them to the database, and sends the user back if it works.
    public static Users login() {
        Scanner loginInput = new Scanner(System.in);

            String username;
            String password;
                            
            System.out.println("Username: ");
            username = loginInput.nextLine();
                            
            System.out.println("Password: ");
            password = loginInput.nextLine();
            
        // Check the database to see if the credentials given are valid for any user.                    
        DatabaseReader dbr = new DatabaseReader();
        ArrayList<Users> usersList = dbr.getAllUsers();
            for (Users user : usersList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Login successful
                }
            }
        return null; // Invalid username or password
            }
    
    // This method checks if a user with a given username already exists in the database.                    
    public static boolean userExists() {
        DatabaseReader dbr = new DatabaseReader();
        Scanner newUserInput = new Scanner(System.in);

            String username;
            
            System.out.println("Choose a username: ");
                    
            username = newUserInput.nextLine();
                         
        // Check the database to check if the username already exists.
        ArrayList<Users> usersList = dbr.getAllUsers();
            for (Users user : usersList) {
            if (user.getUsername().equals(username)) {
                return true; // User already exists
                
            }
        return false; // User not founded
            }

        return false;                    
    }
    
    
 public static double newUser() throws SQLException {

        Scanner UserInput = new Scanner(System.in);

            // Variable declarations for user details
            String firstName;
            String lastName;
            String email;
            String PPSN;
            double grossIncome;
            String username;
            String password;

            // Prompting user for input and storing in variables
            System.out.println("First Name: ");
            firstName = UserInput.nextLine();

            System.out.println("Last Name: ");
            lastName = UserInput.nextLine();

            System.out.println("Email: ");
            email = UserInput.nextLine();

            System.out.println("PPSN: ");
            PPSN = UserInput.nextLine();

            System.out.println("grossIncome: ");
            grossIncome = UserInput.nextDouble();
            UserInput.nextLine(); // Clearing the buffer after reading double

            System.out.println("Single or Married?");

            // Determining tax credit based on user input
            double singlePersonCredit = 1775.0;
            double marriedPersonCredit = 3550.0;
            double employeeCredit = 1775.0;

            String userInputString = UserInput.nextLine();
            double taxCredit = 0.0;

            if (userInputString.equalsIgnoreCase("Single")) {
            taxCredit = singlePersonCredit + employeeCredit;
                } else if (userInputString.equalsIgnoreCase("Married")) {
            taxCredit = marriedPersonCredit + employeeCredit;
                } else {
                    System.out.println("Error");
                }

            // Calculating PRSI and USC
            double prsi = taxCalculation.calculatePRSI(grossIncome);
            double usc = taxCalculation.calculateUSC(grossIncome);
            double taxOwed = prsi + usc;

            // Prompting for username and password
            System.out.println("To proceed with the registration, please enter your chosen USERNAME again: ");
            username = UserInput.nextLine();

            System.out.println("Please, enter your PASSWORD: ");
            password = UserInput.nextLine();

            // Creating an User object with user details
            RegularUser regUser = new RegularUser (0, firstName, lastName, email, PPSN, grossIncome, taxCredit, taxOwed, username, password);

            // Adding user to the database
            try {
            addToDatabase(regUser);
                } catch (SQLException e) {
                e.printStackTrace();
                }
            return 0; // Return 0 as an indication of completion
        }

     
    // Method to add a new user to the database
    public static void addToDatabase(RegularUser newUser) throws SQLException {
        DatabaseWriter dbw = new DatabaseWriter();
        boolean success = dbw.newUser(newUser);

        // Displaying success or error message based on database insertion
        if (success) {
            System.out.println("Success - New user added.");
        } else {
            System.out.println("Error.");
        }
        }
    
    }