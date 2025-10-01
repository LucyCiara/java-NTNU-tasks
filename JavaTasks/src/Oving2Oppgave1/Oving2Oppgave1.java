package Oving2Oppgave1;
import java.util.Scanner;

public class Oving2Oppgave1{
    public static void main(String[] args) throws Exception {
        // Initiates the scanner as well as prints out a line to ask for input.
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Input year to check if it's a leap year: ");
        
        // Will take input until an accepted integer is given, returning a value error if you give an invalid input. Input year is also set to -1 by default, in case the while loop somehow gets skipped (the java interpreter wouldn't shut tf up).
        int inputYear = -1;
        boolean inputAccepted = false;
        while(!inputAccepted){
            try{
                inputYear = Integer.parseInt(inputScanner.next());
                inputAccepted = true;
            }catch (Exception ValueError){
                System.out.println(ValueError);
            }
        }

        // Check and outputs if the year is a leap year or not.
        if((inputYear%100==0 && inputYear%400==0) || (inputYear%100!=0 && inputYear%4==0)){
            System.out.printf("The year %d is a leap year%n", inputYear);
        }else{
            System.out.printf("The year %d is NOT a leap year%n", inputYear);
        }
        inputScanner.close();
    }

}