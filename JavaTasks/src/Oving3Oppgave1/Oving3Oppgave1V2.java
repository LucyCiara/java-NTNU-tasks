package Oving3Oppgave1;

import java.util.Scanner;

public class Oving3Oppgave1V2 {
    public static void main(String[] args) throws Exception {
        Scanner inputScanner = new Scanner(System.in);
        int start = 0;
        int end = 0;
        boolean run = true;
        while(run){
            System.out.println();
            System.out.println("Skriv tallene du vil starte og slutte gangetabellene med i format 'tall,tall':");
            String inputText = inputScanner.next();
            if (inputText.equals("q") || inputText.equals("Q")){
                run = false;
            }else{
                try{
                    start = Integer.parseInt(inputText.split(",")[0]);
                    end = Integer.parseInt(inputText.split(",")[1]);
                    for (int i = start; i <= end; i++){
                        for (int j = 1; j <= 10; j++){
                            System.out.printf("%d*%d=%d%n", i, j, i*j);
                        }
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    System.err.println(e);
                    System.err.println("Har du husket å formatere inputet riktig?");
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
