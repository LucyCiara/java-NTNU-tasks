package Oving1Oppgave2;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import com.opencsv.CSVReader;
// import java.util.ArrayList;
import java.util.List;

public class Oving1Oppgave2 {
    public static void main(String[] args) throws Exception {

        String filePath = new File("").getAbsolutePath() + "/data/time.csv";

        BufferedReader timeReader = new BufferedReader(new FileReader(filePath));
        // CSVReader csvTimeReader = new CSVReader(timeReader);
        // List<String[]> times = csvTimeReader.readAll();
        // System.out.println(times);
        // csvTimeReader.close();
    }
}
