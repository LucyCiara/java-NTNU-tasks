package Oving5Oppgave1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) throws Exception{
        Fraction fraction = new Fraction(25, 360);
        int[] results = fraction.simplify(fraction.getNumerator(), fraction.getDenominator());
        for(int item : results){
            System.out.println(item);
        }
        
    }
}
