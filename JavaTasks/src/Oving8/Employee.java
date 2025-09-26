package Oving8;

import java.util.Calendar;

public class Employee extends Person {
    private int employeeNumber;
    private int hireYear;
    private double monthlyWage;
    private double taxPercentage;
    // Constructor
    public Employee(){
        this("","");
    }
    public Employee(String firstName, String lastName){
        this(firstName, lastName, 1, 1, 2000, 0, 2025, 0.0,0.0);
    }
    public Employee(int birthday, int birthmonth, int birthyear, int employeeNumber, int hireYear){
        this("","",birthday,birthmonth,birthyear,employeeNumber,hireYear,0.0,0.0);
    }
    public Employee(double monthlyWage, double taxPercentage){
        this("","",1,1,2000,0,2025,monthlyWage,taxPercentage);
    }
    public Employee(String firstName, String lastName, int birthday, int birthmonth, int birthyear, int employeeNumber, int hireYear, double monthlyWage, double taxPercentage){
        super(firstName, lastName, birthday, birthmonth, birthyear);
        this.employeeNumber = employeeNumber;
        this.hireYear = hireYear;
        this.monthlyWage = monthlyWage;
        this.taxPercentage = taxPercentage;
    }

    
    // Public methods
    // // Get methods for object variables
    public int getEmployeeNumber(){
        return this.employeeNumber;
    }
    public int getHireYear(){
        return this.hireYear;
    }
    public double getMonthlyWage(){
        return this.monthlyWage;
    }
    public double getTaxPercentage(){
        return this.taxPercentage;
    }

    // // Get methods for non-object variables
    public double getMonthlyTaxPayout(){
        return this.monthlyWage-(this.monthlyWage*taxPercentage/100);
    }
    public double getYearlyGrossWage(){
        return this.monthlyWage*12;
    }
    public double getYearlyTaxPayout(){
        return this.getMonthlyTaxPayout()*10.5;
    }
    public int getYearsOfEmployment(){
        return super.presentTime.get(Calendar.YEAR)-this.hireYear;
    }

    // // Other public return-methods
    public boolean isHiredLongerThan(int years){
        if(this.getYearsOfEmployment() > years){
            return true;
        }else{
            return false;
        }
    }

    // // Set methods
    public void setMonthlyWage(double newMonthlyWage){
        this.monthlyWage = newMonthlyWage;
    }
    public void setTaxPercentage(double newTaxPercentage){
        this.taxPercentage = newTaxPercentage;  
    }
}
