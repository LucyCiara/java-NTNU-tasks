package Oving3Oppgave1;

public class Oving3Oppgave1 {
    public static void main(String[] args) throws Exception {
        int start = 13;
        int end = 15;
        for (int i = start; i <= end; i++){
            for (int j = 1; j <= 10; j++){
                System.out.printf("%d*%d=%d%n", i, j, i*j);
            }
        }
    }
}
