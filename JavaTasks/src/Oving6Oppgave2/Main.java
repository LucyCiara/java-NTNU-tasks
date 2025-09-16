package Oving6Oppgave2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        String inpuString;
        Character letterToCheck;
        Scanner inputScanner = new Scanner(System.in);
        boolean run = true;
        while(run){
            try{
                System.out.println("Write the string you want to analyze, or q to quit:");
                inpuString = inputScanner.nextLine();
                if(inpuString.equals("q") || inpuString.equals("q")){
                    run = false;
                }else{
                    System.out.println("Write the character you want to check the frequency of:");
                    letterToCheck =  inputScanner.nextLine().charAt(0);
                    System.out.println("---");
                    TextAnalyzer testString = new TextAnalyzer(inpuString);
                    System.out.printf("The string you're analyzing is: %s%n", testString.value);
                    System.out.printf("The most frequent letter(s) is/are: %s%n", testString.mostFrequentLetter().toString());
                    System.out.printf("The frequency of letter %s is: %d%n", letterToCheck, testString.frequencyOfLetter(letterToCheck));
                    System.out.printf("The percentage of non-letter characters in the string is: %.2f%% %n", testString.percentOfNonLetterCharacters());
                    System.out.printf("The amount of different letter types is: %d%n", testString.amountOfLetterTypes());
                    System.out.printf("The amount of letters is the string is: %s%n%n", testString.numberOfLetters());
                }

            }catch (Exception e){
                System.err.println(e);
            }

        }
        inputScanner.close();
    }
}
