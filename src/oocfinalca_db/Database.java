/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocfinalca_db;

/**
 *
 * @author caroo
 */
public abstract class Database {
    //Setting up the database local, credentials, DB, and table names 
    protected final static String DB_BASE_URL = "jdbc:mysql://localhost";
    protected final static String USER = "ooc2023";
    protected final static String PASSWORD = "ooc2023";
    protected final static String DB_NAME = "CA_TaxCalculation";
    protected final static String TABLE_NAME = "usersData_ca";
  
    protected final static String DB_URL = DB_BASE_URL + "/" + DB_NAME; //jdbc:mysql://localhost/ca_taxcalculation
}
