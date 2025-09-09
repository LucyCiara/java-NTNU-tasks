package Oving4Oppgave1;

public class Valuta {
    double ratio;
    String name;
    public void init(double ratio, String name){
        this.ratio = ratio;
        this.name = name;
    }

    double convertToNok(double valuta) {
        return valuta*this.ratio;
    }

    double convertFromNok(double nok) {
        return nok/this.ratio;
    }
}
