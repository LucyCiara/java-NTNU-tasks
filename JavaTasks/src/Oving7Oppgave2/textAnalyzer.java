package Oving7Oppgave2;



public class textAnalyzer {
    // Object Variables
    public String text;
    public String uppercaseText;
    private char[] punctuationChars = "[!\"#$%&'()*+,-./:;<=>?@[\\]^_{|}~]".toCharArray();
    private String sentenceEnders = "[!.:?]";
    private String[] wordArray;
    private String[] symbolInclusiveWordArray;
    private String[][] sentenceArray;

    // Constructor
    public textAnalyzer(String text){
        this.text = text;
        this.uppercaseText = text.toUpperCase();
        this.wordArray = this.wordArrayMaker(this.text, false);
        this.sentenceArray = this.sentenceArrayMaker(this.text);
        this.symbolInclusiveWordArray = this.wordArrayMaker(this.text, true);
    }

    // Private Methods
    private String[] wordArrayMaker(String text, Boolean symbolInclusive){
        String processedText = text;
        String[] returnArray = {};
        if(!symbolInclusive){
            for (char c : this.punctuationChars){
                processedText = processedText.replace(String.valueOf(c), "");
            }
            String[] processedArray = processedText.split(" ");
            int blanks = 0;
            for(String s : processedArray){
                if (s.equals("") || s.equals(" ")){
                    blanks++;
                }
            }
            String[] processedArray2 = new String[processedArray.length-blanks];
            int skips = 0;
            for(int i = 0; i < processedArray.length; i++){
                if(!processedArray[i].equals("") && !processedArray[i].equals(" ")){
                    processedArray2[i-skips] = processedArray[i];
                }else{
                    skips++;
                }
            }
            returnArray = processedArray2;
        }else{
            returnArray = processedText.split(" ");
        }

        return returnArray;
    }
    private String[][] sentenceArrayMaker(String text){
        String[] splitText = text.split(this.sentenceEnders);
        int blanks = 0;
        for(String s : splitText){
            if (s.equals("") || s.equals(" ")){
                blanks++;
            }
        }
        String[][] sentenceArray = new String[splitText.length-blanks][];
        int skips = 0;
        for(int i = 0; i < splitText.length; i++){
            if(!splitText[i].equals("") && !splitText[i].equals(" ")){
                String[] wordArray = this.wordArrayMaker(splitText[i], false);
                sentenceArray[i-skips] = wordArray;
            }else{
                skips++;
            }
        }
        return sentenceArray;
    }

    // Methods
    public int wordCount(){
        return this.wordArray.length;
    }
    public float avgWordLength(){
        int totalLength = 0;
        for(String s : this.wordArray){
            totalLength += s.length();
        }
        return (float) totalLength/this.wordArray.length;
    }
    public float avgSentenceWordLength(){
        int totalLength = 0;
        for(String[] sl : this.sentenceArray){
            totalLength += sl.length;
        }
        return (float) totalLength/(this.sentenceArray.length);
    }
    public String wordReplacer(String replace, String replacement){
        String[] localWordArray = this.symbolInclusiveWordArray;
        String returnString = "";
        for (int i = 0; i < localWordArray.length; i++){
            if(localWordArray[i].toLowerCase().equals(replace.toLowerCase())){
                if(localWordArray[i].toLowerCase().equals(localWordArray[i])){
                    localWordArray[i] = replacement.toLowerCase();
                }else if(localWordArray[i].toUpperCase().equals(localWordArray[i])){
                    localWordArray[i] = replacement.toUpperCase();
                }else{
                    char[] characterArray = replacement.toCharArray();
                    characterArray[0] = Character.toUpperCase(characterArray[0]);
                    localWordArray[i] = new String(characterArray);
                }
            }
            if (i == localWordArray.length-1){
                returnString += localWordArray[i];
            }else{
                returnString += localWordArray[i] + " ";
            }
        }
        return returnString;
    }
}
