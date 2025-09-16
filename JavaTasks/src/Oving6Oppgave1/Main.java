package Oving6Oppgave1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception{
        Random randomXD = new Random();
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        int n = 101;
        for(int i=0; i<n; i++){
            randoms.add(randomXD.nextInt(10));
        }
        for(int i=0; i<10; i++){
            int count = Collections.frequency(randoms, i);
            String stars;
            if(n <= 100){
                stars = "*".repeat((int) Math.round((double) count));
            }else{
                stars = "*".repeat((int) Math.round((double) count/(n/100)));
            }
            System.out.printf("%d %d %s%n", i, count, stars);
        }
    }
}
