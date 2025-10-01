package Oving6Oppgave2;

import java.util.Collections;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Map<String, Integer> testMap = Map.of("A", 3, "B", 5, "C", 2, "D", 5);
        System.out.println(Collections.max(testMap.entrySet(), Map.Entry.comparingByValue()).getKey());
    }
}
