package Oving1Oppgave2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
// import com.opencsv.CSVReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Oving1Oppgave2V2 {
    public static void main(String[] args) throws Exception {

        String filePath = new File("").getAbsolutePath() + "/data/time.csv";

        BufferedReader timeReader = new BufferedReader(new FileReader(filePath));
        Map<String, List<Double>> CSVFileMap = readerCSVFormater(timeReader);
        List<String> keyList = new ArrayList<>(CSVFileMap.keySet());
        for(int i = 0; i < CSVFileMap.get(keyList.get(0)).size(); i++){
            Double totalSecondCalc = 0.0;
            totalSecondCalc += CSVFileMap.get("hours").get(i)*Math.pow(60, 2);
            totalSecondCalc += CSVFileMap.get("minutes").get(i)*60;
            totalSecondCalc += CSVFileMap.get("seconds").get(i);
            System.out.printf("%.2f hours, %.2f minutes and %.2f seconds is equal to %2f seconds according to my calculations, and %2f according to the dataset%n", CSVFileMap.get("hours").get(i), CSVFileMap.get("minutes").get(i), CSVFileMap.get("seconds").get(i), totalSecondCalc, CSVFileMap.get("secondtotal").get(i));
        }
        
    }

    public static Map<String, List<Double>> readerCSVFormater(BufferedReader reader) throws IOException {
        Map<String, List<Double>> CSVFileMap = new HashMap<String, List<Double>>();
        List<List<Double>> lineNestList = new ArrayList<>();
        String[] lineArray;
        List<String> keyStrings = new ArrayList<>();
        List<Double> lineDoubleList = new ArrayList<>();
        String line = new String();
        while((line = reader.readLine()) != null){
            try{
                System.out.println(line);
                lineArray = line.split(",");
                for (int i = 0; i < lineArray.length; i++){
                    lineDoubleList.add(Double.parseDouble(lineArray[i]));
                }
                lineNestList.add(new ArrayList<Double>(lineDoubleList));
                lineDoubleList.clear();
            }catch(Exception e){
                keyStrings = Arrays.asList(line.split(","));
            }

        }
        for(int i = 0; i < lineNestList.get(0).size(); i++){
            List<Double> timeUnits = new ArrayList<>();
            for(int j = 0; j < lineNestList.size(); j++){
                timeUnits.add(lineNestList.get(j).get(i));
            }
            CSVFileMap.put(keyStrings.get(i), new ArrayList<Double>(timeUnits));
            timeUnits.clear();
        }
        return CSVFileMap;
    }
}
