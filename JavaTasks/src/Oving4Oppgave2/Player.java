package Oving4Oppgave2;
import java.util.Random;

public class Player {
    String name;
    private int pointSum = 0;
    Random dice = new Random();

    public Player(String name){
        this.name = name;
    }

    public int getPointSum(){
        return pointSum;
    }
    
    public int diceRoll(){
        int diceRoll = dice.nextInt(6)+1;
        if(diceRoll == 1){
            pointSum = 0;
        }else{
            pointSum += diceRoll*(-(pointSum-100)/Math.abs(pointSum-100));
        }
        return diceRoll;
    }

    public int isDone(){
        if(pointSum < 100){
            return 0;
        }else if(pointSum == 100){
            return 1;
        }else{
            return 2;
        }
    }
}
