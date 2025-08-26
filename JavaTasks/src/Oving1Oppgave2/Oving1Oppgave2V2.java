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

public class Oving1Oppgave2V2 {
    public static void main(String[] args) throws Exception {

        String filePath = new File("").getAbsolutePath() + "/data/time.csv";

        BufferedReader timeReader = new BufferedReader(new FileReader(filePath));
        System.out.println(readerCSVFormater(timeReader));
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
        for (int i = 0; i < lineNestList.get(0).size(); i++){
            List<Double> timeUnits = new ArrayList<>();
            for (int j = 0; j < lineNestList.size(); j++){
                timeUnits.add(lineNestList.get(j).get(i));
            }
            CSVFileMap.put(keyStrings.get(i), new ArrayList<Double>(timeUnits));
            timeUnits.clear();
        }
        return CSVFileMap;
    }
}
