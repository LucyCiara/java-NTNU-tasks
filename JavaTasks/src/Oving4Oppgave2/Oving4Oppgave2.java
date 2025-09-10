package Oving4Oppgave2;

import java.util.Scanner;

public class Oving4Oppgave2 {
    public static void main(String[] args) throws Exception{
        Player[] turnOrder = new Player[2];
        turnOrder[0] = new Player("Player 1");
        turnOrder[1] = new Player("Player 2");
        Scanner inputScanner = new Scanner(System.in);

        int i = 0;
        boolean run = true;
        while(run){
            System.out.printf("%s's turn, press enter to roll dice (input q to quit)%n", turnOrder[i].name);
            String inputString = inputScanner.nextLine();
            if(inputString.equals("q")){
                run = false;
            }else{
                System.out.printf("%s rolls a %d, their total points is %d%n%n-----%n%n", turnOrder[i].name, turnOrder[i].diceRoll(), turnOrder[i].getPointSum());
                if(turnOrder[i].isDone() == 1){
                    System.out.printf("%s wins!! congratulations!!!%n", turnOrder[i].name);
                    run = false;
                }
                if(i == 0){
                    i = 1;
                }else{
                    i = 0;
                }
            }
        }
        inputScanner.close();
    }
}
