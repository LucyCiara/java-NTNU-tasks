package Oving7Oppgave2;


public class Main {
    public static void main(String[] args) {
        String testText = "døs søs Jån ? ? Als, døs søs ? ? ? Cea tii, rmb.... !!!";
        textAnalyzer testAnalyzis = new textAnalyzer(testText);
        System.out.println(testAnalyzis.wordCount());
        System.out.println(testAnalyzis.avgWordLength());
        System.out.println(testAnalyzis.uppercaseText);
        System.out.println(testAnalyzis.avgSentenceWordLength());
        System.out.println(testAnalyzis.wordReplacer("this", "dis"));
    }
}
