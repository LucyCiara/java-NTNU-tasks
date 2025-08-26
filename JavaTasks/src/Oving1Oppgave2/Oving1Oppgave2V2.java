package Oving1Oppgave2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Oving1Oppgave2V2 {
    public static void main(String[] args) throws Exception {
        // Finds the file path for the dataset CSV file.
        String filePath = new File("").getAbsolutePath() + "/data/time.csv";

        // Creates a buffered reader based on the dataset's CSV file, which is then converted into a formated Map using a dedicated method.
        BufferedReader timeReader = new BufferedReader(new FileReader(filePath));
        Map<String, List<Double>> CSVFileMap = readerCSVFormater(timeReader);

        // A for loop, which iterates through each column to count the total seconds and output them in the terminal.
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
        // Defines the Map which will be returned at the end of the method.
        Map<String, List<Double>> CSVFileMap = new HashMap<String, List<Double>>();
        // Defines a nested List, which will keep the unformated information after it's converted to Doubles.
        List<List<Double>> lineNestList = new ArrayList<>();
        // Defines a List of what will become the CSVFileMap's keys.
        List<String> keyStrings = new ArrayList<>();
        // Defines a List of Doubles, which will contain the information of each line converted into Doubles.
        List<Double> lineDoubleList = new ArrayList<>();

        // A while loop which adds the necessary information (converted into Doubles) to lineNestList if it's possible to convert into a Double, and adds it to keyStrings if it can't (like if it's the names of each column, like at the top row).
        String line = new String();
        while((line = reader.readLine()) != null){
            try{
                String[] lineArray = line.split(",");
                for (int i = 0; i < lineArray.length; i++){
                    lineDoubleList.add(Double.parseDouble(lineArray[i]));
                }
                lineNestList.add(new ArrayList<Double>(lineDoubleList));
                lineDoubleList.clear();
            }catch(Exception e){
                keyStrings = Arrays.asList(line.split(","));
            }

        }
        // A for loop which creates the CSVFileMap from the information in the lineNestList and the keyStrings.
        // I realise that the way I formated it might be ill fitted for the exact task, but it's a pretty standard CSV format, which allows for keys based on the top line.
        // If I were to make less universal, but more fitted code in the readerCSVFormater method, I might have kept the file information as a nested List.
        for(int i = 0; i < lineNestList.get(0).size(); i++){
            List<Double> timeUnits = new ArrayList<>();
            for(int j = 0; j < lineNestList.size(); j++){
                timeUnits.add(lineNestList.get(j).get(i));
            }
            CSVFileMap.put(keyStrings.get(i), new ArrayList<Double>(timeUnits));
            timeUnits.clear();
        }
        // Returns a formated Map of the CSV file's information.
        return CSVFileMap;
    }
}
