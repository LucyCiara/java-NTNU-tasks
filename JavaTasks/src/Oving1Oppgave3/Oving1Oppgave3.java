package Oving1Oppgave3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Oving1Oppgave3 {
    public static void main(String[] args) throws Exception {
        // Finds the file path for the dataset CSV file.
        String filePath = new File("").getAbsolutePath() + "/data/time.csv";

        // Creates a buffered reader based on the dataset's CSV file, which is then converted into a formated Map using a dedicated method.
        BufferedReader timeReader = new BufferedReader(new FileReader(filePath));
        Map<String, List<Double>> CSVFileMap = readerCSVFormater(timeReader);

        // A for loop, which iterates through each column to convert the total seconds into a HH:MM:SS format, and compares to the dataset.
        List<String> keyList = new ArrayList<>(CSVFileMap.keySet());
        for(int i = 0; i < CSVFileMap.get(keyList.get(0)).size(); i++){
            Double seconds = CSVFileMap.get("secondtotal").get(i);
            Double hours = Math.floor(seconds / Math.pow(60, 2));
            seconds %= Math.pow(60, 2);
            Double minutes = Math.floor(seconds/60);
            seconds %= 60;
            System.out.printf("%.2f total seconds is equal to %.2f hour(s), %.2f minute(s) and %.2f second(s) according to my calculations, and %.2f hour(s), %.2f minute(s) and %.2f second(s) according to the data set.%n", CSVFileMap.get("secondtotal").get(i), hours, minutes, seconds, CSVFileMap.get("hours").get(i), CSVFileMap.get("minutes").get(i), CSVFileMap.get("seconds").get(i));
        }

        // Takes user input to convert into a HH:MM:SS format.
        Scanner inputReader = new Scanner(System.in);
        System.out.print("Write the amount of seconds you want to convert into the HH:MM:SS format: ");
        boolean run = true;
        while(run){
            try{
                Double inputDouble = Double.parseDouble(inputReader.next());
                Double seconds = inputDouble;
                Double hours = Math.floor(seconds / Math.pow(60, 2));
                seconds %= Math.pow(60, 2);
                Double minutes = Math.floor(seconds/60);
                seconds %= 60;
                System.out.printf("%n%.2f total seconds is equal to %.2f hours, %.2f minutes and %.2f seconds", inputDouble, hours, minutes, seconds);
                run = false;
            }catch(Exception e){
                System.out.println("Please write a valid number.");
            }
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
