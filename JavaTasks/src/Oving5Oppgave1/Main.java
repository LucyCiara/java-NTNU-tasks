package Oving5Oppgave1;

public class Main {
    public static void main(String[] args) throws Exception{
        Fraction fractionOne = new Fraction(3, 4);
        Fraction fractionTwo = new Fraction(5,6);
        fractionOne.add(fractionTwo);
        System.out.println(fractionOne.result.getFractionString());
        fractionOne.subtract(fractionTwo);
        System.out.println(fractionOne.result.getFractionString());
        fractionOne.multiply(fractionTwo);
        System.out.println(fractionOne.result.getFractionString());
        fractionOne.divide(fractionTwo);
        System.out.println(fractionOne.result.getFractionString());
    }
}
