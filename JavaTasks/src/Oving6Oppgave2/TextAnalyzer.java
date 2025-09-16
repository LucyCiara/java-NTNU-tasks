package Oving6Oppgave2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Collections;
import java.util.Map;

public class TextAnalyzer {
    // Class variables
    private ArrayList<Character> alphabet;
    public String value;

    // Constructor
    public TextAnalyzer(String value){
        this.value = value;
        int charNumber = 'z' - 'a' + 1;
        this.alphabet = new ArrayList<Character>();
        for(int i = 0; i < charNumber; i++){
            this.alphabet.add((char) ('a' + i));
        }
        this.alphabet.add('æ');
        this.alphabet.add('å');
        this.alphabet.add('ø');
        
    }

    // Private methods
    private Map<Character, Integer> letterCount(){
        Map<Character, Integer> characterCount = new Hashtable<>();
        Character[] valueCharArray = this.value.toLowerCase().chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        ArrayList<Character> characters = new ArrayList<Character>(Arrays.asList(valueCharArray));
        for(int i = 0; i < this.alphabet.size(); i++){
            characterCount.put(this.alphabet.get(i), Collections.frequency(characters, this.alphabet.get(i)));
        }
        return characterCount;
    }

    // Public methods
    public int numberOfLetters(){
        ArrayList<Integer> characterCounts = new ArrayList<Integer>(this.letterCount().values());
        int sum = 0;
        for(int num : characterCounts){
            sum += num;
        }
        return sum;
    }
    public double percentOfNonLetterCharacters(){
        return 100-(double) this.numberOfLetters()/this.value.length()*100;
    }
    public int frequencyOfLetter(Character letter){
        if(this.alphabet.contains(Character.toLowerCase(letter))){
            return this.letterCount().get(Character.toLowerCase(letter));
        }else{
            throw new IllegalArgumentException("You need to input a letter from the norwegian alphabet.");
        }
    }
    public int amountOfLetterTypes(){
        int letterTypeCounter = 0;
        for(int count : this.letterCount().values()){
            if(count != 0){
                letterTypeCounter++;
            }
        }
        return letterTypeCounter;
    }
    public ArrayList<Character> mostFrequentLetter(){
        ArrayList<Character> mostFrequentLetterAL = new ArrayList<Character>();
        for(Character key : this.letterCount().keySet()){
            if(this.letterCount().get(key) == Collections.max(this.letterCount().values())){
                mostFrequentLetterAL.add(key);
            }
        }
        return mostFrequentLetterAL;
    }
}
