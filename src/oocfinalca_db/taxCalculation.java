/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocfinalca_db;

/**
 *
 * @author danie
 */
public class taxCalculation extends Users{
    
   // Constructor inheriting properties from Users class
    public taxCalculation(int ID, String firstName, String lastName, String email, String PPSN,
                          double grossIncome, double taxCredit, double taxOwed,
                          String username, String password) {
        super(ID, firstName, lastName, email, PPSN, grossIncome, taxCredit, taxOwed, username, password);
    }
    
    // Method to calculate total tax credit for a single person per year
    public static double TaxCreditSingleYearly() {
        double singlePersonCredit = 1775.0;
        double employeeCredit = 1775.0;
        double totalTaxCredits = singlePersonCredit + employeeCredit;
        return totalTaxCredits; // Monthly tax credit amount
    }

    // Method to calculate total tax credit for a married person per year
    public static double TaxCreditMarriedYearly() {
        double marriedPersonCredit = 3550.0;
        double employeeCredit = 1775.0;
        double totalTaxCredits = marriedPersonCredit + employeeCredit;
        return totalTaxCredits; 
    }

    // Method to calculate PRSI based on gross income
    public static double calculatePRSI(double grossIncome) {
        double prsi;
        
        if (grossIncome <= 398) {
            prsi = grossIncome * 0.005; // 0.5% PRSI rate for income up to €398
        } else {
            double remainingIncome = grossIncome - 398;
            prsi = (398 * 0.005) + (remainingIncome * 0.02); // 0.5% up to €398, 2% above that
        }

        return prsi;
    }

    // Method to calculate USC based on gross income
    public static double calculateUSC(double grossIncome) {
        double rate1 = 0.005;
        double rate2 = 0.02;
        double rate3 = 0.045;

        double band1 = 12012.00;
        double band2 = 19068.00;

        double USC;
        
        if (grossIncome <= band1) {
            USC = grossIncome * rate1;
        } else if (grossIncome <= band2) {
            USC = (band1 * rate1) + ((grossIncome - band1) * rate2);
        } else {
            USC = (band1 * rate1) + ((band2 - band1) * rate2) + ((grossIncome - band2) * rate3);
        }
        
        return USC;
    }
}