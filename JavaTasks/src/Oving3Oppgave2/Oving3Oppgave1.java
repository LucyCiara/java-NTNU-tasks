package Oving3Oppgave2;

import java.util.Scanner;

public class Oving3Oppgave1 {
    public static void main(String[] args) throws Exception{
        Scanner inputScanner = new Scanner(System.in);
        boolean run = true;
        int number = 0;
        while(run){
            System.out.println();
            System.out.println("Skriv tallet du vil sjekke om er primtall:");
            String inputText = inputScanner.next();
            Boolean isPrime = true;
            if (inputText.equals("q") || inputText.equals("Q")){
                run = false;
            }else{
                try{
                    number = Integer.parseInt(inputText);

                    if (number > 1){                        
                        for (int i = 2; i < number; i++){
                            if (number%i == 0){
                                isPrime = false;
                            }
                        }
                    }else{
                        isPrime = false;
                    }

                    if (isPrime){
                        System.out.printf("%d er et primtall%n", number);
                    }else{
                        System.out.printf("%d er ikke et primtall%n", number);
                    }
                }catch(NumberFormatException e) {
                    System.err.println(e);
                    System.err.println("Du må skrive et gyldig heltall");
                }catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
        inputScanner.close();
    }
}
