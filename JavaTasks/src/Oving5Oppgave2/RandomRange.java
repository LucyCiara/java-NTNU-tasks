package Oving5Oppgave2;

import java.util.Random;

public class RandomRange {
    private Random randomGen = new Random();

    // Random whole number generator
    public int nextWholeNumberRange(int start, int end){
        int multiplier = 1;
        if(Math.abs(end) < Math.abs(start)){
            int placeholder = end;
            end = start;
            start = placeholder;
        }
        if((end-start) == 0){
            throw new IllegalArgumentException("You can't have the range be zero, silly ;)");
        }else if((end-start) < 0){
            multiplier = -1;
        }
        int randomNumber = (this.randomGen.nextInt(Math.abs(end-start)))*multiplier+(start);
        return randomNumber;
    }

    // Random decimal number generator
    public double nextDecimalNumberRange(double start, double end){
        if((end-start) == 0){
            throw new IllegalArgumentException("You can't have the range be zero, silly ;)");
        }
        double randomNumber = (randomGen.nextDouble()*(end-start))+start;
        return randomNumber;
    }
}
