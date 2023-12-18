/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oocfinalca_db;

import java.sql.SQLException;

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
                //***************Codigo para verificar se a database foi criada*************************************
        if (SetupDB.setupDB()){
           System.out.println("Database and table created");
           
        }else {
            System.out.println("Oh no! There was a database creation problem...");
       }
            }
    
       }
    
    

