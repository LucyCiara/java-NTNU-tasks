package Oving2Oppgave1;
import java.util.Scanner;

public class Oving2Oppgave1{
    public static void main(String[] args) throws Exception {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Input year to check if it's a leap year: ");
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

        if((inputYear%100==0 && inputYear%400==0) || (inputYear%100!=0 && inputYear%4==0)){
            System.out.printf("The year %d is a leap year%n", inputYear);
        }else{
            System.out.printf("The year %d is NOT a leap year%n", inputYear);
        }
    }

}