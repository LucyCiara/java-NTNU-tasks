package Oving8;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Employee pretend-database creation
        Employee[] companyEmployeeDatabase = {
            new Employee("Kåre", "Pettersen", 5, 10, 1982, 762, 2007, 30009.5,35.4),
            new Employee("Marta", "Fjellgård", 12, 4, 1978, 524, 2006, 23070.9, 32.1),
            new Employee("Xargyrinth-al-Yugoloth LXI", "The Destroyer of Worlds, and Crusher of Hope", 24, 8, -45239, 1247, 2018, 30492.1, 0.0),
            };

        // Variables
        Scanner inputScanner = new Scanner(System.in);

        // Program loop
        boolean run = true;
        while(run){
            System.out.println("Choose your operation:");
            System.out.println("0) Get information about employee");
            System.out.println("1) Set information about employee");
            System.out.println("q) Exit");
            String input = inputScanner.next();
            System.out.println();
            if (input.equals("q") || input.equals("Q")){
                run = false;
            }else if(input.equals("0") || input.equals("1")){
                boolean run2 = true;
                while(run2){
                    if(input.equals("0")){
                        getChoices();
                    }else if(input.equals("1")){
                        setChoices();
                    }
                    String input2 = inputScanner.next();
                    System.out.println();
                    if(input2.equals("q") || input2.equals("Q")){
                        run2 = false;
                    }else if((input.equals("0")&&(input2.equals("0") || input2.equals("1") || input2.equals("2") || input2.equals("3") || input2.equals("4") || input2.equals("5") || input2.equals("6") || input2.equals("7") || input2.equals("8") || input2.equals("9") || input2.equals("10")))||(input.equals("1")&&(input2.equals("0")||input2.equals("1")))){
                        boolean run3 = true;
                        while(run3){
                            employeeList(companyEmployeeDatabase);
                            String input3 = inputScanner.next();
                            System.out.println();
                            if(input3.equals("q") || input3.equals("Q")){
                                run3 = false;
                            }else{
                                try{
                                    if(input.equals("0")){
                                        if(input2.equals("0")){
                                            System.out.println(companyEmployeeDatabase[Integer.parseInt(input3)].getBirthDate());
                                        }else if(input2.equals("1")){
                                            System.out.println(companyEmployeeDatabase[Integer.parseInt(input3)].getAge());
                                        }else if(input2.equals("2")){
                                            System.out.println(companyEmployeeDatabase[Integer.parseInt(input3)].getEmployeeNumber());
                                        }else if(input2.equals("3")){
                                            System.out.println(companyEmployeeDatabase[Integer.parseInt(input3)].getHireYear());
                                        }else if(input2.equals("4")){
                                            System.out.println(companyEmployeeDatabase[Integer.parseInt(input3)].getMonthlyWage());
                                        }else if(input2.equals("5")){
                                            System.out.println(companyEmployeeDatabase[Integer.parseInt(input3)].getTaxPercentage() + "%");
                                        }else if(input2.equals("6")){
                                            System.out.println(companyEmployeeDatabase[Integer.parseInt(input3)].getMonthlyTaxPayout());
                                        }else if(input2.equals("7")){
                                            System.out.println(companyEmployeeDatabase[Integer.parseInt(input3)].getYearlyGrossWage());
                                        }else if(input2.equals("8")){
                                            System.out.println(companyEmployeeDatabase[Integer.parseInt(input3)].getYearlyTaxPayout());
                                        }else if(input2.equals("9")){
                                            System.out.println(companyEmployeeDatabase[Integer.parseInt(input3)].getYearsOfEmployment());
                                        }else if(input2.equals("10")){
                                            boolean run4 = true;
                                            while(run4){
                                                System.out.println("Type the number to check against:");
                                                String input4 = inputScanner.next();
                                                System.out.println();
                                                try{
                                                    System.out.printf("%s has worked longer than %s years: %b", companyEmployeeDatabase[Integer.parseInt(input3)], input4, companyEmployeeDatabase[Integer.parseInt(input3)].isHiredLongerThan(Integer.parseInt(input4)));
                                                }catch (Exception e){
                                                    System.out.println("Invalid input, try again.");
                                                    System.out.println();
                                                }
                                            }
                                        }
                                    }else if(input.equals("1")){
                                        boolean run4 = true;
                                        while(run4){
                                            System.out.println("Type the new value:");
                                            String input4 = inputScanner.next();
                                            try{
                                                if(input2.equals("0")){
                                                    companyEmployeeDatabase[Integer.parseInt(input3)].setMonthlyWage(Integer.parseInt(input4));
                                                }else if(input2.equals("1")){
                                                    companyEmployeeDatabase[Integer.parseInt(input3)].setMonthlyWage(Integer.parseInt(input4));
                                                }
                                                System.out.println("The value has been set");
                                                System.out.println();
                                                run4 = false;
                                            }catch (Exception e){
                                                System.out.println("Invalid input, try again.");
                                                System.out.println();
                                            }

                                        }

                                    }
                                }catch (Exception e) {
                                    System.out.println("Invalid input, try again.");
                                    System.out.println();
                                }
                            }
                        }
                    }else{
                        System.out.println("Invalid input, try again.");
                        System.out.println();
                    }
                }
            }else{
                System.out.println("Invalid input, try again.");
                System.out.println();
            }
        }
        inputScanner.close();
    }

    private static void employeeList(Employee[] employeeArray){
        System.out.println("Choose the employee:");
        for(int i = 0; i < employeeArray.length; i++){
            System.out.printf("%d) %s%n", i, employeeArray[i]);
        }
        System.out.println("q) Back");
    }

    private static void getChoices(){
        System.out.println("Choose what to get information about:");
        System.out.println("0) Get date of birth");
        System.out.println("1) Get age");
        System.out.println("2) Get employee number");
        System.out.println("3) Get hire year");
        System.out.println("4) Get monthly wage");
        System.out.println("5) Get tax percentage");
        System.out.println("6) Get monthly tax payout");
        System.out.println("7) Get yearly gross wage");
        System.out.println("8) Get yearly tax payout");
        System.out.println("9) Get number of years employed");
        System.out.println("10) Check if employee has been hired for longer than given time");
        System.out.println("q) Back");
    }

    private static void setChoices(){
        System.out.println("Choose what information to modify:");
        System.out.println("0) Set monthly wage");
        System.out.println("1) Set tax percentage");
        System.out.println("q) Back");
    }
}
