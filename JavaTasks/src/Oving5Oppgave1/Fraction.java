package Oving5Oppgave1;

public class Fraction {
    // Variable definition
    private int numerator;
    private int denominator;
    public Fraction result;

    // Constructors
    public Fraction(int num){
        this(num, 1);
    }
    public Fraction(int num, int denom){
        if(denom == 0){
            throw new IllegalArgumentException("Denominator can't be zero, silly ;)");
        }
        this.numerator = num;
        this.denominator = denom;
    }

    // Accessors
    public int getNumerator(){
        return this.numerator;
    }
    public int getDenominator(){
        return this.denominator;
    }
    public double getDecimalValue(){
        return this.numerator/this.denominator;
    }
    public String getFractionString(){
        return String.format("%d/%d", numerator, denominator);
    }

    // Operations
    private int[] simplify(int num, int denom){
        int i = 2;
        while(i <= Math.abs(num) && i <= Math.abs(denom)){
            if(num%i==0 && denom%i==0){
                num /= i;
                denom /= i;
                i = 2;
            }else{
                i++;
            }
        }
        int[] fractionList = {num, denom};
        return fractionList;
    }
    public void add(Fraction otherFraction){
        int resultNum = (this.numerator*otherFraction.getDenominator()+otherFraction.getNumerator()*this.denominator);
        int resultDenom = (this.denominator*otherFraction.getDenominator());
        int[] simplifiedFraction = this.simplify(resultNum, resultDenom);
        this.result = new Fraction(simplifiedFraction[0], simplifiedFraction[1]);   
    }
    public void subtract(Fraction otherFraction){
        int resultNum = (this.numerator*otherFraction.getDenominator()-otherFraction.getNumerator()*this.denominator);
        int resultDenom = (this.denominator*otherFraction.getDenominator());
        int[] simplifiedFraction = this.simplify(resultNum, resultDenom);
        this.result = new Fraction(simplifiedFraction[0], simplifiedFraction[1]);        
    }
    public void multiply(Fraction otherFraction){
        int resultNum = (this.numerator*otherFraction.getNumerator());
        int resultDenom = (this.denominator*otherFraction.getDenominator());
        int[] simplifiedFraction = this.simplify(resultNum, resultDenom);
        this.result = new Fraction(simplifiedFraction[0], simplifiedFraction[1]);         
    }
    public void divide(Fraction otherFraction){
        int resultNum = (this.numerator*otherFraction.getDenominator());
        int resultDenom = (this.denominator*otherFraction.getNumerator());
        int[] simplifiedFraction = this.simplify(resultNum, resultDenom);
        this.result = new Fraction(simplifiedFraction[0], simplifiedFraction[1]);     
    }
}
