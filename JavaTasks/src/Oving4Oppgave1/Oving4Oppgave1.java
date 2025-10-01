package Oving4Oppgave1;
import java.util.Scanner;


public class Oving4Oppgave1 {
    public static void main(String[] args) throws Exception{
        Valuta USD = new Valuta();
        USD.init(9.9701, "Dollar");
        Valuta EUR = new Valuta();
        EUR.init(11.7142, "Euro");
        Valuta SEK = new Valuta();
        SEK.init(1.0643, "Swedish Crown");

        Valuta selectedValuta = new Valuta();

        Scanner inputScanner = new Scanner(System.in);

        boolean run = true;
        while(run){
            System.out.printf("Choose your valuta:%n1) %s%n2) %s%n3) %s%n4) Quit%n", USD.name, EUR.name, SEK.name);
            String inputText = inputScanner.next();
            if(inputText.equals("4")){
                run = false;
            }else if(inputText.equals("3") || inputText.equals("2") || inputText.equals("1")){
                if(inputText.equals("3")){
                    selectedValuta = SEK;
                }else if(inputText.equals("2")){
                    selectedValuta = EUR;
                }else if(inputText.equals("1")){
                    selectedValuta = USD;
                }

                boolean run2 = true;
                while(run2){
                    System.out.printf("Choose operation:%n1) Convert from %s to Norwegian Crowns%n2) Convert from Norwegian Crowns to %s%n3) Quit%n", selectedValuta.name, selectedValuta.name);
                    String inputText2 = inputScanner.next();
                    Double inputAmount= 0.0;
                    if(inputText2.equals("3")){
                        run2 = false;
                    }else if(inputText2.equals("2") || inputText2.equals("1")){
                        boolean run3 = true;
                        while(run3){
                            System.out.println("Write the amount you want to convert:");
                            try{
                                inputAmount = Double.parseDouble(inputScanner.next());
                                run3 = false;
                            }catch(NumberFormatException e){
                                System.err.println(e);
                                System.err.println("You have to write a valid number");
                            }catch(Exception e){
                                System.err.println(e);
                            }
                        }
                        if(inputText2.equals("2")){
                            System.out.printf("%.2f NOK is equal to %.2f %s%n", inputAmount, selectedValuta.convertFromNok(inputAmount), selectedValuta.name);
                        }else if(inputText2.equals("1")){
                            System.out.printf("%.2f %s is equal to %.2f NOK%n", inputAmount, selectedValuta.name, selectedValuta.convertToNok(inputAmount));
                        }
                    }
                }
            }
        }
        inputScanner.close();
    }
}
