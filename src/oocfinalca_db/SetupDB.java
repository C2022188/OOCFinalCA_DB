/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocfinalca_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author caroo
 */
public class SetupDB extends Database{
    
    public static boolean setupDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            // This code creates a new database, selects it, and creates a table if it does not already exist.
             Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try(
                // Connect to the database server using the credentials provided.
                Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
            stmt.execute("USE " + DB_NAME + ";");
            //Define the SQL statement that will be used to create the table
            String sql = 
                    "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + "id INT PRIMARY KEY,"
                    + "firstName VARCHAR(255),"
                    + "lastName VARCHAR(255),"
                    + "email VARCHAR(255),"
                    + "PPSN VARCHAR(255),"
                    + "grossIncome DOUBLE(10, 2),"
                    + "taxCredit DOUBLE(10, 2),"
                    + "taxOwed DOUBLE (10, 2),"
                    + "username VARCHAR(255),"
                    + "password VARCHAR(255)"
                    + ");";
            stmt.execute(sql);
            return true; // Return true if the database setup was successful.
        
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false if the database setup failed.
}
}
}
