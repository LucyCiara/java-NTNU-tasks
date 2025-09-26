package Oving7Oppgave1;

import java.util.ArrayList;


final class NewString{
    public final String value;

    // Constructor and toString.
    public NewString(String value){
        this.value = value;
    }
    public String toString(){
        return this.value;
    }

    // Methods
    public String shorten(){
        String shortString = "";
        String[] splitValue = this.value.split(" ");
        for(String i : splitValue){
            shortString += i.substring(0, 1);
        }
        return shortString;
    }
    public String remove(String letter){
        return this.value.replaceAll(letter, "");
    }
}
