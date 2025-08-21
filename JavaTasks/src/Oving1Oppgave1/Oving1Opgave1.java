package Oving1Oppgave1;
import java.util.Scanner;
public class Oving1Opgave1 {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Skriv inn tommene du vil konvertere til cm: ");
        double inputDouble = Double.parseDouble(inputScanner.next());
        System.out.printf("Det er ca. %.2fcm%n", inputDouble*2.54);
        inputScanner.close();
    }
}
